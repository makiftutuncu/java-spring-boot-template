package dev.akif.library.book;

import dev.akif.crud.CRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CRUDRepository<Long, BookEntity> {
}
