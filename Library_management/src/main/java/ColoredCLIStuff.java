import java.util.Scanner;

public class ColoredCLIStuff {
    public void help(){
        File.readBook();
        File.readMember();
        File.readManager();
        File.readRented();
        System.out.println("""
                \u001B[32madd\u001B[0m \u001B[34mmember\u001B[0m : Adds a member.
                \u001B[31mremove\u001B[0m \u001B[34mmember\u001B[0m : Removes a member from members.
                \u001B[36mshow\u001B[0m \u001B[34mmembers\u001B[0m : Shows the list of members.
                
                \u001B[32madd\u001B[0m \u001B[31mbook\u001B[0m : Adds a book.
                \u001B[31mremove\u001B[0m \u001B[31mbook\u001B[0m : Removes a book from books.
                \u001B[36mshow\u001B[0m \u001B[31mbooks\u001B[0m : Shows the list of books.
                
                \u001B[32madd\u001B[0m \u001B[35mmanager\u001B[0m : Adds a manager.
                \u001B[31mremove\u001B[0m \u001B[35mmanager\u001B[0m : Removes a manager from managers.
                \u001B[36mshow\u001B[0m \u001B[35mmanagers\u001B[0m : Shows the list of managers.
                
                \u001B[32mrent\u001B[0m : Rents a book from the books.
                \u001B[31mremove\u001B[0m \u001B[33mrent\u001B[0m : Returns a book to library.
                \u001B[36mshow\u001B[0m \u001B[33mrents\u001B[0m : Shows the list of rented books.
                
                \u001B[33mhelp\u001B[0m : Shows the legal commands.
                \u001B[31mexit\u001B[0m : Exits the program.
                """);
    }

    public void print(){
        System.out.println("\u001B[36m***Welcome***\u001B[0m\n");
        help();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        while (true){
            System.out.println("\u001B[34mEnter your command:\u001B[0m ");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "add" -> {
                    if (tokens.length < 2) {
                        System.out.println("\u001B[31mWrong command!\u001B[0m");
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
                            System.out.println(member + " \u001B[36madded " +
                                    "successfully.\u001B[0m");
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
                            System.out.println(book + " \u001B[36madded " +
                                    "successfully.\u001B[0m");
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
                                    "\u001B[36madded " +
                                    "successfully.\u001B[0m");
                            break;
                        default:
                            System.out.println("\u001B[31mWrong command!\u001B[0m");
                            break;
                    }
                }
                case "remove" -> {
                    if (tokens.length < 2) {
                        System.out.println("\u001B[31mWrong command!\u001B[0m");
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
                                System.out.println(member + " \u001B[31mremoved successfully.\u001B[0m");
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
                                        "\u001B[31mremoved successfully.\u001B[0m");
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
                                        " \u001B[31mremoved successfully.\u001B[0m");
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
                                        "with \u001B[35m" + id + " " +
                                        "id\u001B[0m \u001B[31m doesn't exist.");
                            } else {
                                rent.remove();
                                System.out.println(File.getBook(bookId) + " " +
                                        "rented by " + File.getMember(id) + " has been \u001B[32mreturned successfully.\u001B[0m");
                            }
                            break;
                        default:
                            System.out.println("\u001B[31mWrong command!\u001B[0m");
                            break;
                    }
                }
                case "show" -> {
                    if (tokens.length < 2) {
                        System.out.println("\u001B[31mWrong command!\u001B[0m");
                        break;
                    }
                    switch (tokens[1]) {
                        case "members":
                            if (File.members.size() == 0) {
                                System.out.println("\u001B[31mThere are no " +
                                        "members available.\u001B[0m");
                            } else {
                                System.out.println("\u001B[34mMembers:\u001B[0m");
                                File.showMembers();
                            }
                            break;
                        case "books":
                            if (File.books.size() == 0) {
                                System.out.println("\u001B[31mThere are no " +
                                        "books available.\u001B[0m");
                            } else {
                                System.out.println("\u001B[31mBooks:\u001B[0m");
                                File.showBooks();
                            }
                            break;
                        case "managers":
                            if (File.managers.size() == 0) {
                                System.out.println("\u001B[31mThere are no " +
                                        "managers available.\u001B[0m");
                            } else {
                                System.out.println("\u001B[35mManagers:\u001B[0m");
                                File.showManagers();
                            }
                            break;
                        case "rents":
                            if (File.rented.size() == 0) {
                                System.out.println("\u001B[31mThere are no " +
                                        "rented books.\u001B[0m");
                            } else {
                                System.out.println("\u001B[33mRented books:\u001B[0m");
                                File.showRents();
                            }
                            break;
                        default:
                            System.out.println("\u001B[31mWrong command!\u001B[0m");
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
                        System.out.println("Book with \u001B[35m" + bookId + " id\u001B[0m \u001B[31mdoesn't exist.\u001B[0m");
                    } else if (member == null) {
                        System.out.println("Member with \u001B[35m" + id + " id\u001B[0m \u001B[31mdoesn't exist.\u001B[0m");
                    } else {
                        Rent rent = new Rent(member, book);
                        rent.save();
                        System.out.println(rent);
                    }
                }
                case "help" -> help();
                case "exit" -> {
                    System.out.println("\u001B[36mHope you enjoyed!\u001B[0m");
                    System.exit(0);
                }
                default -> System.out.println("\u001B[31mWrong command!\u001B[0m");
            }
        }
    }
}
