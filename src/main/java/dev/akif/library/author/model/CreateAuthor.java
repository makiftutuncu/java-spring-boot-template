package dev.akif.library.author.model;

import dev.akif.crud.BaseCreateModel;
import dev.akif.library.author.data.AuthorEntity;

import java.time.LocalDate;
import java.util.UUID;

public record CreateAuthor(String name, LocalDate birthDate) implements BaseCreateModel<UUID, Author, AuthorEntity> {
    @Override
    public AuthorEntity toEntity() {
        return new AuthorEntity(name, birthDate);
    }
}
