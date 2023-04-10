package dev.akif.library.book;

public enum BookTestHelper {
    INSTANCE;

    public final BookTestData testData = new BookTestData();
    public final InMemoryBookRepository repository = new InMemoryBookRepository(testData);
}
