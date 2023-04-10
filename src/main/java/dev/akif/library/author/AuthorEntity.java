package dev.akif.library.author;

import dev.akif.crud.CRUDEntity;
import dev.akif.library.book.BookEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "authors")
@ToString
public class AuthorEntity extends CRUDEntity<UUID> {
    @Id
    private UUID id;

    private String name;

    private LocalDate birthDate;

    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "authors_books", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    @Where(clause = "deleted_at IS NULL")
    private List<BookEntity> books;

    private Integer version;

    private Instant createdAt;

    private Instant updatedAt;

    private Instant deletedAt;

    public AuthorEntity(
            final UUID id,
            final String name,
            final LocalDate birthDate,
            final List<BookEntity> books,
            final Integer version,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.books = books;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public AuthorEntity(final String name, final LocalDate birthDate, final Instant now) {
        this(null, name, birthDate, new ArrayList<>(), 0, now, now, null);
    }

    public AuthorEntity() {
        this(null, null, null);
    }
}
