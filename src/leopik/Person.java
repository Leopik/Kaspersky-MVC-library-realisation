package leopik;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leopik on 10.11.2016.
 */
public class Person {

    private String name;
    private String surname;
    private List<Book> personBookList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<Book> getPersonBookList() {
        return personBookList;
    }

    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

}
