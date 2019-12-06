package ch.zhaw.gpi.prozessapplikation;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * GetJournalRatingDelegate
 */
@Named("getJournalRating")
public class GetJournalRatingDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String journalTitle = (String) execution.getVariable("journalTitle");

        RestTemplate restTemplate = new RestTemplate();

        Integer journalRating;

        try {
            Journal journal = restTemplate.getForObject("http://localhost:8070/journals/{journalTitle}", Journal.class, journalTitle);
            journalRating = journal.getJournalRating();
        } catch (HttpClientErrorException e) {
            journalRating = 0;
        }

        execution.setVariable("journalAacsbRating", journalRating);

    }

    
}