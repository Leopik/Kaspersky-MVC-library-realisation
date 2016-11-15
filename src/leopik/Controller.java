package leopik;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Leopik on 13.11.2016.
 */
public class Controller {

    Library library;
    LibView libView;

    Controller(Library library, LibView libView) {
        this.library = library;
        this.libView = libView;
        startGettingInput();
    }

    private void startGettingInput() {
        Scanner input = new Scanner(System.in);
        String enteredText[];

        while (input.hasNext()) {
            enteredText = input.nextLine().split("\\s+"); // Splits text by all whitespaces, tabs, etc.
            boolean success;

            // TODO: handle wrong params
            // TODO: allow book names with spaces
            switch (enteredText[0]) {
                case "givebook":
                    success = library.giveBookTo(enteredText[1], enteredText[2]);
                    if (success) {
                        libView.notifySuccess();
                    } else {
                        libView.notifyFailure();
                    }
                    break;
                case "getbook":
                    success = library.receiveBook(enteredText[1]);
                    if (success) {
                        libView.notifySuccess();
                    } else {
                        libView.notifyFailure();
                    }
                    break;
                case "getavailbooks":
                    libView.printAvailBooks();
                    break;
                case "exit":
                    System.exit(1);
                    break;
                case "help":
                    LibView.printHelp();
                    break;
                case "booklist":
                    libView.printBookList();
                    break;
                case "visitorslist":
                    libView.printVisitorsList();
                    break;
                case "getexpvisitors":
                    libView.printExpVisitors();
                    break;
                case "getexpbooks":
                    libView.printExpBooks();
                    break;
                default:
                    System.out.println("I don't know this command");
                    break;
            }
        }
    }
}
