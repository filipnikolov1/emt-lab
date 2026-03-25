package mk.ukim.finki.emtlab.service.application;

import mk.ukim.finki.emtlab.model.dto.DisplayBookCategoryStatsDto;
import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;

import java.util.List;
import java.util.Optional;

public interface BookStatsApplicationService {
    List<DisplayBookCategoryStatsDto> findAll();
    Optional<DisplayBookCategoryStatsDto> findByCategory(BookCategory category);
}