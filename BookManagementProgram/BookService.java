package BookManagementProgram;

import java.util.ArrayList;

public class BookService {
    private ArrayList<Books> bookList = new ArrayList<>();

    // Method to add a book to the list
    public void addBook(Books book) {
        bookList.add(book);
        System.out.println("The book has been registered.");
    }

    // Method to display the list of books
    public void bookList() {
        if (bookList.isEmpty()) {
            System.out.println("There are no registered books.");
            return;
        }
        for (Books book : bookList) {
            System.out.println("Title: " + book.getTitle() + ", Category: " + book.getClassification() 
            + ", Author: " + book.getAuthor() + ", Loan Status: " + book.getLoan());
        }
    }

    // Method to find a book by title
    public Books findBook(String title) {
        for (Books book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Method to update book information
    public void updateBook(String title, String newTitle, String newClassification, 
                           String newAuthor, String newLoan) {
        Books book = findBook(title);
        if (book != null) {
            book.setTitle(newTitle);
            book.setClassification(newClassification);
            book.setAuthor(newAuthor);
            book.setLoan(newLoan);
            System.out.println("The book information has been updated.");
        } else {
            System.out.println("Cannot find the specified book.");
        }
    }

    // Method to delete a book
    public void deleteBook(String title) {
        Books book = findBook(title);
        if (book != null) {
            bookList.remove(book);
            System.out.println("The book has been deleted.");
        } else {
            System.out.println("Cannot find the specified book.");
        }
    }

    // Method to change the loan status of a book
    public void loanBook(String title, String loanStatus) {
        Books book = findBook(title);
        if (book != null) {
            book.setLoan(loanStatus);
            System.out.println("The loan status of the book has been updated. Current status: " + book.getLoan());
        } else {
            System.out.println("Cannot find the specified book.");
        }
    }
}
