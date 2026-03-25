package mk.ukim.finki.emtlab.model.exception;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(Long id) {
        super("Book with id " + id + " is not available for renting");
    }
}