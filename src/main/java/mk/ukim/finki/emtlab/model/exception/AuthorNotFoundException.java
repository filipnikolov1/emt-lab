package mk.ukim.finki.emtlab.model.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id) {
        super("Author with id " + id + " not found");
    }
}
