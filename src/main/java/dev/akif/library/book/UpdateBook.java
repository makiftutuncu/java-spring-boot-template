package dev.akif.library.book;

import dev.akif.crud.CRUDUpdateModel;

public record UpdateBook(
        String isbn,
        String title
) implements CRUDUpdateModel {
}
