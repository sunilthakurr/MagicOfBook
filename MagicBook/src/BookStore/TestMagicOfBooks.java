package BookStore;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class TestMagicOfBooks {

    @Test
    public void testAddBook() throws Exception {
        MagicOfBooks mob = new MagicOfBooks();
        Book book = new Book(0, "Title1", "Author1", "Genre1", 29.99, false);
        mob.addBook(book);
        assertTrue(mob.displayAllBooks().contains(book));
    }

    // Additional test cases for other methods
}
