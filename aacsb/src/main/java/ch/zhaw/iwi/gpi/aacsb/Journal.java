package ch.zhaw.iwi.gpi.aacsb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * JournalEntity
 */
@Entity
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long journalId;
    private String journalTitle;
    private Integer journalRating;

    public Long getJournalId() {
        return journalId;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    public Integer getJournalRating() {
        return journalRating;
    }

    public void setJournalRating(Integer journalRating) {
        this.journalRating = journalRating;
    }

    
    
}