package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Main bookstore class
class Store {
    private Map<String, Book> inventory;

    public Store() {
        this.inventory = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added '" + book.getTitle() + "' to inventory");
    }

    public List<Book> removeOutdatedBooks(int yearsThreshold) {
        int currentYear = LocalDate.now().getYear();
        List<Book> outdatedBooks = new ArrayList<>();
        List<String> booksToRemove = new ArrayList<>();

        for (Map.Entry<String, Book> entry : inventory.entrySet()) {
            Book book = entry.getValue();
            if (currentYear - book.getYear() > yearsThreshold) {
                outdatedBooks.add(book);
                booksToRemove.add(entry.getKey());
            }
        }

        for (String isbn : booksToRemove) {
            Book removedBook = inventory.remove(isbn);
            System.out.println("Quantum book store: Removed outdated book '" + removedBook.getTitle() + "'");
        }

        if (!outdatedBooks.isEmpty()) {
            System.out.println("Quantum book store: Removed " + outdatedBooks.size() + " outdated books");
        }

        return outdatedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        if (!inventory.containsKey(isbn)) {
            throw new Exception("Book with ISBN " + isbn + " not found in inventory");
        }

        Book book = inventory.get(isbn);

        if (!book.validPurchased()) {
            throw new Exception("Book '" + book.getTitle() + "' is not available for purchase");
        }

        // Process the purchase
        String result = book.PurchaseBook(quantity, email, address);
        double totalAmount = book.getPrice() * quantity;

        System.out.println("Quantum book store: Purchase completed. " + result);
        System.out.println("Quantum book store: Total amount paid: $" + String.format("%.2f", totalAmount));

        return totalAmount;
    }

    public void listInventory() {
        System.out.println("Quantum book store: Current Inventory:");
        for (Map.Entry<String, Book> entry : inventory.entrySet()) {
            Book book = entry.getValue();
            String bookType = book.getClass().getSimpleName();
            System.out.println("  " + entry.getKey() + ": " + book + " - Type: " + bookType);
        }
    }
}
