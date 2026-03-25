package mk.ukim.finki.emtlab.service.application;

import mk.ukim.finki.emtlab.model.dto.BookFilter;
import mk.ukim.finki.emtlab.model.dto.CreateBookDto;
import mk.ukim.finki.emtlab.model.dto.DisplayBookDto;
import mk.ukim.finki.emtlab.model.projection.BookDetailProjection;
import mk.ukim.finki.emtlab.model.projection.BookSummaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    Page<DisplayBookDto> findAll(BookFilter filter, Pageable pageable);
    List<DisplayBookDto> findAll();
    Optional<DisplayBookDto> findById(Long id);
    Optional<DisplayBookDto> save(CreateBookDto bookDto);
    Optional<DisplayBookDto> update(Long id, CreateBookDto bookDto);
    void deleteById(Long id);
    List<DisplayBookDto> filterById(Long a, Long b);
    Optional<DisplayBookDto> rent(Long id);
    List<BookSummaryProjection> findAllSummary();
    Optional<BookDetailProjection> findDetailById(Long id);
    List<DisplayBookDto> findAllWithAuthorAndCountry();
    Optional<DisplayBookDto> findWithAuthorAndCountryById(Long id);
}