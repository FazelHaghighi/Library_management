import java.util.Scanner;

public class CLIFields {
    Scanner scanner = new Scanner(System.in);
    String password = "1234";
    String input;
    public void first(){
        File.readBook();
        File.readManager();
        File.readMember();
        File.readRented();
        Welcome();
    }
    public void Welcome() {
        System.out.println("""
                ***Welcome***
                Enter the number you want: (1/2)
                1.Manager
                2.Member
                0.Exit""");
        input = scanner.nextLine();
        main();
    }

    public void main() {
        switch (input) {
            case "1" -> {
                System.out.println("Enter password: ");
                String pass = scanner.nextLine();
                if (pass.equals(password)) {
                    mangerMenu();
                } else {
                    System.out.println("Wrong password!");
                    Welcome();
                }
            }
            case "2" -> memberMenu();
            case "0" -> {
                System.out.println("Thanks for coming.");
                System.exit(0);
            }
            default -> {
                System.out.println("Wrong command!");
                Welcome();
            }
        }
    }
    public void mangerMenu() {
        System.out.println("Enter the number you want: (1" +
                "/2)");
        System.out.println("""
                1.Create a new manager
                2.Log in to an existing manager account
                0.back""");
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                System.out.println("Enter your name: ");
                String name = scanner.nextLine();
                System.out.println("Enter your " +
                        "national code: ");
                int nationalCode = scanner.nextInt();
                Manager manager = new Manager(name, nationalCode);
                manager.save();
                System.out.println("Manager created " +
                        "successfully!");
                System.out.println("managers' password: 1234");
                mangerMenu();
            }
            case "2" -> mangerOptions();
            case "0" -> Welcome();
            default -> {
                System.out.println("Wrong command!");
                mangerMenu();
            }
        }
    }
    public void mangerOptions() {
        System.out.println("Enter the number you " +
                "want: ");
        System.out.println("""
                1.add book
                2.remove book
                3.add member
                4.remove member
                5.show books
                6.show members
                7.show managers
                8.show rented books
                0.back""");
        String number = scanner.nextLine();
        switch (number) {
            case "1":
                System.out.println("Enter book's " +
                        "name: ");
                String name = scanner.nextLine();
                System.out.println("Enter book's " +
                        "author: ");
                String author = scanner.nextLine();
                Book book = new Book(name, author);
                book.save();
                System.out.println( book + " added " +
                        "successfully.");
                System.out.println("Type 0 to get back.");
                String zero = scanner.nextLine();
                if (zero.equals("0")) mangerOptions();
                else {
                    System.out.println("Wrong command!");
                    System.out.println("Type 0 to get back.");
                    zero = scanner.nextLine();
                    if (zero.equals("0")) mangerOptions();
                    else System.out.println("WTF!!!");
                }
                break;
            case "2":
                System.out.println("Enter book's " +
                        "name: ");
                String removeName = scanner.nextLine();
                System.out.println("Enter book's " +
                        "author: ");
                String removeAuthor =
                        scanner.nextLine();
                Book removeBook = new Book(removeName,
                        removeAuthor);
                removeBook.remove();
                System.out.println( removeBook + " removed " +
                        "successfully.");
                System.out.println("Type 0 to get back.");
                zero = scanner.nextLine();
                if (zero.equals("0")) mangerOptions();
                else {
                    System.out.println("Wrong command!");
                    System.out.println("Type 0 to get back.");
                    zero = scanner.nextLine();
                    if (zero.equals("0")) mangerOptions();
                    else System.out.println("WTF!!!");
                }
                break;
            case "3":
                System.out.println("Enter member's " +
                        "name: ");
                String memberName = scanner.nextLine();
                System.out.println("Enter member's " +
                        "national code: ");
                int memberNationalCode =
                        scanner.nextInt();
                Member member = new Member(memberName
                        , memberNationalCode);
                member.save();
                System.out.println( member + " added " +
                        "successfully.");
                System.out.println("Type 0 to get back.");
                zero = scanner.nextLine();
                if (zero.equals("0")) mangerOptions();
                else {
                    System.out.println("Wrong command!");
                    System.out.println("Type 0 to get back.");
                    zero = scanner.nextLine();
                    if (zero.equals("0")) mangerOptions();
                    else System.out.println("WTF!!!");
                }
                break;
            case "4":
                System.out.println("Enter member's " +
                        "name: ");
                String removeMemberName =
                        scanner.nextLine();
                System.out.println("Enter member's " +
                        "national code: ");
                int removeMemberNationalCode =
                        scanner.nextInt();
                Member removeMember = new Member(removeMemberName
                        , removeMemberNationalCode);
                removeMember.remove();
                System.out.println( removeMember + " " +
                        "removed " +
                        "successfully.");
                System.out.println("Type 0 to get back.");
                zero = scanner.nextLine();
                if (zero.equals("0")) mangerOptions();
                else {
                    System.out.println("Wrong command!");
                    System.out.println("Type 0 to get back.");
                    zero = scanner.nextLine();
                    if (zero.equals("0")) mangerOptions();
                    else System.out.println("WTF!!!");
                }
                break;
            case "5":
                if (File.books.size() == 0) {
                    System.out.println("There are no " +
                            "books available.");
                } else {
                    System.out.println("Books:");
                    File.showBooks();
                }
                System.out.println("Type 0 to get back.");
                zero = scanner.nextLine();
                if (zero.equals("0")) mangerOptions();
                else {
                    System.out.println("Wrong command!");
                    System.out.println("Type 0 to get back.");
                    zero = scanner.nextLine();
                    if (zero.equals("0")) mangerOptions();
                    else System.out.println("WTF!!!");
                }
                break;
            case "6":
                if (File.members.size() == 0) {
                    System.out.println("There are no " +
                            "members available." +
                            ".");
                } else {
                    System.out.println("Members:");
                    File.showMembers();
                }
                System.out.println("Type 0 to get back.");
                zero = scanner.nextLine();
                if (zero.equals("0")) mangerOptions();
                else {
                    System.out.println("Wrong command!");
                    System.out.println("Type 0 to get back.");
                    zero = scanner.nextLine();
                    if (zero.equals("0")) mangerOptions();
                    else System.out.println("WTF!!!");
                }
                break;
            case "7":
                if (File.managers.size() == 0) {
                    System.out.println("There are no " +
                            "managers available.");
                } else {
                    System.out.println("Managers:");
                    File.showManagers();
                }
                System.out.println("Type 0 to get back.");
                zero = scanner.nextLine();
                if (zero.equals("0")) mangerOptions();
                else {
                    System.out.println("Wrong command!");
                    System.out.println("Type 0 to get back.");
                    zero = scanner.nextLine();
                    if (zero.equals("0")) mangerOptions();
                    else System.out.println("WTF!!!");
                }
                break;
            case "8":
                if (File.rented.size() == 0) {
                    System.out.println("There are no " +
                            "rented books." +
                            ".");
                } else {
                    System.out.println("Rented books:");
                    File.showRents();
                }
                System.out.println("Type 0 to get back.");
                zero = scanner.nextLine();
                if (zero.equals("0")) mangerOptions();
                else {
                    System.out.println("Wrong command!");
                    System.out.println("Type 0 to get back.");
                    zero = scanner.nextLine();
                    if (zero.equals("0")) mangerOptions();
                    else System.out.println("WTF!!!");
                }
                break;
            case "0":
                mangerMenu();
                break;
            default:
                System.out.println("Wrong command!");
                mangerOptions();
                break;
        }
    }
    public void memberMenu() {
        System.out.println("Enter the number you want: (1" +
                "/2)");
        System.out.println("""
                1.Create a new account
                2.Log in to an existing account
                0.back""");
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                System.out.println("Enter your name: ");
                String name = scanner.nextLine();
                System.out.println("Enter your " +
                        "national code: ");
                int nationalCode = scanner.nextInt();
                Member member = new Member(name, nationalCode);
                member.save();
                System.out.println("Account created " +
                        "successfully!");
                memberMenu();
            }
            case "2" -> memberOptions();
            case "0" -> Welcome();
            default -> {
                System.out.println("Wrong command!");
                memberMenu();
            }
        }
    }

    public void memberOptions() {
        System.out.println("Enter the number you " +
                "want: ");
        System.out.println("""
                1.show books
                2.rent book
                3.delete account
                0.back""");
        String number = scanner.nextLine();
        switch (number) {
            case "1":
                if (File.books.size() == 0) {
                    System.out.println("There are no " +
                            "books available.");
                } else {
                    System.out.println("Books:");
                    File.showBooks();
                }
                System.out.println("Type 0 to get back.");
                String zero = scanner.nextLine();
                if (zero.equals("0")) memberOptions();
                else {
                    System.out.println("Wrong command!");
                    System.out.println("Type 0 to get back.");
                    zero = scanner.nextLine();
                    if (zero.equals("0")) memberOptions();
                    else System.out.println("WTF!!!");
                }
                break;
            case "2":
                System.out.println("Enter your ID: ");
                int id = scanner.nextInt();
                System.out.println("Enter book's ID: ");
                int bookId = scanner.nextInt();
                Member member = File.getMember(id);
                Book book = File.getBook(bookId);
                if (book == null) {
                    System.out.println("Book with " + bookId + " id doesn't exist.");
                } else if (member == null) {
                    System.out.println("Member with " + id + " id doesn't exist.");
                } else {
                    Rent rent = new Rent(member, book);
                    rent.save();
                }
                System.out.println("Type 0 to get back.");
                zero = scanner.nextLine();
                if (zero.equals("0")) memberOptions();
                else {
                    System.out.println("Wrong command!");
                    System.out.println("Type 0 to get back.");
                    zero = scanner.nextLine();
                    if (zero.equals("0")) memberOptions();
                    else System.out.println("WTF!!!");
                }
                break;
            case "3":
                System.out.println("Enter your name: ");
                String removeMemberName =
                        scanner.nextLine();
                System.out.println("Enter your national " +
                        "code: ");
                int removeMemberNationalCode =
                        scanner.nextInt();
                Member removeMember = new Member(removeMemberName
                        , removeMemberNationalCode);
                removeMember.remove();
                System.out.println("Account deleted " +
                        "successfully!");
                System.out.println("Type 0 to get back.");
                zero = scanner.nextLine();
                if (zero.equals("0")) memberOptions();
                else {
                    System.out.println("Wrong command!");
                    System.out.println("Type 0 to get back.");
                    zero = scanner.nextLine();
                    if (zero.equals("0")) memberOptions();
                    else System.out.println("WTF!!!");
                }
                break;
            case "0":
                memberMenu();
                break;
            default:
                System.out.println("Wrong command!");
                memberOptions();
                break;
        }
    }
}
