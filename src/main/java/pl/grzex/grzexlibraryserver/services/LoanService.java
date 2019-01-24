package pl.grzex.grzexlibraryserver.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.grzex.grzexlibraryserver.dao.*;
import pl.grzex.grzexlibraryserver.models.Loan;

import java.time.LocalDate;

@Service
public class LoanService {

    private CopyRepository copyRepository;
    private LoanRepository loanRepository;
    private ReaderRepository readerRepository;

    public LoanService(CopyRepository copyRepository, LoanRepository loanRepository, ReaderRepository readerRepository) {
        this.copyRepository = copyRepository;
        this.loanRepository = loanRepository;
        this.readerRepository = readerRepository;
    }

    public Loan getLoanById(Long loanId) {
        return loanRepository.getOne(loanId);
    }

    @Transactional
    public Loan saveLoan(Long copyId, Long readerId) {
        Loan loan = new Loan();
        loan.setFromDate(LocalDate.now());
        loan.setToDate(LocalDate.now().plusWeeks(2));
        loan.setCopy(copyRepository.findOne(copyId));
        loan.setReader(readerRepository.findOne(readerId));
        return loanRepository.save(loan);
    }

    public void deleteById(Long loanId) {
        loanRepository.delete(loanId);
    }
}
