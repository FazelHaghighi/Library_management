import java.io.Serializable;
import java.util.Date;

public class Rent implements Serializable {
    private Member member;
    private Book book;
    private Date date;

    public Rent(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.date = new Date();
    }

    public boolean isRented(Rent rent){
        if (this == rent) return true;
        return member.equals(rent.member) && book.equals(rent.book);
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDate() {
        return date.toString();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void save(){
        File.save(this);
    }

    public void remove(){
        File.remove(this);
    }


    public String toString(){
        return book + " has been rented by " + member +
                " on " + date.toString() + ".";
    }

}
