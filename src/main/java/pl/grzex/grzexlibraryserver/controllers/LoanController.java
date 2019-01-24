package pl.grzex.grzexlibraryserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzex.grzexlibraryserver.models.Loan;
import pl.grzex.grzexlibraryserver.services.LoanService;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class LoanController {

    private LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping(value = "authors/{authorsId}/books/{bookId}/copys/{copyId}/loans/{loanId}")
    public List<Loan> getLoanById(@PathVariable Long loanId) {
        return Collections.singletonList(loanService.getLoanById(loanId));
    }

    @PostMapping(value = "authors/{authorsId}/books/{bookId}/copys/{copyId}/loans")
    public List<Loan> saveLoan(@PathVariable Long copyId) {
        return Collections.singletonList(loanService.saveLoan(copyId, Long.valueOf(1)));
    }

    @DeleteMapping(value = "authors/{authorsId}/books/{bookId}/copys/{copyId}/loans/{loanId}")
    public void deleteById(@PathVariable Long loanId) {
        loanService.deleteById(loanId);
    }
}
