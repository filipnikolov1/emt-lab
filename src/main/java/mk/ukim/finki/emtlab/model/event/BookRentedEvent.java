package mk.ukim.finki.emtlab.model.event;

import lombok.Getter;
import mk.ukim.finki.emtlab.model.domain.Book;
import org.springframework.context.ApplicationEvent;

@Getter
public class BookRentedEvent extends ApplicationEvent {

    private final Book book;

    public BookRentedEvent(Object source, Book book) {
        super(source);
        this.book = book;
    }

}