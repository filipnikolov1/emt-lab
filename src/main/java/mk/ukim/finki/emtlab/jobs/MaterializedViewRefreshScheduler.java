package mk.ukim.finki.emtlab.jobs;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.emtlab.repository.BookCategoryStatsViewRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MaterializedViewRefreshScheduler {

    private final BookCategoryStatsViewRepository bookCategoryStatsViewRepository;

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void refreshBookCategoryStatsView() {
        log.info("Refreshing book_category_stats_view...");
        bookCategoryStatsViewRepository.refresh();
        log.info("book_category_stats_view successfully refreshed.");
    }
}