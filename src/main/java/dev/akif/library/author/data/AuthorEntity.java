package dev.akif.library.author.data;

import dev.akif.crud.BaseEntity;
import dev.akif.library.author.model.Author;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "author")
@Getter
@Table(name = "authors")
@Setter
@ToString(callSuper = true)
public class AuthorEntity extends BaseEntity<UUID, Author> {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    public AuthorEntity(
            final UUID id,
            final int version,
            final Instant createdAt,
            final Instant updatedAt,
            final boolean deleted,
            final String name,
            final LocalDate birthDate
    ) {
        super(id, version, createdAt, updatedAt, deleted);
        this.name = name;
        this.birthDate = birthDate;
    }

    public AuthorEntity(final String name, final LocalDate birthDate) {
        this(UUID.randomUUID(), 0, null, null, false, name, birthDate);
    }

    public AuthorEntity() {
        this(null, null);
    }

    @Override
    public Author toModel() {
        return new Author(getId(), getVersion(), getCreatedAt(), getUpdatedAt(), name, birthDate);
    }
}
