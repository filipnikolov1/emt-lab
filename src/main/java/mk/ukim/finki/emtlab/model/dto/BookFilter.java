package mk.ukim.finki.emtlab.model.dto;

import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import mk.ukim.finki.emtlab.model.domain.enums.BookState;

public record BookFilter(
        BookCategory category,
        BookState state,
        Long authorId,
        Boolean availableCopiesOnly
) {
}