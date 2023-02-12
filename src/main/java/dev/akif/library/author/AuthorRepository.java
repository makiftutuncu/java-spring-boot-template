package dev.akif.library.author;

import dev.akif.crud.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends CRUDRepository<UUID, AuthorEntity> {
}
