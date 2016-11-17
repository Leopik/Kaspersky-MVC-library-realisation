package leopik;

import java.util.*;

/**
 * Created by Leopik on 17.11.2016.
 */
public class BookSet implements BookContainer {

    Set<Book> bookSet = new TreeSet<>(new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });

    BookSet() {
        bookSet.add(new Book("RobinsonCrusoe"));
        bookSet.add(new Book("Clarissa"));
        bookSet.add(new Book("TomJones"));
        bookSet.add(new Book("Frankenstein"));
        bookSet.add(new Book("NightmareAbbey"));
        bookSet.add(new Book("Sybil"));
        bookSet.add(new Book("JaneEyre"));
        bookSet.add(new Book("VanityFair"));
        bookSet.add(new Book("DavidCopperfield"));
    }

    @Override
    public List<Book> getBooks() {
        return Arrays.asList(bookSet.toArray(new Book[bookSet.size()]));
    }

    @Override
    public int getBookCount() {
        return bookSet.size();
    }
}
