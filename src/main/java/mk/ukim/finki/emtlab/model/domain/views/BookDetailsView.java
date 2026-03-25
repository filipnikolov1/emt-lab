package mk.ukim.finki.emtlab.model.domain.views;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import mk.ukim.finki.emtlab.model.domain.enums.BookState;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "book_details_view")
@Getter
public class BookDetailsView {

    @Id
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    @Enumerated(EnumType.STRING)
    private BookState state;

    private Integer availableCopies;

    private String authorFullName;

    private String countryName;
}