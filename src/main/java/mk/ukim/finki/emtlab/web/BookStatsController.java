package mk.ukim.finki.emtlab.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import mk.ukim.finki.emtlab.model.dto.DisplayBookCategoryStatsDto;
import mk.ukim.finki.emtlab.service.application.BookStatsApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books/stats")
@RequiredArgsConstructor
public class BookStatsController {

    private final BookStatsApplicationService bookStatsApplicationService;

    @GetMapping
    public ResponseEntity<List<DisplayBookCategoryStatsDto>> findAll() {
        return ResponseEntity.ok(bookStatsApplicationService.findAll());
    }

    @GetMapping("/{category}")
    public ResponseEntity<DisplayBookCategoryStatsDto> findByCategory(@PathVariable BookCategory category) {
        return bookStatsApplicationService.findByCategory(category)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}