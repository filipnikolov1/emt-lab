package mk.ukim.finki.emtlab.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emtlab.model.domain.Author;
import mk.ukim.finki.emtlab.model.domain.Book;
import mk.ukim.finki.emtlab.model.domain.enums.BookState;
import mk.ukim.finki.emtlab.model.dto.BookFilter;
import mk.ukim.finki.emtlab.model.dto.CreateBookDto;
import mk.ukim.finki.emtlab.model.event.BookRentedEvent;
import mk.ukim.finki.emtlab.model.exception.AuthorNotFoundException;
import mk.ukim.finki.emtlab.model.exception.BookNotAvailableException;
import mk.ukim.finki.emtlab.model.exception.BookNotFoundException;
import mk.ukim.finki.emtlab.model.projection.BookDetailProjection;
import mk.ukim.finki.emtlab.model.projection.BookSummaryProjection;
import mk.ukim.finki.emtlab.model.specification.BookSpecification;
import mk.ukim.finki.emtlab.repository.AuthorRepository;
import mk.ukim.finki.emtlab.repository.BookRepository;
import mk.ukim.finki.emtlab.service.domain.BookService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public Page<Book> findAll(BookFilter filter, Pageable pageable) {
        return bookRepository.findAll(BookSpecification.buildFrom(filter), pageable);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(CreateBookDto bookDto) {
        return authorRepository.findById(bookDto.authorId())
                .map(author -> {
                    Book book = new Book();
                    book.setName(bookDto.name());
                    book.setCategory(bookDto.category());
                    book.setAuthor(author);
                    book.setState(bookDto.state());
                    book.setAvailableCopies(bookDto.availableCopies());
                    return bookRepository.save(book);
                });
    }

    @Override
    public Optional<Book> update(Long id, CreateBookDto bookDto) {
        return bookRepository.findById(id)
                .flatMap(book -> authorRepository.findById(bookDto.authorId())
                        .map(author -> {
                            book.setName(bookDto.name());
                            book.setCategory(bookDto.category());
                            book.setAuthor(author);
                            book.setState(bookDto.state());
                            book.setAvailableCopies(bookDto.availableCopies());
                            return bookRepository.save(book);
                        }));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> filterById(Long a, Long b) {
        return bookRepository.findAllByIdBetween(a, b);
    }

    @Override
    public Optional<Book> rent(Long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    if (book.getState() == BookState.BAD || book.getAvailableCopies() <= 0) {
                        throw new BookNotAvailableException(id);
                    }
                    book.setAvailableCopies(book.getAvailableCopies() - 1);
                    book.setUpdatedAt(LocalDateTime.now());
                    Book savedBook = bookRepository.save(book);
                    eventPublisher.publishEvent(new BookRentedEvent(this, savedBook));
                    return savedBook;
                });
    }

    @Override
    public List<BookSummaryProjection> findAllSummary() {
        return bookRepository.findAllProjectedBy();
    }

    @Override
    public Optional<BookDetailProjection> findDetailById(Long id) {
        return bookRepository.findProjectedById(id);
    }

    @Override
    public List<Book> findAllWithAuthorAndCountry() {
        return bookRepository.findAllWithAuthorAndCountryBy();
    }

    @Override
    public Optional<Book> findWithAuthorAndCountryById(Long id) {
        return bookRepository.findWithAuthorAndCountryById(id);
    }
}