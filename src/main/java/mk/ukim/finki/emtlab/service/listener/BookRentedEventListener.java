package mk.ukim.finki.emtlab.service.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.emtlab.model.domain.BookRentActivity;
import mk.ukim.finki.emtlab.model.domain.BookUnavailableLog;
import mk.ukim.finki.emtlab.model.domain.enums.BookEventType;
import mk.ukim.finki.emtlab.model.event.BookRentedEvent;
import mk.ukim.finki.emtlab.repository.BookRentActivityRepository;
import mk.ukim.finki.emtlab.repository.BookUnavailableLogRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookRentedEventListener {

    private final BookRentActivityRepository bookRentActivityRepository;
    private final BookUnavailableLogRepository bookUnavailableLogRepository;

    @EventListener
    public void onBookRented(BookRentedEvent event) {
        var book = event.getBook();

        log.info("Book rented: [id={}, name='{}'], copies remaining: {}",
                book.getId(), book.getName(), book.getAvailableCopies());

        bookRentActivityRepository.save(new BookRentActivity(
                null,
                book.getName(),
                LocalDateTime.now(),
                BookEventType.RENTED
        ));

        if (book.getAvailableCopies() == 0) {
            log.warn("Book [id={}, name='{}'] has no more available copies!",
                    book.getId(), book.getName());

            bookUnavailableLogRepository.save(new BookUnavailableLog(
                    null,
                    book.getId(),
                    book.getName(),
                    LocalDateTime.now()
            ));
        }
    }
}