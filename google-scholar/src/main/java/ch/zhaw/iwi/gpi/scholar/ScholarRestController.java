package ch.zhaw.iwi.gpi.scholar;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ScholarRestController
 */
@RestController
public class ScholarRestController {

    @Autowired
    private PaperRepository paperRepository;

    @RequestMapping(path = "/gsapi/papers/{doi}", method = RequestMethod.GET)
    public ResponseEntity<Paper> getPaper(@PathVariable String doi) {
        Optional<Paper> paper = paperRepository.findById(doi);
        
        if(paper.isPresent()){
            return new ResponseEntity<Paper>(paper.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}