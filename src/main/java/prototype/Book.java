package prototype;

import state.State;

public class Book  implements Cloneable {
    String author;
    String title;
    String genre;
    Integer publicationYear;
    public Book(String author, String title, String genre, Integer publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }
    @Override
    public Book clone()  {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String toString() {
        return title + " by " + author + " (" + publicationYear + ")";
    }
}
