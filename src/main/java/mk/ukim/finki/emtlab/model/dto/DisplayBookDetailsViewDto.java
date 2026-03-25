package mk.ukim.finki.emtlab.model.dto;

import mk.ukim.finki.emtlab.model.domain.views.BookDetailsView;
import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import mk.ukim.finki.emtlab.model.domain.enums.BookState;

public record DisplayBookDetailsViewDto(
        Long id,
        String name,
        BookCategory category,
        BookState state,
        Integer availableCopies,
        String authorFullName,
        String countryName
) {
    public static DisplayBookDetailsViewDto from(BookDetailsView view) {
        return new DisplayBookDetailsViewDto(
                view.getId(),
                view.getName(),
                view.getCategory(),
                view.getState(),
                view.getAvailableCopies(),
                view.getAuthorFullName(),
                view.getCountryName()
        );
    }
}