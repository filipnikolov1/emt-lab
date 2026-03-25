package mk.ukim.finki.emtlab.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "book_category_stats_view")
@Getter
public class BookCategoryStatsView {

    @Id
    @Enumerated(EnumType.STRING)
    private BookCategory category;

    private Long totalBooks;

    private Long totalAvailableCopies;

    private Long booksNotInGoodState;
}