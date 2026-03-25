package mk.ukim.finki.emtlab.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emtlab.model.dto.BookFilter;
import mk.ukim.finki.emtlab.model.dto.CreateBookDto;
import mk.ukim.finki.emtlab.model.dto.DisplayBookDto;
import mk.ukim.finki.emtlab.model.projection.BookDetailProjection;
import mk.ukim.finki.emtlab.model.projection.BookSummaryProjection;
import mk.ukim.finki.emtlab.service.application.BookApplicationService;
import mk.ukim.finki.emtlab.service.domain.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookApplicationServiceImpl implements BookApplicationService {

    private final BookService bookService;

    @Override
    public Page<DisplayBookDto> findAll(BookFilter filter, Pageable pageable) {
        return bookService.findAll(filter, pageable)
                .map(DisplayBookDto::from);
    }

    @Override
    public List<DisplayBookDto> findAll() {
        return bookService.findAll()
                .stream()
                .map(DisplayBookDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayBookDto> findById(Long id) {
        return bookService.findById(id)
                .map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> save(CreateBookDto bookDto) {
        return bookService.save(bookDto)
                .map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> update(Long id, CreateBookDto bookDto) {
        return bookService.update(id, bookDto)
                .map(DisplayBookDto::from);
    }

    @Override
    public void deleteById(Long id) {
        bookService.deleteById(id);
    }

    @Override
    public List<DisplayBookDto> filterById(Long a, Long b) {
        return bookService.filterById(a, b)
                .stream()
                .map(DisplayBookDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayBookDto> rent(Long id) {
        return bookService.rent(id)
                .map(DisplayBookDto::from);
    }

    @Override
    public List<BookSummaryProjection> findAllSummary() {
        return bookService.findAllSummary();
    }

    @Override
    public Optional<BookDetailProjection> findDetailById(Long id) {
        return bookService.findDetailById(id);
    }

    @Override
    public List<DisplayBookDto> findAllWithAuthorAndCountry() {
        return bookService.findAllWithAuthorAndCountry()
                .stream()
                .map(DisplayBookDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayBookDto> findWithAuthorAndCountryById(Long id) {
        return bookService.findWithAuthorAndCountryById(id)
                .map(DisplayBookDto::from);
    }
}