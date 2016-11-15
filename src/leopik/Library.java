package leopik;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Leopik on 13.11.2016.
 */
public class Library {
    private List<Person> registeredVisitors;
    private List<Book> bookList;
    private int daysToHold = 30;

    public List<Person> getRegisteredVisitors() {
        return registeredVisitors;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    Library(List<Person> persons, List<Book> books) {
        registeredVisitors = persons;
        bookList = books;
    }

    /**
     * @return List of books that should be already given back, but they are not (expired books)
     */
    public List<Book> getExpBooks() {
        Date currentDate = new Date();
        List<Book> expBooks = new ArrayList<>();

        for (Book book:bookList) {
            if (book.getHolder() != null &&
                    getDifferenceDays(book.getDateOfTaking(), currentDate) > daysToHold) {
                expBooks.add(book);
            }
        }
        return expBooks;
    }

    public List<Book> getAvailBooks() {
        List<Book> availBooks = new ArrayList<>();

        for (Book book:getBookList()) {
            if (book.getHolder() == null) {
                availBooks.add(book);
            }
        }
        return availBooks;
    }

    public boolean giveBookTo(String personInfo, String bookName) {
        // This is done in order not to search by book name or person name every time. HashMaps handles with this task perfectly
        HashMap<String, Book> tempBookMap = new HashMap<>();
        HashMap<String, Person> tempPersonMap = new HashMap<>();
        HashMap<String, Person> tempExpPersonMap = new HashMap<>();

        // Converting arraylists to hashmaps
        for (Person expPerson:getExpVisitors()) {
            tempExpPersonMap.put(expPerson.getName() + expPerson.getSurname(), expPerson);
        }
        for (Book book:getBookList()) {
            tempBookMap.put(book.getName(), book);
        }
        for (Person person:getRegisteredVisitors()) {
            tempPersonMap.put(person.getName() + person.getSurname(), person);
        }

        // Tries to get book and person by given strings
        Book bookByName = tempBookMap.get(bookName);
        Person personByInfo = tempPersonMap.get(personInfo);

        // If book exists and noone holds it
        if ((bookByName != null) && (bookByName.getHolder() == null)) {
            // If person exists and has no expired books then give book to visitor
            if (personByInfo != null && tempExpPersonMap.get(personInfo) == null && personByInfo.getPersonBookList().size() < 3) {
                bookByName.setHolder(personByInfo);
                bookByName.setDateOfTaking(new Date());
                personByInfo.getPersonBookList().add(bookByName);
                return true;
            }
        }
        return false;
    }

    /**
     * @return list of people who have expired books
     */
    public List<Person> getExpVisitors() {
        List<Person> expVisitors = new ArrayList<>();

        for(Book expBook:getExpBooks()) {
            expVisitors.add(expBook.getHolder());
        }
        return expVisitors;
    }

    /**
     * Gets book back from visitor
     * @return true if operation was successful, false if not
     */
    public boolean receiveBook(String bookName) {
        HashMap<String, Book> tempBookMap = new HashMap<>();

        for (Book book:getBookList()) {
            tempBookMap.put(book.getName(), book);
        }

        if (tempBookMap.get(bookName) != null && tempBookMap.get(bookName).getHolder() != null) {
            tempBookMap.get(bookName).setHolder(null);
            tempBookMap.get(bookName).setDateOfTaking(null);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return days between two given dates
     */
    private static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
