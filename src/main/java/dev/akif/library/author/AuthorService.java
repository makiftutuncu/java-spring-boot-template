package dev.akif.library.author;

import dev.akif.crud.CRUDService;
import dev.akif.crud.common.InstantProvider;
import dev.akif.crud.common.Parameters;
import dev.akif.library.authorbook.AuthorWithBooks;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthorService extends CRUDService<UUID, AuthorEntity, AuthorWithBooks, CreateAuthor, UpdateAuthor, AuthorRepository, AuthorMapper> {
    public AuthorService(final InstantProvider instantProvider,
                         final AuthorRepository repository,
                         final AuthorMapper mapper) {
        super("Author", instantProvider, repository, mapper);
    }

    @Override
    protected AuthorEntity createUsingRepository(final AuthorEntity authorEntity, final Parameters parameters) {
        return getRepository().save(authorEntity);
    }

    @Nullable
    @Override
    protected AuthorEntity getUsingRepository(final UUID uuid, final Parameters parameters) {
        return getRepository().findByIdAndDeletedAtIsNull(uuid);
    }

    @Override
    protected Page<AuthorEntity> listUsingRepository(final Pageable pageable, final Parameters parameters) {
        return getRepository().findAllByDeletedAtIsNull(pageable);
    }

    @Override
    protected int updateUsingRepository(final AuthorEntity authorEntity, final Parameters parameters) {
        return getRepository().update(authorEntity);
    }
}
