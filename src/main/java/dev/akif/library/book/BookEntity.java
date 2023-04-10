package dev.akif.library.book;

import dev.akif.crud.CRUDEntity;
import dev.akif.library.author.AuthorEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "books")
@ToString
public class BookEntity extends CRUDEntity<Long> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String isbn;

    private String title;

    @Fetch(FetchMode.JOIN)
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "books")
    @ToString.Exclude
    @Where(clause = "deleted_at IS NULL")
    private List<AuthorEntity> authors;

    private Integer version;

    private Instant createdAt;

    private Instant updatedAt;

    private Instant deletedAt;

    public BookEntity(
            final Long id,
            final String isbn,
            final String title,
            final List<AuthorEntity> authors,
            final Integer version,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public BookEntity(
            final String isbn,
            final String title,
            final Instant now
    ) {
        this(null, isbn, title, new ArrayList<>(), 0, now, now, null);
    }

    public BookEntity() {
        this(null, null, null, null, null, null, null, null);
    }
}
