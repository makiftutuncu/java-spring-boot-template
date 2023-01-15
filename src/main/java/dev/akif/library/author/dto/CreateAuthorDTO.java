package dev.akif.library.author.dto;

import dev.akif.crud.BaseCreateDTO;
import dev.akif.library.author.data.AuthorEntity;
import dev.akif.library.author.model.Author;
import dev.akif.library.author.model.CreateAuthor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record CreateAuthorDTO(
        @NotBlank String name,
        @NotNull LocalDate birthDate
) implements BaseCreateDTO<UUID, Author, AuthorEntity, CreateAuthor> {
    @Override
    public CreateAuthor toCreateModel() {
        return new CreateAuthor(name, birthDate);
    }
}
