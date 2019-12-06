package ch.zhaw.gpi.prozessapplikation;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestTemplate;

/**
 * GetRefPaperMetadataDelegate
 */
@Named("getCitations")
public class GetRefPaperCitationsDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String doi = (String) execution.getVariable("refPaperDoi");

        RestTemplate rt = new RestTemplate();

        Paper paper = rt.getForObject("http://localhost:8090/gsapi/papers/{doi}", Paper.class, doi);

        execution.setVariable("refPaperCitations", paper.getCitations());

    }

    
}