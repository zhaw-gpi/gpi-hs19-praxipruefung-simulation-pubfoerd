package ch.zhaw.gpi.prozessapplikation;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * SendDecisionDelegate
 */
@Named("sendDecision")
public class SendDecisionDelegate implements JavaDelegate {

    @Autowired
    private MailService mailService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String applicant = (String) execution.getVariable("applicant");
        Integer score = (Integer) execution.getVariable("score");
        Boolean decision = (Boolean) execution.getVariable("decision");
        String decisionReasons = (String) execution.getVariable("decisionReasons");

        String subject;
        String begruendung;
        String bodyMain;
        
        if(score < 4 || !decision){
            if(score < 4){
                begruendung = "Der automatisch berechnete Score ist kleiner als 5.";
            } else {
                begruendung = decisionReasons;
            }

            subject = "Der Antrag wurde abgelehnt";
            bodyMain = "Der Antrag wurde abgelehnt mit folgender Begründung: " + begruendung;
        } else {
            subject = "Publikationsförder-Antrag angenommen";
            bodyMain = "Wir wünschen viel Erfolg beim Schreiben des Artikels.";
        }

        mailService.sendMail(applicant + "@firma.ch", subject, bodyMain);
    }    
}