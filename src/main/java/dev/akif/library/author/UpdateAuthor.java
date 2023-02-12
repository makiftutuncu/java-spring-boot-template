package dev.akif.library.author;

import dev.akif.crud.CRUDUpdateModel;

import java.time.LocalDate;

public record UpdateAuthor(String name, LocalDate birthDate) implements CRUDUpdateModel {
}
