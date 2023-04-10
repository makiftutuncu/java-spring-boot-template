package dev.akif.library.author;

public enum AuthorTestHelper {
    INSTANCE;

    public final AuthorTestData testData = new AuthorTestData();
    public final InMemoryAuthorRepository repository = new InMemoryAuthorRepository(testData);
}
