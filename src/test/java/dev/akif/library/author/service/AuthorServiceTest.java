package dev.akif.library.author.service;

import dev.akif.library.author.data.AuthorEntity;
import dev.akif.library.author.data.AuthorRepository;
import dev.akif.library.author.model.Author;
import dev.akif.library.author.model.CreateAuthor;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("AuthorService")
class AuthorServiceTest {
    public static final Instant NOW = Instant.now();
    private static final Clock clock = Clock.fixed(Instant.EPOCH, ZoneOffset.UTC);

    private AuthorRepository repository;
    private AuthorService service;

    @BeforeEach
    void setUp() {
        repository = mock(AuthorRepository.class);
        doNothing().when(repository).flush();

        service = new AuthorService(clock, repository);
    }

    @AfterEach
    void reset() {
        Mockito.reset(repository);
    }

    @DisplayName("creating authors")
    @Nested
    class CreatingAuthors {
        @Test
        @DisplayName("should create an author")
        void shouldCreateAnAuthor() {
            final var id = UUID.randomUUID();
            final var name = "Mehmet Akif Tutuncu";
            final var birthDate = LocalDate.of(1991, 3, 23);
            final var createAuthor = new CreateAuthor(name, birthDate);
            final var authorEntity = new AuthorEntity(id, 0, NOW, NOW, false, name, birthDate);

            when(repository.save(any(AuthorEntity.class))).thenReturn(authorEntity);

            final var expected = new Author(id, 0, NOW, NOW, name, birthDate);

            final var actual = service.create(createAuthor);

            assertEquals(expected, actual);
            verify(repository, times(1)).save(any(AuthorEntity.class));
        }
    }
}
