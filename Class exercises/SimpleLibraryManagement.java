import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int bookID;
    String title;
    boolean isAvailable;

    public Book(int bookID, String title) {
        this.bookID = bookID;
        this.title = title;
        this.isAvailable = true;  // Book is available by default
    }
}

class Member {
    int memberID;
    String name;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(int memberID, String name) {
        this.memberID = memberID;
        this.name = name;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    // Add a new book to the library
    public void addBook(int bookID, String title) {
        books.add(new Book(bookID, title));
    }

    // Register a new member
    public void addMember(int memberID, String name) {
        members.add(new Member(memberID, name));
    }

    // Borrow a book
    public void borrowBook(int memberID, int bookID) {
        Book book = findBook(bookID);
        Member member = findMember(memberID);

        if (book != null && member != null && book.isAvailable) {
            book.isAvailable = false;
            member.borrowedBooks.add(book);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book not available or member not found.");
        }
    }

    // Return a book
    public void returnBook(int memberID, int bookID) {
        Book book = findBook(bookID);
        Member member = findMember(memberID);

        if (book != null && member != null && member.borrowedBooks.contains(book)) {
            book.isAvailable = true;
            member.borrowedBooks.remove(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Invalid return attempt.");
        }
    }

    // List all available books
    public void listAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable) {
                System.out.println("Book ID: " + book.bookID + ", Title: " + book.title);
            }
        }
    }

    // Find book by ID
    private Book findBook(int bookID) {
        for (Book book : books) {
            if (book.bookID == bookID) {
                return book;
            }
        }
        return null;
    }

    // Find member by ID
    private Member findMember(int memberID) {
        for (Member member : members) {
            if (member.memberID == memberID) {
                return member;
            }
        }
        return null;
    }
}

public class SimpleLibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Adding sample data
        library.addBook(101, "The Great Gatsby");
        library.addBook(102, "1984");
        library.addMember(1, "Alice");
        library.addMember(2, "Bob");

        int choice;
        do {
            System.out.println("\nLibrary Management:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Available Books");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    library.addBook(bookID, title);
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    int memberID = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    System.out.print("Enter Member Name: ");
                    String name = scanner.nextLine();
                    library.addMember(memberID, name);
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    memberID = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    bookID = scanner.nextInt();
                    library.borrowBook(memberID, bookID);
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    memberID = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    bookID = scanner.nextInt();
                    library.returnBook(memberID, bookID);
                    break;

                case 5:
                    System.out.println("Available Books:");
                    library.listAvailableBooks();
                    break;

                case 0:
                    System.out.println("Exiting.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
