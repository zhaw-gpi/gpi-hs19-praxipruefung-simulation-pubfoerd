package ch.zhaw.iwi.gpi.aacsb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * AacsbRestController
 */
@RestController
public class AacsbRestController {

    @Autowired
    private JournalRepository journalRepository;

    @RequestMapping(value = "/journals/{journalTitle}", method = RequestMethod.GET)
    public ResponseEntity<Journal> getJournal(@PathVariable String journalTitle){
        Optional<Journal> journal = journalRepository.findByJournalTitle(journalTitle);

        if(journal.isPresent()){
            return new ResponseEntity<Journal>(journal.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}