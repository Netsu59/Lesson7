import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MoviesPosterTwentyMaxMoviesTest {
    @Mock
    private MoviesPosterRepository repository;
    @InjectMocks
    private MoviesPosterManager moviePosterManager = new MoviesPosterManager(20);
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

    private Movies twelfth = new Movies(12,12,"Зеленая книга","Комедия/драма");

    private Movies thirteenth = new Movies(13,13,"Великий","Драма");

    private Movies fourteenth = new Movies(14,14,"Железная хватка","Вестерн");

    private Movies fifteenth = new Movies(15,15,"Счастливое число Слевина","Криминал");

    private Movies sixteenth = new Movies(16,16,"Пираты Карибского моря","Приключения");

    private Movies seventeenth = new Movies(17,17,"Разрушение","Драма");

    private Movies eighteenth = new Movies(18,18,"Нечто","Ужасы");

    private Movies nineteenth = new Movies(19,19,"Чужой","Ужасы");

    private Movies twentieth = new Movies(20,20,"Реальные упыри","Комедия");

    private Movies twentyFirst = new Movies(21,21,"Остров проклятых","Детектив");



    @Test
    void shouldReturnTwentyLastMoviesFromTwentyMoviesRepository() {
        Movies[] returned = new Movies[]{first,second,third,fourth,fifth,sixth,seventh,eigth,ninth,tenth,eleventh,twelfth,thirteenth,fourteenth,fifteenth,sixteenth,seventeenth,eighteenth,nineteenth,twentieth};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{twentieth,nineteenth,eighteenth,seventeenth,sixteenth,fifteenth,fourteenth,thirteenth,twelfth,eleventh,tenth,ninth,eigth,seventh,sixth,fifth,fourth,third,second,first};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

    @Test
    void shouldReturnTwentyLastMoviesFromTwentyOneMoviesRepository() {
        Movies[] returned = new Movies[]{first,second,third,fourth,fifth,sixth,seventh,eigth,ninth,tenth,eleventh,twelfth,thirteenth,fourteenth,fifteenth,sixteenth,seventeenth,eighteenth,nineteenth,twentieth,twentyFirst};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{twentyFirst,twentieth,nineteenth,eighteenth,seventeenth,sixteenth,fifteenth,fourteenth,thirteenth,twelfth,eleventh,tenth,ninth,eigth,seventh,sixth,fifth,fourth,third,second};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

    @Test
    void shouldReturnNineteenMovies() {
        Movies[] returned = new Movies[]{first,second,third,fourth,fifth,sixth,seventh,eigth,ninth,tenth,eleventh,twelfth,thirteenth,fourteenth,fifteenth,sixteenth,seventeenth,eighteenth,nineteenth};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{nineteenth,eighteenth,seventeenth,sixteenth,fifteenth,fourteenth,thirteenth,twelfth,eleventh,tenth,ninth,eigth,seventh,sixth,fifth,fourth,third,second,first};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

    @Test
    void shouldReturnOneMovie() {
        Movies[] returned = new Movies[]{first};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{first};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

    @Test
    void shouldReturnTwentyLastMoviesZero() {
        Movies[] returned = new Movies[]{};
        doReturn(returned).when(repository).findAll();

        Movies[] expected = new Movies[]{};
        Movies[] actual = moviePosterManager.findLast();
        assertArrayEquals(expected,actual);

        verify(repository).findAll();
    }

}

