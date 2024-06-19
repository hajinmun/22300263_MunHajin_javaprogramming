package BookManagementProgram;

public class Books {
    private String title;
    private String classification;
    private String author;
    private String loan;

    public Books(String title, String classification, String author, String loan) {
        this.title = title;
        this.classification = classification;
        this.author = author;
        this.loan = loan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }
}
