package mk.ukim.finki.emtlab.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emtlab.model.domain.enums.BookEventType;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_rent_activity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRentActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;
    private LocalDateTime rentedAt;

    @Enumerated(EnumType.STRING)
    private BookEventType eventType;
}