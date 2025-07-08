package org.example;

// Abstract base class for books
abstract class Book {
    protected String isbn;
    protected String title;
    protected String author;
    protected int year;
    protected double price;

    public Book(String isbn, String title, String author, int year, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public abstract boolean validPurchased();
    public abstract String PurchaseBook(int quantity, String email, String address) throws Exception;

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ") - $" + price;
    }
}
