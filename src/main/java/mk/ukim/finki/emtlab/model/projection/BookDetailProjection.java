package mk.ukim.finki.emtlab.model.projection;

import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import mk.ukim.finki.emtlab.model.domain.enums.BookState;

public interface BookDetailProjection {
    Long getId();

    String getName();

    BookCategory getCategory();

    BookState getState();

    Integer getAvailableCopies();

    String getAuthorName();

    String getAuthorSurname();

    String getCountryName();
}