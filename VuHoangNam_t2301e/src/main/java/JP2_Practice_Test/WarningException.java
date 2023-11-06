package JP2_Practice_Test;

public class WarningException extends Throwable {
    private DataWarning warning;

    public WarningException(DataWarning warning) {
        this.warning = warning;
    }

    public DataWarning getWarning() {
        return warning;
    }

    public void setWarning(DataWarning warning) {
        this.warning = warning;
    }
}
