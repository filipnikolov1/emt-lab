package mk.ukim.finki.emtlab.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emtlab.model.dto.DisplayBookDetailsViewDto;
import mk.ukim.finki.emtlab.model.exception.BookNotFoundException;
import mk.ukim.finki.emtlab.service.application.BookDetailsViewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books/view")
@RequiredArgsConstructor
public class BookDetailsViewController {

    private final BookDetailsViewApplicationService bookDetailsViewApplicationService;

    @GetMapping
    public ResponseEntity<List<DisplayBookDetailsViewDto>> findAll() {
        return ResponseEntity.ok(bookDetailsViewApplicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayBookDetailsViewDto> findById(@PathVariable Long id) {
        return bookDetailsViewApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BookNotFoundException(id));
    }
}