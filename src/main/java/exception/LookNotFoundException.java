package exception;

import java.util.NoSuchElementException;

public class LookNotFoundException extends NoSuchElementException {

    public LookNotFoundException(String name) {
        super("No look with " + name + " found");
    }
}
