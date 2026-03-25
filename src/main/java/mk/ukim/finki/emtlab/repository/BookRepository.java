package mk.ukim.finki.emtlab.repository;

import mk.ukim.finki.emtlab.model.domain.Book;
import mk.ukim.finki.emtlab.model.projection.BookDetailProjection;
import mk.ukim.finki.emtlab.model.projection.BookSummaryProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    List<Book> findAllByIdBetween(Long a, Long b);

    @Query(value = "SELECT b.id AS id, b.name AS name, b.category AS category, b.state AS state, b.available_copies AS availableCopies FROM books b", nativeQuery = true)
    List<BookSummaryProjection> findAllProjectedBy();

    @Query(value = """
        SELECT b.id AS id, b.name AS name, b.category AS category, b.state AS state,
               b.available_copies AS availableCopies,
               a.name AS authorName, a.surname AS authorSurname,
               c.name AS countryName
        FROM books b
        JOIN authors a ON b.author_id = a.id
        JOIN countries c ON a.country_id = c.id
        WHERE b.id = :id
        """, nativeQuery = true)
    Optional<BookDetailProjection> findProjectedById(Long id);

    @EntityGraph(value = "BookWithAuthorWithCountry")
    List<Book> findAllWithAuthorAndCountryBy();

    @EntityGraph(value = "BookWithAuthorWithCountry")
    Optional<Book> findWithAuthorAndCountryById(Long id);
}