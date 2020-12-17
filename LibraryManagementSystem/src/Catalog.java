import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Catalog implements Search {
    private HashMap<String, List<Book>> bookTitles;
    private HashMap<String, List<Book>> bookAuthors;
    private HashMap<String, List<Book>> bookSubjects;
    private HashMap<String, List<Book>> bookPublicationDates;

    public List<Book> searchByTitle(String query) {
        // return all books containing the string query in their title.
        return bookTitles.get(query);
    }

    public List<Book> searchByAuthor(String query) {
        // return all books containing the string query in their author's name.
        return bookAuthors.get(query);
    }

    public HashMap<String, List<Book>> getBookTitles() {
        return bookTitles;
    }

    public void setBookTitles(HashMap<String, List<Book>> bookTitles) {
        this.bookTitles = bookTitles;
    }

    public HashMap<String, List<Book>> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(HashMap<String, List<Book>> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public HashMap<String, List<Book>> getBookSubjects() {
        return bookSubjects;
    }

    public void setBookSubjects(HashMap<String, List<Book>> bookSubjects) {
        this.bookSubjects = bookSubjects;
    }

    public HashMap<String, List<Book>> getBookPublicationDates() {
        return bookPublicationDates;
    }

    public void setBookPublicationDates(HashMap<String, List<Book>> bookPublicationDates) {
        this.bookPublicationDates = bookPublicationDates;
    }

    @Override
    public List<Book> searchBySubject(String subject) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> searchByPubDate(Date publishDate) {
        // TODO Auto-generated method stub
        return null;
    }
  }