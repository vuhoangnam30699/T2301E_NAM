package ElvisBank;

public class BalanceNotEnoughException extends RuntimeException {
    public BalanceNotEnoughException() {
        super("Balance not enough!");
    }
}
