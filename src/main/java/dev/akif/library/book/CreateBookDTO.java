package dev.akif.library.book;

import dev.akif.crud.CRUDCreateDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateBookDTO(
        @NotNull String isbn,
        @NotBlank String title
) implements CRUDCreateDTO {
}
