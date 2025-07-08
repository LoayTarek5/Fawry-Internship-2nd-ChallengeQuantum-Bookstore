package org.example;


// EBook implementation
class EBook extends Book {
    private String filetype;

    public EBook(String isbn, String title, String author, int year, double price, String filetype) {
        super(isbn, title, author, year, price);
        this.filetype = filetype;
    }

    @Override
    public boolean validPurchased() {
        return true; // EBooks are always available
    }

    @Override
    public String PurchaseBook(int quantity, String email, String address) throws Exception {
        // Send to mail service (placeholder)
        System.out.println("Quantum book store: Sending " + quantity + " copies of '" + title + "' (" + filetype + ") to MailService for email: " + email);
        return "EBook order processed. File type: " + filetype;
    }

    public String getFiletype() { return filetype; }
}
