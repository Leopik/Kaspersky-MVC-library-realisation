package leopik;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leopik on 17.11.2016.
 */
public class BookList implements BookContainer {

    ArrayList<Book> bookList = new ArrayList<>();

    BookList() {
        bookList.add(new Book("TheScarletLetter"));
        bookList.add(new Book("Moby-Dick"));
        bookList.add(new Book("TheMoonstone"));
        bookList.add(new Book("LittleWomen"));
        bookList.add(new Book("Middlemarch"));
        bookList.add(new Book("Kidnapped"));
        bookList.add(new Book("TheSignofFour"));
        bookList.add(new Book("NewGrubStreet"));
        bookList.add(new Book("Dracula"));
    }

    @Override
    public List<Book> getBooks() {
        return bookList;
    }

    @Override
    public int getBookCount() {
        return bookList.size();
    }
}
