package dev.akif.library.author.simplest;

import dev.akif.crud.simplest.SimplestRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SimplestAuthorRepository extends SimplestRepository<UUID, SimplestAuthorEntity> {
}
