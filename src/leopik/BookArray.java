package leopik;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Leopik on 17.11.2016.
 */
public class BookArray implements BookContainer {

    Book bookArray[] = {
            new Book("Test"),
            new Book("LabGirl"),
            new Book("GoneGirl"),
            new Book("HarryPotter"),
            new Book("TheHungerGames"),
            new Book("ToKillaMockingbird"),
            new Book("PrideandPrejudice")
    };

    @Override
    public List<Book> getBooks() {
        return Arrays.asList(bookArray);
    }

    @Override
    public int getBookCount() {
        return bookArray.length;
    }
}
