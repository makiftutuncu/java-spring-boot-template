package dev.akif.library.author.dto;

import dev.akif.crud.BaseUpdateDTO;
import dev.akif.library.author.data.AuthorEntity;
import dev.akif.library.author.model.Author;
import dev.akif.library.author.model.UpdateAuthor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateAuthorDTO(
        @NotBlank String name,
        @NotNull LocalDate birthDate
) implements BaseUpdateDTO<UUID, Author, AuthorEntity, UpdateAuthor> {
    @Override
    public UpdateAuthor toUpdateModel() {
        return new UpdateAuthor(name, birthDate);
    }
}
