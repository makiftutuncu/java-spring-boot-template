package dev.akif.library.author.data;

import dev.akif.crud.CRUDRepository;
import dev.akif.library.author.model.Author;
import org.springframework.data.repository.Repository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface AuthorRepository extends CRUDRepository<UUID, Author, AuthorEntity>, Repository<AuthorEntity, UUID> {
}
