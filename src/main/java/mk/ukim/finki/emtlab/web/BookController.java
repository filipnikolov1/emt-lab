package mk.ukim.finki.emtlab.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import mk.ukim.finki.emtlab.model.domain.enums.BookSortField;
import mk.ukim.finki.emtlab.model.domain.enums.BookState;
import mk.ukim.finki.emtlab.model.dto.BookFilter;
import mk.ukim.finki.emtlab.model.dto.CreateBookDto;
import mk.ukim.finki.emtlab.model.dto.DisplayBookDto;
import mk.ukim.finki.emtlab.model.exception.BookNotFoundException;
import mk.ukim.finki.emtlab.model.projection.BookDetailProjection;
import mk.ukim.finki.emtlab.model.projection.BookSummaryProjection;
import mk.ukim.finki.emtlab.service.application.BookApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookApplicationService bookApplicationService;

    @GetMapping
    public ResponseEntity<Page<DisplayBookDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") BookSortField sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(required = false) BookCategory category,
            @RequestParam(required = false) BookState state,
            @RequestParam(required = false) Long authorId,
            @RequestParam(required = false) Boolean availableCopiesOnly
    ) {
        Sort sort = sortDirection.equalsIgnoreCase("desc")
                ? Sort.by(sortBy.name()).descending()
                : Sort.by(sortBy.name()).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        BookFilter filter = new BookFilter(category, state, authorId, availableCopiesOnly);

        return ResponseEntity.ok(bookApplicationService.findAll(filter, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayBookDto> findById(@PathVariable Long id) {
        return bookApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayBookDto> save(@RequestBody @Valid CreateBookDto bookDto) {
        return bookApplicationService.save(bookDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayBookDto> update(@PathVariable Long id,
                                                 @RequestBody @Valid CreateBookDto bookDto) {
        return bookApplicationService.update(id, bookDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookApplicationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/filter")
    public ResponseEntity<List<DisplayBookDto>> filterById(@RequestParam Long a, @RequestParam Long b) {
        return ResponseEntity.ok(bookApplicationService.filterById(a, b));
    }

    @PatchMapping("/{id}/rent")
    public ResponseEntity<DisplayBookDto> rent(@PathVariable Long id) {
        return bookApplicationService.rent(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @GetMapping("/summaries")
    public ResponseEntity<List<BookSummaryProjection>> findAllSummary() {
        return ResponseEntity.ok(bookApplicationService.findAllSummary());
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<BookDetailProjection> findDetailById(@PathVariable Long id) {
        return bookApplicationService.findDetailById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @GetMapping("/with-author")
    public ResponseEntity<List<DisplayBookDto>> findAllWithAuthorAndCountry() {
        return ResponseEntity.ok(bookApplicationService.findAllWithAuthorAndCountry());
    }

    @GetMapping("/{id}/with-author")
    public ResponseEntity<DisplayBookDto> findWithAuthorAndCountryById(@PathVariable Long id) {
        return bookApplicationService.findWithAuthorAndCountryById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BookNotFoundException(id));
    }
}