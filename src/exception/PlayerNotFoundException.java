package exception;

public class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException(String m) {
        super(m);
    }

    public PlayerNotFoundException() {

    }
}