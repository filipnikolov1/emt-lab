package mk.ukim.finki.emtlab.repository;

import mk.ukim.finki.emtlab.model.domain.views.BookDetailsView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailsViewRepository extends JpaRepository<BookDetailsView, Long> {
}