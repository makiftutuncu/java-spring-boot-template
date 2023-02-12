package dev.akif.library.author;

import dev.akif.crud.CRUDCreateModel;

import java.time.LocalDate;

public record CreateAuthor(String name, LocalDate birthDate) implements CRUDCreateModel {
}
