package az.rahimov.librarymanagment.exceptions;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String s) {
        super(s);
    }
}
