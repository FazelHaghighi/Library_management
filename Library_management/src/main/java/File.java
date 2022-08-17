import java.io.*;
import java.util.ArrayList;

public class File {

    public static ArrayList<Manager> managers = new ArrayList<>();
    public static ArrayList<Member> members = new ArrayList<>();
    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<Rent> rented = new ArrayList<>();

    public static Member getMember(int id){
        for (Member m : members){
            if(m.getMemberId() == id){
                return m;
            }
        }
        return null;
    }

    public static Manager getManager(int id){
        for (Manager m : managers){
            if(m.getNationalCode() == id){
                return m;
            }
        }
        return null;
    }

    public static Book getBook(int id){
        for (Book b : books){
            if(b.getBookId() == id){
                return b;
            }
        }
        return null;
    }

    public static Rent getRent(int bookId, int memberId){
        for(Rent r: rented){
            if(r.getBook().getBookId() == bookId && r.getMember().getMemberId() == memberId){
                return r;
            }
        }
        return null;
    }

    public static ArrayList<Rent> getRents(Book book){
        ArrayList<Rent> temp = new ArrayList<>();
        for(Rent r: rented){
            if(r.getBook().equals(book)){
                temp.add(r);
            }
        }
        return temp;
    }

    public static ArrayList<Rent> getRents(Member member) {
        ArrayList<Rent> temp = new ArrayList<>();
        for (Rent r : rented) {
            if (r.getMember().equals(member)) {
                temp.add(r);
            }
        }
        return temp;
    }

    public static void showManagers(){
        for(Manager manager : managers){
            System.out.println(manager);
        }
    }

    public static void showMembers(){
        for(Member member : members){
            System.out.println(member);
        }
    }

    public static void showBooks(){
        for(Book book : books){
            System.out.println(book);
        }
    }
    public static void showRents(){
        for(Rent rent : rented){
            System.out.println(rent);
        }
    }

    public static void writeManager(){
        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream("managers.txt");
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(fileOutputStream);
            for (Manager m : managers) {
                objectOutputStream.writeObject(m);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File has not been created" +
                    "!");
        } catch (IOException e) {
            System.out.println("Manger has not been " +
                    "saved!");
        }
    }

    public static void readManager(){
        try(ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream("managers.txt"))) {
            while (true) {
                try {
                    Manager m = (Manager) in.readObject();
                    managers.add(m);
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.print("");
        }
    }

    public static void writeMember(){
        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream("members.txt");
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(fileOutputStream);
            for (Member m : members) {
                objectOutputStream.writeObject(m);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File has not been created!");
        } catch (IOException e) {
            System.out.println("Member has not been " +
                    "saved!");
        }
    }

    public static void readMember(){
        try(ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream("members.txt"))){
            while (true){
                try {
                Member m =(Member) in.readObject();
                members.add(m);
                if (m.getMemberId() >= Member.getFirstId()){
                    Member.setFirstId(m.getMemberId() + 1);
                }
            } catch (EOFException eof){
                    break;
            }
        }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.print("");
        }
    }

    public static void writeBook(){
        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream("books.txt");
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(fileOutputStream);
            for (Book b : books) {
                objectOutputStream.writeObject(b);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File has not been " +
                    "created!");
        } catch (IOException e) {
            System.out.println("Book has not been saved!");
        }
    }

    public static void readBook(){
        try(ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream("books.txt"))){
            while (true) {
                try {
                    Book b = (Book) in.readObject();
                    books.add(b);
                    if (b.getBookId() >= Book.getFirstId()){
                        Book.setFirstId(b.getBookId() + 1);
                    }
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.print("");
        }
    }

    public static void writeRented(){
        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream("rents.txt");
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(fileOutputStream);
            for (Rent r : rented) {
                objectOutputStream.writeObject(r);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File has not been " +
                    "created!");
        } catch (IOException e) {
            System.out.println("Rented book has not been " +
                    "saved!");
        }
    }

    public static void readRented(){
        try(ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream("rents.txt"))) {
            while (true) {
                try {
                    Rent r = (Rent) in.readObject();
                    rented.add(r);
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.print("");
        }
    }

    public static void save(Manager manager){
        managers.add(manager);
        writeManager();
    }

    public static void remove(Manager manager){
        managers.remove(manager);
        writeManager();
    }

    public static void save(Member member){
        members.add(member);
        writeMember();
    }

    public static void remove(Member member){
        for (Rent r : getRents(member)) remove(r);
        members.remove(member);
        writeMember();
    }

    public static void save(Book book){
        books.add(book);
        writeBook();
    }
    public static void remove(Book book){
        for (Rent r : getRents(book)) remove(r);
        books.remove(book);
        writeBook();
    }

    public static void save(Rent rent){
        rented.add(rent);
        writeRented();
    }

    public static void remove(Rent rent){
        rented.remove(rent);
        writeRented();
    }
}
