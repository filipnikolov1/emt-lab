package mk.ukim.finki.emtlab.model.dto;

import mk.ukim.finki.emtlab.model.domain.Book;
import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import mk.ukim.finki.emtlab.model.domain.enums.BookState;

public record DisplayBookDto(
        Long id,
        String name,
        BookCategory category,
        DisplayAuthorDto author,
        BookState state,
        Integer availableCopies
) {
    public static DisplayBookDto from(Book book) {
        return new DisplayBookDto(
                book.getId(),
                book.getName(),
                book.getCategory(),
                DisplayAuthorDto.from(book.getAuthor()),
                book.getState(),
                book.getAvailableCopies()
        );
    }
}
