package BookStore;


public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private double price;
    private boolean bestSelling;

    // Constructors, getters, and setters

    public Book() {}

    public Book(int id, String title, String author, String genre, double price, boolean bestSelling) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.bestSelling = bestSelling;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBestSelling() {
        return bestSelling;
    }

    public void setBestSelling(boolean bestSelling) {
        this.bestSelling = bestSelling;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", bestSelling=" + bestSelling +
                '}';
    }
}
