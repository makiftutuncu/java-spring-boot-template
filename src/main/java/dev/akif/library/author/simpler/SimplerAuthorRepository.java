package dev.akif.library.author.simpler;

import dev.akif.crud.simpler.SimplerRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SimplerAuthorRepository extends SimplerRepository<UUID, SimplerAuthorEntity> {
}
