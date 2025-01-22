package exception;

public class TeamNotFoundException extends Exception {
    public TeamNotFoundException() {}
    public TeamNotFoundException(String m) {
        super(m);
    }
}