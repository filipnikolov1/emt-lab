package mk.ukim.finki.emtlab.repository;

import mk.ukim.finki.emtlab.model.domain.BookUnavailableLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookUnavailableLogRepository extends JpaRepository<BookUnavailableLog, Long> {
}