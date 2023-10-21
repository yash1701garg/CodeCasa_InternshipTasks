import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Book {
    private String title;
    private boolean available;
    public Book(String title) {
        this.title = title;
        this.available = true;
    }
    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return available;
    }
    public void borrow() {
        available = false;
    }
    public void returnBook() {
        available = true;
    }
}
public class DigitalLibraryManagementSystem{
    public static void main(String[] args) {
        List<Book> library = new ArrayList<>();
        library.add(new Book("Book 1"));
        library.add(new Book("Book 2"));
        library.add(new Book("Book 3"));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. User Mode");
            System.out.println("2. Admin Mode");
            System.out.println("3. Exit");
            System.out.print("Select a mode: ");
            int modeChoice = scanner.nextInt();
            switch (modeChoice) {
                case 1:
                    userMode(library, scanner);
                    break;
                case 2:
                    adminMode(library, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void userMode(List<Book> library, Scanner scanner) {
        while (true) {
            System.out.println("User Mode");
            System.out.println("1. View Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewAvailableBooks(library);
                    break;
                case 2:
                    borrowBook(library, scanner);
                    break;
                case 3:
                    returnBook(library, scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void adminMode(List<Book> library, Scanner scanner) {
        while (true) {
            System.out.println("Admin Mode");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addBook(library, scanner);
                    break;
                case 2:
                    removeBook(library, scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    private static void viewAvailableBooks(List<Book> library) {
        System.out.println("Available Books:");
        for (Book book : library) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle());
            }
        }
    }

    private static void borrowBook(List<Book> library, Scanner scanner) {
        System.out.print("Enter the title of the book you want to borrow: ");
        String title = scanner.next();
        for (Book book : library) {
            if (book.isAvailable() && book.getTitle().equalsIgnoreCase(title)) {
                book.borrow();
                System.out.println("You have successfully borrowed " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found or already checked out.");
    }

    private static void returnBook(List<Book> library, Scanner scanner) {
        System.out.print("Enter the title of the book you want to return: ");
        String title = scanner.next();
        for (Book book : library) {
            if (!book.isAvailable() && book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                System.out.println("You have successfully returned " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found or not checked out by you.");
    }

    private static void addBook(List<Book> library, Scanner scanner) {
        System.out.print("Enter the title of the book to add: ");
        String title = scanner.next();
        library.add(new Book(title));
        System.out.println("Book added: " + title);
    }

    private static void removeBook(List<Book> library, Scanner scanner) {
        System.out.print("Enter the title of the book to remove: ");
        String title = scanner.next();
        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                library.remove(book);
                System.out.println("Book removed: " + title);
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }
}
