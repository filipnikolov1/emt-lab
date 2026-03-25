package mk.ukim.finki.emtlab.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import mk.ukim.finki.emtlab.model.dto.DisplayBookCategoryStatsDto;
import mk.ukim.finki.emtlab.repository.BookCategoryStatsViewRepository;
import mk.ukim.finki.emtlab.service.application.BookStatsApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookStatsApplicationServiceImpl implements BookStatsApplicationService {

    private final BookCategoryStatsViewRepository bookCategoryStatsViewRepository;

    @Override
    public List<DisplayBookCategoryStatsDto> findAll() {
        return bookCategoryStatsViewRepository.findAll()
                .stream()
                .map(DisplayBookCategoryStatsDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayBookCategoryStatsDto> findByCategory(BookCategory category) {
        return bookCategoryStatsViewRepository.findById(category)
                .map(DisplayBookCategoryStatsDto::from);
    }
}