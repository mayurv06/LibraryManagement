import java.util.Scanner;
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    public Book(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;
        this.author = "Unknown";
        this.isAvailable = true;
    }
    public int getBookId() {
        return bookId;
    }
    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book already borrowed.");
        }
    }
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not borrowed.");
        }
    }
    public void displayBookDetails() {
        System.out.println("---------------------------------");
        System.out.println("Book ID     : " + bookId);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Status      : " + (isAvailable ? "Available" : "Borrowed"));
    }
}

public class Library {
    static Scanner sc = new Scanner(System.in);
    static Book[] books = new Book[10]; // Fixed size array
    static int count = 0;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n====== Library Management System ======");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.out.println("Exiting system... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }
    static void addBook() {
        if (count >= books.length) {
            System.out.println("Library is full. Cannot add more books.");
            return;
        }

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books[count] = new Book(id, title, author);
        count++;

        System.out.println("Book added successfully.");
    }

  static void displayBooks() {
        if (count == 0) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < count; i++) {
            books[i].displayBookDetails();
        }
    }

    static void searchBook() {
        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                books[i].displayBookDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    static void borrowBook() {
        System.out.print("Enter Book ID to borrow: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                books[i].borrowBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

   
    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                books[i].returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
