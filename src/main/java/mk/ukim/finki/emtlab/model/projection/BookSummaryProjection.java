package mk.ukim.finki.emtlab.model.projection;

import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import mk.ukim.finki.emtlab.model.domain.enums.BookState;

public interface BookSummaryProjection {
    Long getId();

    String getName();

    BookCategory getCategory();

    BookState getState();

    Integer getAvailableCopies();
}