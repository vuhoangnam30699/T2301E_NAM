package exception;

public class InvalidScoreException extends RuntimeException {
    public InvalidScoreException() {
        super("Score is invalid");
    }

}
