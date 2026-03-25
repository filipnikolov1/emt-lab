package mk.ukim.finki.emtlab.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emtlab.model.dto.DisplayBookRentActivityDto;
import mk.ukim.finki.emtlab.repository.BookRentActivityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books/activity")
@RequiredArgsConstructor
public class BookActivityController {

    private final BookRentActivityRepository bookRentActivityRepository;

    @GetMapping
    public ResponseEntity<Page<DisplayBookRentActivityDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(
                bookRentActivityRepository.findAllPaged(pageable)
                        .map(DisplayBookRentActivityDto::from)
        );
    }
}