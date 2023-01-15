package dev.akif.library.author.model;

import dev.akif.crud.BaseUpdateModel;
import dev.akif.library.author.data.AuthorEntity;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateAuthor(String name, LocalDate birthDate) implements BaseUpdateModel<UUID, Author, AuthorEntity> {
    @Override
    public void applyUpdatesTo(final AuthorEntity entity) {
        entity.setName(name);
        entity.setBirthDate(birthDate);
    }
}
