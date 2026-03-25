package mk.ukim.finki.emtlab.model.dto;

import mk.ukim.finki.emtlab.model.domain.BookRentActivity;
import mk.ukim.finki.emtlab.model.domain.enums.BookEventType;

import java.time.LocalDateTime;

public record DisplayBookRentActivityDto(
        Long id,
        String bookName,
        LocalDateTime rentedAt,
        BookEventType eventType
) {
    public static DisplayBookRentActivityDto from(BookRentActivity activity) {
        return new DisplayBookRentActivityDto(
                activity.getId(),
                activity.getBookName(),
                activity.getRentedAt(),
                activity.getEventType()
        );
    }
}