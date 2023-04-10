package dev.akif.library.book;

import dev.akif.crud.CRUDCreateModel;

public record CreateBook(
        String isbn,
        String title
) implements CRUDCreateModel {
}
