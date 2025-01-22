package exception;

public class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException() {}
    public PlayerNotFoundException(String m) {
        super(m);
    }
}