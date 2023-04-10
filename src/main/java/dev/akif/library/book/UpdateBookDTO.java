package dev.akif.library.book;

import dev.akif.crud.CRUDUpdateDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateBookDTO(
        @NotNull String isbn,
        @NotBlank String title
) implements CRUDUpdateDTO {
}
