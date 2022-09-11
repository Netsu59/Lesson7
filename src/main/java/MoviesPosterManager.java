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


//    Сделайте так, чтобы по умолчанию выводилось последние 10 добавленных фильмов,
//    но при создании менеджера можно было указать другое число, чтобы, например, выдавать 5 (а не 10).
//    Т.е. у вас у менеджера должно быть два конструктора: один без параметров, выставляющий лимит менеджера в 10,
//    а другой с параметром, берущий значение лимита для менеджера из параметра конструктора.

//    Метод получения последних фильмов будет очень похож на тот что был в лекции.
//    Основное отличие будет в том, что вам в его начале надо будет вычислить правильный ожидаемый размер результирующего массива-ответа,
//    а не просто брать длину массива что лежит в поле;
//    сделать это можно заведя целочисленную переменную в которую вы сохраните желаемый размер создаваемого массива,
//    вычислите с помощью условных операторов для неё значение, а затем только создадите массив указав эту переменную как требуемый для него размер,
//    например:




    // 0 элементов в системе при 5 элементах
    // 1 элементов в системе при 5 элементах
    // 4 элементов в системе при 5 элементах
    // 5 элементов в системе при 5 элементах
    // 6 элементов в системе при 5 элементах

}
