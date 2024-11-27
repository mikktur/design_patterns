package prototype;

import java.util.ArrayList;
import java.util.List;


public class Recommendation implements Cloneable {

    String targetAudience;
    List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation clone = (Recommendation) super.clone();
            clone.books = new ArrayList<>();
            for (Book book : books) {
                clone.books.add(book.clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Target Audience: ").append(targetAudience).append("\n");
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }
}
