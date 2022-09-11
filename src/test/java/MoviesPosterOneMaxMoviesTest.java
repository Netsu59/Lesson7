import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MoviesPosterOneMaxMoviesTest {
    @Mock
    private MoviesPosterRepository repository;
    @InjectMocks
    private MoviesPosterManager moviePosterManager = new MoviesPosterManager(1);
    private Movies first = new Movies(1,1,"Святые из Бундока","Криминал");
    private Movies second = new Movies(2,2,"Залечь на дно в Брюгге","Криминал");


    @Test
    void shouldReturnOneLastMovieTwo() {
        Movies[] returned = new Movies[]{first,second};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{second};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

    @Test
    void shouldReturnOneLastMovieOne() {
        Movies[] returned = new Movies[]{first};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{first};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

    @Test
    void shouldReturnOneLastMovieZero() {
        Movies[] returned = new Movies[]{};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

}
