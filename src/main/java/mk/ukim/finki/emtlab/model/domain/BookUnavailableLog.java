package mk.ukim.finki.emtlab.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_unavailable_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUnavailableLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;
    private String bookName;
    private LocalDateTime loggedAt;
}