package az.rahimov.librarymanagment.exceptions;

public class BookNotFound extends RuntimeException {
    public BookNotFound(String s) {
        super(s);
    }
}
