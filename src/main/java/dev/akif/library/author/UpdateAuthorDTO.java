package dev.akif.library.author;

import dev.akif.crud.CRUDUpdateDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateAuthorDTO(
        @NotBlank String name,
        @NotNull LocalDate birthDate
) implements CRUDUpdateDTO {
}
