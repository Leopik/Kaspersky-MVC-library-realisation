package leopik;

import java.util.*;

/**
 * Created by Leopik on 13.11.2016.
 */
public class LibView {

    private final static String helpText = "Вы библиотекарь и это программа по управлению библиотекой\nВот список команд которые вы можете использовать (вводите название команды, оно в скобках возле каждого пункта меню)";
    private final static String commands[] = {"Book list, even books that are not available right now (booklist)", "All available books (getavailbooks)", "Visitors list (visitorslist)", "Give book to visitor (givebook visitor_name_visitor_surname book_name (between name and surname no whitespaces))", "Get book from visitor (getbook book_name)", "Get all expired books (getexpbooks)", "Get visitors with expired books (getexpvisitors)", "Help (help)", "Exit (exit)"};
    private final static List<String> menuText = Arrays.asList(commands);
    private Library library;

    /**
     * IMPORTANT! Right now only books that are named only with one word accepted
     * IMPORTANT! If you pass wrong parameter to command - will be exception
     */
    public static void main(String[] args) {
        // You can change this to import books and persons from another place (file, internet, etc.)

        List<Book> bookList;

        switch (args[0]) {
            case "set":
                bookList = new BookSet().getBooks();
                break;
            case "list":
                bookList = new BookList().getBooks();
                break;
            case "array":
                bookList = new BookArray().getBooks();
                break;
            default:
                bookList = null;
                System.exit(1);
                break;
        }


        Person personArray[] = {new Person("John", "Smith"), new Person("Taylor", "Swift"), new Person("Oliver", "Sykes"), new Person("Kevin", "Ratajczak"), new Person("Matthew", "Bellamy"), new Person("Chester", "Bennington")};

        Library library = new Library(Arrays.asList(personArray), bookList);

        new Controller(library, new LibView(library));
    }

    LibView(Library library) {
        this.library = library;
        printMenu();
    }

    public void printAvailBooks() {
        List<Book> availBooks = library.getAvailBooks();

        System.out.println("List of all available books:");

        for (Book availBook:availBooks) {
            System.out.println(availBook.getName());
        }
    }

    public void printBookList() {
        List<Book> bookList = library.getBookList();

        System.out.println("List of all books:");

        for (Book book:bookList) {
            System.out.println(book.getName());
        }
    }

    public void printVisitorsList() {
        List<Person> visitors = library.getRegisteredVisitors();
        System.out.println("List of all registered visitors:");

        for (Person visitor:visitors) {
            System.out.println(visitor.getName() + " " + visitor.getSurname());
        }
    }

    public void printExpVisitors() {
        List<Person> expVisitors = library.getExpVisitors();
        System.out.println("List of people who have expired books:");

        for (Person expPerson:expVisitors) {
            System.out.println(expPerson.getName() + " " + expPerson.getSurname());
        }
    }

    public void notifySuccess() {
        System.out.println("Command was executed successfully");
    }

    public void notifyFailure() {
        System.out.println("Sorry, command was executed, probably you passed wrong parameter");
    }

    public void printExpBooks() {
        List<Book> expBooks = library.getExpBooks();
        System.out.println("List of all expired books:");

        for (Book book:expBooks) {
            System.out.println(book.getName());
        }
    }

    public static void printHelp() {
        System.out.println("Help:");
        System.out.println(helpText);
        printMenu();
    }

    public static void printMenu() {
        System.out.println("Menu:");
        for (String menuItem:menuText) {
            System.out.println(menuItem);
        }
    }

}
