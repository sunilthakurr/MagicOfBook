package BookStore;



import java.sql.*;
import java.util.*;

public class MagicOfBooks {
    private Map<Integer, Book> books = new HashMap<>();

    public void addBook(Book book) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO Books (title, author, genre, price, best_selling) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, book.getTitle());
                stmt.setString(2, book.getAuthor());
                stmt.setString(3, book.getGenre());
                stmt.setDouble(4, book.getPrice());
                stmt.setBoolean(5, book.isBestSelling());
                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    book.setId(rs.getInt(1));
                    books.put(book.getId(), book);
                }
            }
        }
    }

    public void deleteBook(int id) throws SQLException, BookNotFoundException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM Books WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected == 0) {
                    throw new BookNotFoundException("Book with id " + id + " not found.");
                }
                books.remove(id);
            }
        }
    }

    public void updateBook(Book book) throws SQLException, BookNotFoundException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE Books SET title = ?, author = ?, genre = ?, price = ?, best_selling = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, book.getTitle());
                stmt.setString(2, book.getAuthor());
                stmt.setString(3, book.getGenre());
                stmt.setDouble(4, book.getPrice());
                stmt.setBoolean(5, book.isBestSelling());
                stmt.setInt(6, book.getId());
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected == 0) {
                    throw new BookNotFoundException("Book with id " + book.getId() + " not found.");
                }
                books.put(book.getId(), book);
            }
        }
    }

    public Collection<Book> displayAllBooks() {
        return books.values();
    }

    public int getTotalCountOfBooks() {
        return books.size();
    }

    public List<Book> getBooksByGenre(String genre) {
        List<Book> genreBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                genreBooks.add(book);
            }
        }
        return genreBooks;
    }

    public List<Book> getBooksSortedByPrice(boolean ascending) {
        List<Book> sortedBooks = new ArrayList<>(books.values());
        sortedBooks.sort((b1, b2) -> ascending ? Double.compare(b1.getPrice(), b2.getPrice()) : Double.compare(b2.getPrice(), b1.getPrice()));
        return sortedBooks;
    }

    public List<Book> getBestSellingBooks() {
        List<Book> bestSellingBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isBestSelling()) {
                bestSellingBooks.add(book);
            }
        }
        return bestSellingBooks;
    }
}


