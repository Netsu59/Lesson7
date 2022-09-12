public class MoviesPosterManager {
    private MoviesPosterRepository repository;

    private int maxMoviesCount;

    public MoviesPosterManager() { maxMoviesCount = 10; }

    public MoviesPosterManager(int maxMovies) {
        this.maxMoviesCount = maxMovies;
    }

    private Movies[] movies = new Movies[0];

    public void add(Movies movie) {
        int length = movies.length + 1;
        Movies tmp[] = new Movies[length];
        for(int i = 0; i < movies.length; i++){
            tmp[i] = movies[i];
        }
        int lastIndex = tmp.length-1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movies[] findLast(){
        Movies[] repositoryResult = repository.findAll();
        int resultLength;
        if(repositoryResult.length >= maxMoviesCount){
            resultLength = maxMoviesCount;
        } else {
            resultLength = repositoryResult.length;
        }
        Movies result[] = new Movies[resultLength];
        for(int i = 0; i < result.length; i++){
            int index = repositoryResult.length - i - 1;
            result[i] = repositoryResult[index];
        }
        return result;
    }

}
