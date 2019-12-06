package ch.zhaw.iwi.gpi.aacsb;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JournalRepository
 */
public interface JournalRepository extends JpaRepository<Journal, Long> {

    Optional<Journal> findByJournalTitle(String journalTitle);

}