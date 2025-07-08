package org.example;

import java.util.List;

// Test class
class Test {
    private Store store;

    public Test() {
        this.store = new Store();
    }

    public void testAddingBooks() {
        System.out.println("\n=== Testing Adding Books ===");

        // Add paper book
        PaperBook paperBook = new PaperBook("978-1234567890", "Python Programming", "John Smith", 2020, 29.99, 10);
        store.addBook(paperBook);

        // Add ebook
        EBook ebook = new EBook("978-0987654321", "Advanced Python", "Jane Doe", 2022, 19.99, "PDF");
        store.addBook(ebook);

        // Add showcase book
        ShowcaseBook showcase = new ShowcaseBook("978-1122334455", "Upcoming Novel", "Bob Johnson", 2024);
        store.addBook(showcase);

        store.listInventory();
    }

    public void testRemovingBooks() {
        System.out.println("\n=== Testing Removing Outdated Books ===");

        // Add an old book
        PaperBook oldBook = new PaperBook("978-1111111111", "Old Programming Book", "Old Author", 2010, 15.99, 5);
        store.addBook(oldBook);

        // Remove books older than 10 years
        List<Book> removedBooks = store.removeOutdatedBooks(10);
        System.out.println("Quantum book store: Removed " + removedBooks.size() + " outdated books");

        store.listInventory();
    }

    public void testBuyingBooks() {
        System.out.println("\n=== Testing Buying Books ===");

        try {
            // Buy paper book
            double amount = store.buyBook("978-1234567890", 2, "customer@example.com", "123 Main St, City, State");
            System.out.println("Quantum book store: Successfully purchased paper book for $" + String.format("%.2f", amount));
        } catch (Exception e) {
            System.out.println("Quantum book store: Error buying paper book: " + e.getMessage());
        }

        try {
            // Buy ebook
            double amount = store.buyBook("978-0987654321", 1, "customer@example.com", "123 Main St, City, State");
            System.out.println("Quantum book store: Successfully purchased ebook for $" + String.format("%.2f", amount));
        } catch (Exception e) {
            System.out.println("Quantum book store: Error buying ebook: " + e.getMessage());
        }

        try {
            // Try to buy showcase book (should fail)
            double amount = store.buyBook("978-1122334455", 1, "customer@example.com", "123 Main St, City, State");
        } catch (Exception e) {
            System.out.println("Quantum book store: Error buying showcase book: " + e.getMessage());
        }

        try {
            // Try to buy more paper books than available
            double amount = store.buyBook("978-1234567890", 20, "customer@example.com", "123 Main St, City, State");
        } catch (Exception e) {
            System.out.println("Quantum book store: Error buying too many paper books: " + e.getMessage());
        }

        store.listInventory();
    }

    public void runAllTests() {
        System.out.println("Quantum book store: Starting comprehensive tests...");
        testAddingBooks();
        testRemovingBooks();
        testBuyingBooks();
        System.out.println("\nQuantum book store: All tests completed!");
    }
}
