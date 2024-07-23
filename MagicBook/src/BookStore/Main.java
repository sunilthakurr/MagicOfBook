package BookStore;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            BookStore.MagicOfBooks mob = new BookStore.MagicOfBooks();


            Scanner scanner = new Scanner(System.in);
            while (true) {

                System.out.println("*** WELCOME TO ADMIN PAGE OF BOOKSTORE ***");
                System.out.println();
                System.out.println("1. Add Book");
                System.out.println("2. Delete Book");
                System.out.println("3. Update Book");
                System.out.println("4. Display all the  Books");
                System.out.println("5. Total count of books");
                System.out.println("6. Total count of Books under Autobiography genre");
                System.out.println("7. Arrange Book in Price low to high order");
                System.out.println("8. Arrange Book in Price high to low order");
                System.out.println("9. Display best selling books");
                System.out.println("Enter your choice: ");
                int choice1 = scanner.nextInt();
//                BookStore.MagicOfBooks mob = new BookStore.MagicOfBooks();
                switch (choice1) {
                    case 1:
//                        BookStore.MagicOfBooks mob = new BookStore.MagicOfBooks();
                        System.out.println("Enter book id");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter book Title");
                        String title = scanner.nextLine();
                        System.out.println("Enter the Author name");
                        String author = scanner.nextLine();
                        System.out.println("Enter the genre name");
                        String genre = scanner.nextLine();
                        System.out.println("Enter the price");
                        float price = scanner.nextFloat();
                        System.out.println("Is this book bestselling");
                        boolean isBestSeller = scanner.nextBoolean();

                        BookStore.Book book = new BookStore.Book(id, title, author, genre, price, isBestSeller);
                        mob.addBook(book);
                        break;

                    case 2:
                        System.out.println("Enter book id you want to delete");
                        int idTobeDeleted = scanner.nextInt();
                        mob.deleteBook(idTobeDeleted);
                        break;

                    case 3:
                        System.out.println("Enter book id to be updated");
                        int idToBeUpdated = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter book Title");
                        String titletoBeUpdated = scanner.nextLine();
                        System.out.println("Enter the Author name");
                        String authortoBeUpdated = scanner.nextLine();
                        System.out.println("Enter the genre name");
                        String genretoBeUpdated = scanner.nextLine();
                        System.out.println("Enter the price");
                        float pricetoBeUpdated = scanner.nextFloat();
                        System.out.println("Is this book bestselling");
                        boolean isBestSellertoBeUpdated = scanner.nextBoolean();

                        BookStore.Book booktoBeUpdated = new BookStore.Book(idToBeUpdated, titletoBeUpdated, authortoBeUpdated, genretoBeUpdated, pricetoBeUpdated, isBestSellertoBeUpdated);
                        mob.updateBook(booktoBeUpdated);
                        break;

                    case 4:
                        System.out.println("All books:");
                        for (Book books : mob.displayAllBooks()) {
                            System.out.println(books);
                        }
                        break;

                    case 5:
                        System.out.println("Total count of books: " + mob.getTotalCountOfBooks());
                        break;

                    case 6:
                        System.out.println("Autobiography books:");
                        for (Book books : mob.getBooksByGenre("Autobiography")) {
                            System.out.println(books);
                        }
                        break;

                    case 7:
                        System.out.println("Books sorted by price (low to high):");
                        for (Book books : mob.getBooksSortedByPrice(true)) {
                            System.out.println(books);
                        }
                        break;

                    case 8:
                        System.out.println("Books sorted by price (high to low):");
                        for (Book books : mob.getBooksSortedByPrice(false)) {
                            System.out.println(books);
                        }
                        break;

                    case 9:
                        System.out.println("Best-selling books:");
                        for (Book books : mob.getBestSellingBooks()) {
                            System.out.println(books);
                        }
                        break;

                    default:
                        System.out.println("Enter valid choice");
                        break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (BookNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
