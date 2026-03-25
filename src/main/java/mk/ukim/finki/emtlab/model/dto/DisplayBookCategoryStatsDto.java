package mk.ukim.finki.emtlab.model.dto;

import mk.ukim.finki.emtlab.model.domain.BookCategoryStatsView;
import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;

public record DisplayBookCategoryStatsDto(
        BookCategory category,
        Long totalBooks,
        Long totalAvailableCopies,
        Long booksNotInGoodState
) {
    public static DisplayBookCategoryStatsDto from(BookCategoryStatsView view) {
        return new DisplayBookCategoryStatsDto(
                view.getCategory(),
                view.getTotalBooks(),
                view.getTotalAvailableCopies(),
                view.getBooksNotInGoodState()
        );
    }
}