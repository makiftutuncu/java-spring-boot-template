package dev.akif.library.author;

import dev.akif.crud.CRUDCreateDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateAuthorDTO(
        @NotBlank String name,
        @NotNull LocalDate birthDate
) implements CRUDCreateDTO {
}
