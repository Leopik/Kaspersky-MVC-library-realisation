package leopik;

import java.util.Date;

/**
 * Created by Leopik on 10.11.2016.
 */
public class Book {

    private String name;
    private Person holder = null;
    private Date dateOfTaking = null;

    public String getName() {
        return name;
    }

    public Person getHolder() {
        return holder;
    }

    public Date getDateOfTaking() {
        return dateOfTaking;
    }

    public void setHolder(Person holder) {
        this.holder = holder;
    }

    public void setDateOfTaking(Date dateOfTaking) {
        this.dateOfTaking = dateOfTaking;
    }

    Book(String name) {
        this.name = name;
    }
}
