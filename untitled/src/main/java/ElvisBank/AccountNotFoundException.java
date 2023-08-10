package ElvisBank;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("Account not found!");
    }
}