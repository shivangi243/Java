class Book2 {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    // 1. Default Constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.isbn = "000000";
        this.isAvailable = true;
    }

    // 2. Parameterized Constructor
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    // 3. Copy Constructor
    public Book(Book book) {
        this.title = book.title;
        this.author = book.author;
        this.isbn = book.isbn;
        this.isAvailable = book.isAvailable;
    }

    // Method to display book details
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Checked Out"));
        System.out.println("----------------------------");
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        // Using Default Constructor
        Book defaultBook = new Book();
        defaultBook.displayBookInfo();

        // Using Parameterized Constructor
        Book paramBook = new Book("The Alchemist", "Paulo Coelho", "9780061122415", true);
        paramBook.displayBookInfo();

        // Using Copy Constructor
        Book copyBook = new Book(paramBook);
        copyBook.displayBookInfo();
    }
}
