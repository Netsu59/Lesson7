import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MoviesPosterDefaultMaxMoviesTest {
    @Mock
    private MoviesPosterRepository repository;
    @InjectMocks
    private MoviesPosterManager moviePosterManager = new MoviesPosterManager();
    private Movies first = new Movies(1,1,"Святые из Бундока","Криминал");
    private Movies second = new Movies(2,2,"Залечь на дно в Брюгге","Криминал");

    private Movies third = new Movies(3,3,"Драйв","Криминал");

    private Movies fourth = new Movies(4,4,"Охота","Драма");

    private Movies fifth = new Movies(5,5,"Дилер 2","Криминал");

    private Movies sixth = new Movies(6,6,"Поймай меня, если сможешь","Криминал");

    private Movies seventh = new Movies(7,7,"Сталкер","Фантастика");

    private Movies eigth = new Movies(8,8,"Пятое чувство","Ужасы");

    private Movies ninth = new Movies(9,9,"Камон камон","Драма");

    private Movies tenth = new Movies(10,10,"Старикам тут не место","Криминал");
    private Movies eleventh = new Movies(11,11,"Джентльмены","Криминал");


    @Test
    void shouldReturnTenLastMoviesTen() {
        Movies[] returned = new Movies[]{first,second,third,fourth,fifth,sixth,seventh,eigth,ninth,tenth};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{tenth,ninth,eigth,seventh,sixth,fifth,fourth,third,second,first};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

    @Test
    void shouldReturnTenLastMoviesEleven() {
        Movies[] returned = new Movies[]{first,second,third,fourth,fifth,sixth,seventh,eigth,ninth,tenth,eleventh};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{eleventh,tenth,ninth,eigth,seventh,sixth,fifth,fourth,third,second};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

    @Test
    void shouldReturnTenLastMoviesNine() {
        Movies[] returned = new Movies[]{first,second,third,fourth,fifth,sixth,seventh,eigth,ninth};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{ninth,eigth,seventh,sixth,fifth,fourth,third,second,first};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

    @Test
    void shouldReturnTenLastMoviesOne() {
        Movies[] returned = new Movies[]{first};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{first};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

    @Test
    void shouldReturnTenLastMoviesZero() {
        Movies[] returned = new Movies[]{};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

}
