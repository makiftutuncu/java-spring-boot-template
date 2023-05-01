package dev.akif.library.book;

import dev.akif.crud.CRUDServiceTest;
import dev.akif.library.authorbook.BookWithAuthors;
import org.junit.jupiter.api.DisplayName;

@DisplayName("BookService")
class BookServiceTest extends CRUDServiceTest<Long, BookEntity, BookWithAuthors, CreateBook, UpdateBook, BookMapper, BookRepository, BookService, BookTestData> {
    public BookServiceTest() {
        super(
                new BookMapper(),
                BookTestHelper.INSTANCE.testData,
                (mapper, testData) -> new BookService(testData.getInstantProvider(), BookTestHelper.INSTANCE.repository, mapper)
        );
    }

    @Override
    protected void resetData() {
        BookTestHelper.INSTANCE.repository.reset();
    }
}
