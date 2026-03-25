package mk.ukim.finki.emtlab.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import mk.ukim.finki.emtlab.model.domain.enums.BookState;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@NamedEntityGraph(
        name = "BookWithAuthorWithCountry",
        attributeNodes = @NamedAttributeNode(value = "author", subgraph = "author-subgraph"),
        subgraphs = @NamedSubgraph(
                name = "author-subgraph",
                attributeNodes = @NamedAttributeNode("country")
        )
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private String name;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Enumerated(EnumType.STRING)
    private BookState state;

    private Integer availableCopies;
}
