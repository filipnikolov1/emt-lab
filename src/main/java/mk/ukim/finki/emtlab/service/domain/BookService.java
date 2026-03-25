package mk.ukim.finki.emtlab.service.domain;

import mk.ukim.finki.emtlab.model.domain.Book;
import mk.ukim.finki.emtlab.model.dto.BookFilter;
import mk.ukim.finki.emtlab.model.dto.CreateBookDto;
import mk.ukim.finki.emtlab.model.projection.BookDetailProjection;
import mk.ukim.finki.emtlab.model.projection.BookSummaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Page<Book> findAll(BookFilter filter, Pageable pageable);
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(CreateBookDto bookDto);
    Optional<Book> update(Long id, CreateBookDto bookDto);
    void deleteById(Long id);
    List<Book> filterById(Long a, Long b);
    Optional<Book> rent(Long id);
    List<BookSummaryProjection> findAllSummary();
    Optional<BookDetailProjection> findDetailById(Long id);
    List<Book> findAllWithAuthorAndCountry();
    Optional<Book> findWithAuthorAndCountryById(Long id);
}
