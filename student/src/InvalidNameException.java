public class InvalidNameException extends CommonException {
    public InvalidNameException(String name) {
        super(100, "Name " + name + " is not valid");
    }
}
