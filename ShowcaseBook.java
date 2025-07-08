package org.example;

// Showcase/Demo book implementation
class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, String author, int year) {
        super(isbn, title, author, year, 0.0); // Price is 0 for showcase books
    }

    @Override
    public boolean validPurchased() {
        return false; // Showcase books are not for sale
    }

    @Override
    public String PurchaseBook(int quantity, String email, String address) throws Exception {
        throw new Exception("Showcase books are not for sale");
    }
}
