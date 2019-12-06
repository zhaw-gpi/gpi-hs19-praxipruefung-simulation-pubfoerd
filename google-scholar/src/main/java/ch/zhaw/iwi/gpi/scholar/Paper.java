package ch.zhaw.iwi.gpi.scholar;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Paper
 */
@Entity
public class Paper {

    @Id
    private String doi;
    private String author;
    private String title;
    private Integer citations;

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCitations() {
        return citations;
    }

    public void setCitations(Integer citations) {
        this.citations = citations;
    }

    
}