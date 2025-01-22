package exception;

public class InsufficientDataException extends Exception {
    InsufficientDataException() {}
    InsufficientDataException(String m) {
        super(m);
    }
}
