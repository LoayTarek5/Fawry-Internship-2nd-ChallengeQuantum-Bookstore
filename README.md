# Fawry-Internship-2nd-ChallengeQuantum-Bookstore
# Quantum Book Store - Technical Documentation

## Overview

The Quantum Book Store is a Java-based inventory management system that handles different types of books including physical books, eBooks, and showcase items. The system provides functionality for adding books, managing inventory, processing purchases, and removing outdated items.

## System Architecture

### Class Hierarchy

```
Book (Abstract)
├── PaperBook
├── EBook
└── ShowcaseBook
```

### Core Components

- **Book (Abstract Class)**: Base class defining common properties and abstract methods
- **Store**: Main inventory management class
- **Test**: Comprehensive testing suite
- **Main**: Application entry point

## Class Documentation

### Abstract Book Class

**Purpose**: Defines the common structure and behavior for all book types.

**Properties**:
- `isbn` (String): Unique identifier for the book
- `title` (String): Book title
- `author` (String): Author name
- `year` (int): Publication year
- `price` (double): Book price

**Abstract Methods**:
- `validPurchased()`: Determines if the book can be purchased
- `PurchaseBook(int quantity, String email, String address)`: Handles the purchase process

**Concrete Methods**:
- Getter methods for all properties
- `toString()`: Returns formatted book information

### PaperBook Class

**Purpose**: Represents physical books with stock management.

**Additional Properties**:
- `stock` (int): Number of available copies

**Key Features**:
- Stock validation before purchase
- Automatic stock reduction after purchase
- Integration with shipping service (placeholder)

**Purchase Logic**:
- Validates sufficient stock availability
- Decreases stock count after successful purchase
- Sends order to shipping service

### EBook Class

**Purpose**: Represents digital books with unlimited availability.

**Additional Properties**:
- `filetype` (String): Digital file format (PDF, EPUB, etc.)

**Key Features**:
- Always available for purchase (no stock limitations)
- Integration with email delivery service (placeholder)

**Purchase Logic**:
- No stock validation required
- Sends digital copy via email service

### ShowcaseBook Class

**Purpose**: Represents promotional or upcoming books not for sale.

**Key Features**:
- Price is always $0.00
- Cannot be purchased (display only)
- Used for marketing and promotional purposes

**Purchase Logic**:
- Always returns false for `validPurchased()`
- Throws exception when purchase is attempted

### Store Class

**Purpose**: Main inventory management system.

**Properties**:
- `inventory` (Map<String, Book>): Stores books indexed by ISBN

**Core Methods**:

#### `addBook(Book book)`
- Adds a book to the inventory
- Uses ISBN as the unique key
- Provides confirmation message

#### `removeOutdatedBooks(int yearsThreshold)`
- Removes books older than specified threshold
- Returns list of removed books
- Calculates age based on current year

#### `buyBook(String isbn, int quantity, String email, String address)`
- Processes book purchases
- Validates book existence and availability
- Calculates total amount
- Returns total purchase amount

#### `listInventory()`
- Displays current inventory
- Shows book details and type information

## Usage Examples

### Adding Books to Inventory

```java
Store store = new Store();

// Add paper book
PaperBook paperBook = new PaperBook("978-1234567890", "Python Programming", "John Smith", 2020, 29.99, 10);
store.addBook(paperBook);

// Add ebook
EBook ebook = new EBook("978-0987654321", "Advanced Python", "Jane Doe", 2022, 19.99, "PDF");
store.addBook(ebook);

// Add showcase book
ShowcaseBook showcase = new ShowcaseBook("978-1122334455", "Upcoming Novel", "Bob Johnson", 2024);
store.addBook(showcase);
```

### Processing Purchases

```java
try {
    // Purchase paper book
    double amount = store.buyBook("978-1234567890", 2, "customer@example.com", "123 Main St");
    System.out.println("Total paid: $" + amount);
} catch (Exception e) {
    System.out.println("Purchase failed: " + e.getMessage());
}
```

### Removing Outdated Books

```java
// Remove books older than 10 years
List<Book> removedBooks = store.removeOutdatedBooks(10);
System.out.println("Removed " + removedBooks.size() + " outdated books");
```

## Error Handling

The system implements comprehensive error handling:

### Common Exceptions

- **Book Not Found**: Thrown when ISBN doesn't exist in inventory
- **Insufficient Stock**: Thrown when requested quantity exceeds available stock
- **Invalid Purchase**: Thrown when attempting to buy showcase books
- **Showcase Purchase**: Thrown specifically for showcase book purchase attempts

### Exception Messages

- Clear, descriptive error messages
- Includes relevant context (available stock, requested quantity)
- Consistent error reporting format

## Testing Suite

The `Test` class provides comprehensive testing coverage:

### Test Categories

1. **Adding Books Test**
   - Tests adding different book types
   - Verifies inventory updates
   - Confirms proper book classification

2. **Removing Books Test**
   - Tests outdated book removal
   - Verifies age calculation logic
   - Confirms proper inventory cleanup

3. **Buying Books Test**
   - Tests successful purchases
   - Tests error conditions
   - Verifies stock management
   - Tests showcase book restrictions

### Running Tests

```java
Test test = new Test();
test.runAllTests();
```

## System Output

The application provides detailed console output for all operations:

- Book additions and removals
- Purchase confirmations
- Error notifications
- Inventory status updates
- Service integration messages

## Integration Points

### External Services (Placeholders)

1. **Shipping Service**
   - Handles physical book delivery
   - Receives order details and shipping address

2. **Mail Service**
   - Handles eBook delivery
   - Sends digital files via email

## Future Enhancements

### Recommended Improvements

1. **Database Integration**
   - Replace HashMap with persistent storage
   - Add data validation and constraints

2. **Service Layer**
   - Implement actual shipping and email services
   - Add service configuration management

3. **User Interface**
   - Add GUI or web interface
   - Implement user authentication

4. **Advanced Features**
   - Shopping cart functionality
   - Order history tracking
   - Inventory alerts for low stock

5. **Error Handling**
   - Custom exception classes
   - Logging framework integration
   - Retry mechanisms for service calls

## Dependencies

- Java 8+ (for LocalDate usage)
- Java Collections Framework
- Standard Java I/O libraries
