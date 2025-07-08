package org.example;

// Paper book implementation
class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int year, double price, int stock) {
        super(isbn, title, author, year, price);
        this.stock = stock;
    }

    @Override
    public boolean validPurchased() {
        return stock > 0;
    }

    @Override
    public String PurchaseBook(int quantity, String email, String address) throws Exception {
        if (stock < quantity) {
            throw new Exception("Not enough stock. Available: " + stock + ", Requested: " + quantity);
        }

        stock -= quantity;
        // Send to shipping service (placeholder)
        System.out.println("Quantum book store: Sending " + quantity + " copies of '" + title + "' to ShippingService for address: " + address);
        return "Paper book order processed. Remaining stock: " + stock;
    }

    public int getStock() { return stock; }
}
