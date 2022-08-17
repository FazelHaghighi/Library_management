import java.util.Scanner;

public class CLIStuff {
    public void help(){
        File.readBook();
        File.readMember();
        File.readManager();
        File.readRented();
        System.out.println("""
                add member : Adds a member.
                remove member : Removes a member from members.
                show members : Shows the list of members.
                
                add book : Adds a book.
                remove book : Removes a book from books.
                show books : Shows the list of books.
                
                add manager : Adds a manager.
                remove manager : Removes a manager from managers.
                show managers : Shows the list of managers.
                
                rent : Rents a book from the books.
                remove rent : Returns a book to library.
                show rents : Shows the list of rented books.
                
                help : Shows the legal commands.
                exit : Exits the program.
                """);
    }

    public void print(){
        System.out.println("***Welcome***\n");
        help();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        while (true){
            System.out.println("Enter your command: ");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "add" -> {
                    if (tokens.length < 2) {
                        System.out.println("Wrong command!");
                        break;
                    }
                    switch (tokens[1]) {
                        case "member":
                            System.out.println("Enter member's " +
                                    "name: ");
                            String memberName = scanner.nextLine();
                            System.out.println("Enter member's " +
                                    "national code: ");
                            int memberNationalCode =
                                    scanner1.nextInt();
                            Member member = new Member(memberName
                                    , memberNationalCode);
                            member.save();
                            System.out.println(member + " added " +
                                    "successfully.");
                            break;
                        case "book":
                            System.out.println("Enter book's " +
                                    "name: ");
                            String name = scanner.nextLine();
                            System.out.println("Enter book's " +
                                    "author: ");
                            String author = scanner.nextLine();
                            Book book = new Book(name, author);
                            book.save();
                            System.out.println(book + " added " +
                                    "successfully.");
                            break;
                        case "manager":
                            System.out.println("Enter your name: ");
                            name = scanner.nextLine();
                            System.out.println("Enter your " +
                                    "national code: ");
                            int nationalCode = scanner1.nextInt();
                            Manager manager = new Manager(name, nationalCode);
                            manager.save();
                            System.out.println(manager + " " +
                                    "added " +
                                    "successfully.");
                            break;
                        default:
                            System.out.println("Wrong command!");
                            break;
                    }
                }
                case "remove" -> {
                    if (tokens.length < 2) {
                        System.out.println("Wrong command!");
                        break;
                    }
                    switch (tokens[1]) {
                        case "member":
                            System.out.println("Enter " +
                                    "member's id:");
                            int id = scanner1.nextInt();
                            Member member =
                                    File.getMember(id);
                            if (member == null) {
                                System.out.println(
                                        "Member with " + id + " id doesn't exist.");
                            } else {
                                member.remove();
                                System.out.println(member + " removed successfully.");
                            }
                            break;
                        case "book":
                            System.out.println("Enter " +
                                    "book's id:");
                            id = scanner1.nextInt();
                            Book book = File.getBook(id);
                            if (book == null) {
                                System.out.println(
                                        "Book with " + id +
                                                " id doesn't exist.");
                            } else {
                                book.remove();
                                System.out.println(book + " " +
                                        "removed successfully.");
                            }
                            break;
                        case "manager":
                            System.out.println("Enter " +
                                    "manager's national " +
                                    "code:");
                            int code = scanner1.nextInt();
                            Manager manager =
                                    File.getManager(code);
                            if (manager == null) {
                                System.out.println(
                                        "Manager with " + code + " national code doesn't exist.");
                            } else {
                                manager.remove();
                                System.out.println(manager +
                                        " removed successfully.");
                            }
                            break;
                        case "rent":
                            System.out.println("Enter " +
                                    "member's id:");
                            id = scanner1.nextInt();
                            System.out.println("Enter " +
                                    "book's id:");
                            int bookId = scanner1.nextInt();
                            Rent rent =
                                    File.getRent(bookId,
                                            id);
                            if (rent == null) {
                                System.out.println("Rent " +
                                        "with " + id + " " +
                                        "id doesn't exist.");
                            } else {
                                rent.remove();
                                System.out.println(File.getBook(bookId) + " " +
                                        "rented by " + File.getMember(id) + " has been returned successfully.");
                            }
                            break;
                        default:
                            System.out.println("Wrong " +
                                    "command!");
                            break;
                    }
                }
                case "show" -> {
                    if (tokens.length < 2) {
                        System.out.println("Wrong command!");
                        break;
                    }
                    switch (tokens[1]) {
                        case "members":
                            if (File.members.size() == 0) {
                                System.out.println("There are no " +
                                        "members available." +
                                        ".");
                            } else {
                                System.out.println("Members:");
                                File.showMembers();
                            }
                            break;
                        case "books":
                            if (File.books.size() == 0) {
                                System.out.println("There are no " +
                                        "books available.");
                            } else {
                                System.out.println("Books:");
                                File.showBooks();
                            }
                            break;
                        case "managers":
                            if (File.managers.size() == 0) {
                                System.out.println("There are no " +
                                        "managers available.");
                            } else {
                                System.out.println("Managers:");
                                File.showManagers();
                            }
                            break;
                        case "rents":
                            if (File.rented.size() == 0) {
                                System.out.println("There are no " +
                                        "rented books.");
                            } else {
                                System.out.println("Rented books:");
                                File.showRents();
                            }
                            break;
                        default:
                            System.out.println("Wrong " +
                                    "command!");
                            break;
                    }
                }
                case "rent" -> {
                    System.out.println("Enter member's " +
                            "id: ");
                    int id = scanner1.nextInt();
                    System.out.println("Enter book's id: ");
                    int bookId =
                            scanner1.nextInt();
                    Book book = File.getBook(bookId);
                    Member member = File.getMember(id);
                    if (book == null) {
                        System.out.println("Book with " + bookId + " id doesn't exist.");
                    } else if (member == null) {
                        System.out.println("Member with " + id + " id doesn't exist.");
                    } else {
                        Rent rent = new Rent(member, book);
                        rent.save();
                        System.out.println(rent);
                    }
                }
                case "help" -> help();
                case "exit" -> {
                    System.out.println("Hope you enjoyed!");
                    System.exit(0);
                }
                default -> System.out.println("Wrong command!");
            }
        }
    }
}
