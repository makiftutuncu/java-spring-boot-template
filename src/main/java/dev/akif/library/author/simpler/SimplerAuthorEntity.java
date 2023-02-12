package dev.akif.library.author.simpler;

import dev.akif.crud.simpler.SimplerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "authors")
@ToString(callSuper = true)
public class SimplerAuthorEntity extends SimplerEntity<UUID, SimplerAuthorEntity> {
    private String name;
    private LocalDate birthDate;

    public SimplerAuthorEntity(
            final UUID id,
            final String name,
            final LocalDate birthDate,
            final int version,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        super(id, version, createdAt, updatedAt, deletedAt);
        this.name = name;
        this.birthDate = birthDate;
    }

    public SimplerAuthorEntity(final String name, final LocalDate birthDate, final Instant now) {
        this(UUID.randomUUID(), name, birthDate, 0, now, now, null);
    }

    public SimplerAuthorEntity() {
        this(null, null, null);
    }
}
