package mk.ukim.finki.emtlab.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import mk.ukim.finki.emtlab.model.domain.enums.BookState;

public record CreateBookDto(
        @NotBlank(message = "Name is required.")
        String name,
        @NotNull(message = "Category is required.")
        BookCategory category,
        @NotNull(message = "Author is required.")
        Long authorId,
        @NotNull(message = "State is required.")
        BookState state,
        @NotNull(message = "Available copies is required.")
        @Min(value = 0, message = "Avaiable copies cannot be negative.")
        Integer availableCopies
) {
}
