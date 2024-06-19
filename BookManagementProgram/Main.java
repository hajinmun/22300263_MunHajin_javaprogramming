package BookManagementProgram;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();

        String[] classifications = {"Philosophy", "Religion", "Science", "Literature", "Language", "Other"};
        String[] loanStatuses = {"Available", "On Loan"};

        System.out.println("Welcome to the Library");
        while (true) {
            System.out.println("[1] Add Book [2] List All Books [3] Search Book [4] Update Book Info [5] Delete Book "
                    + "[6] Borrow/Return Book [0] Exit");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.println("Select Category:");
                    for (int i = 0; i < classifications.length; i++) {
                        System.out.println("[" + (i + 1) + "] " + classifications[i]);
                    }
                    int classChoice = Integer.parseInt(scanner.nextLine());
                    String classification = classifications[classChoice - 1];

                    System.out.print("Author: ");
                    String author = scanner.nextLine();

                    // Always set as Available by default
                    String loan = loanStatuses[0];

                    Books newBook = new Books(title, classification, author, loan);
                    bookService.addBook(newBook);
                    break;

                case "2":
                    bookService.bookList();
                    break;

                case "3":
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    Books foundBook = bookService.findBook(title);
                    if (foundBook != null) {
                        System.out.println("Title: " + foundBook.getTitle() + ", Category: " +
                                foundBook.getClassification() + ", Author: " + foundBook.getAuthor() + ","
                                + " Loan Status: " + foundBook.getLoan());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case "4":
                    System.out.print("Enter book title to update: ");
                    title = scanner.nextLine();

                    System.out.print("New Title: ");
                    String newTitle = scanner.nextLine();

                    System.out.println("Select Category:");
                    for (int i = 0; i < classifications.length; i++) {
                        System.out.println("[" + (i + 1) + "] " + classifications[i]);
                    }
                    classChoice = Integer.parseInt(scanner.nextLine());
                    String newClassification = classifications[classChoice - 1];

                    System.out.print("New Author: ");
                    String newAuthor = scanner.nextLine();

                    System.out.println("Select Loan Status (0. On Loan, 1. Available):");
                    int loanChoice = Integer.parseInt(scanner.nextLine());
                    String newLoan = loanStatuses[loanChoice - 1];

                    bookService.updateBook(title, newTitle, newClassification, newAuthor, newLoan);
                    break;

                case "5":
                    System.out.print("Enter book title to delete: ");
                    title = scanner.nextLine();
                    bookService.deleteBook(title);
                    break;

                case "6":
                    System.out.print("Enter book title to borrow or return: ");
                    title = scanner.nextLine();
                    System.out.println("Change Loan Status: (0. On Loan, 1. Available)");
                    int loanStatusChoice = Integer.parseInt(scanner.nextLine());
                    String loanStatus = (loanStatusChoice == 1) ? "Available" : "On Loan";
                    bookService.loanBook(title, loanStatus);
                    break;

                case "0":
                    System.out.println("Program terminated.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }
}
