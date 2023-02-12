package dev.akif.library.author.simple;

import dev.akif.crud.simple.SimpleRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SimpleAuthorRepository extends SimpleRepository<UUID, SimpleAuthorEntity> {
}
