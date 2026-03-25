package mk.ukim.finki.emtlab.repository;

import org.springframework.transaction.annotation.Transactional;
import mk.ukim.finki.emtlab.model.domain.BookCategoryStatsView;
import mk.ukim.finki.emtlab.model.domain.enums.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookCategoryStatsViewRepository extends JpaRepository<BookCategoryStatsView, BookCategory> {
    @Modifying
    @Transactional
    @Query(value = "REFRESH MATERIALIZED VIEW book_category_stats_view", nativeQuery = true)
    void refresh();
}