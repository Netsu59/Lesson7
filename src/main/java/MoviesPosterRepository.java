import java.net.http.HttpClient;

public class MoviesPosterRepository {

    private Movies[] movies = new Movies[0];

    public Movies[] findAll(){
        Movies[] result = new Movies[movies.length];
        for(int i = 0;i < result.length;i++){
            int index = i;
            result[i] = movies[index];
        }
        return result;
    }



}
