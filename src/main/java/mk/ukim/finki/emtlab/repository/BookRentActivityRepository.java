package mk.ukim.finki.emtlab.repository;

import mk.ukim.finki.emtlab.model.domain.BookRentActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRentActivityRepository extends JpaRepository<BookRentActivity, Long> {

    @Query("SELECT b FROM BookRentActivity b ORDER BY b.rentedAt DESC")
    Page<BookRentActivity> findAllPaged(Pageable pageable);
}