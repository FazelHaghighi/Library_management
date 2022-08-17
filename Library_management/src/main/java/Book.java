import java.io.*;

public class Book implements Serializable,SaveRemove {
    private String name;
    private String author;
    private final int bookId;
    private static int firstId = 1;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        bookId = firstId;
        firstId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public static int getFirstId() {
        return firstId;
    }

    public static void setFirstId(int firstId) {
        Book.firstId = firstId;
    }

    public void save(){
        File.save(this);
    }

    public void remove(){
        File.remove(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "Name: '" + name + '\'' +
                ", Author: '" + author + '\'' +
                ", Book Id: " + bookId +
                '}';
    }
}
