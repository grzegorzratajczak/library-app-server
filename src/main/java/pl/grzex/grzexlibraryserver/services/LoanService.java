package pl.grzex.grzexlibraryserver.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.grzex.grzexlibraryserver.dao.*;
import pl.grzex.grzexlibraryserver.dto.LoanDto;
import pl.grzex.grzexlibraryserver.models.Loan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<LoanDto> getAllLoan() {
        List<Loan> loanList = loanRepository.findAll();
        List<LoanDto> loanDtoList = new ArrayList<>();
        for (int i = 0; i < loanList.size(); i++) {
            loanDtoList.add(new LoanDto(
                    loanList.get(i).getId(),
                    loanList.get(i).getCopy().getId(),
                    loanList.get(i).getReader().getId(),
                    loanList.get(i).getCopy().getBook().getBookName(),
                    loanList.get(i).getFromDate().toString(),
                    loanList.get(i).getToDate().toString()));
        }
        return loanDtoList;
    }

    public LoanDto getLoanById(Long loanId) {
        Loan loan = loanRepository.getOne(loanId);
        return new LoanDto(
                loan.getId(),
                loan.getCopy().getId(),
                loan.getReader().getId(),
                loan.getCopy().getBook().getBookName(),
                loan.getFromDate().toString(),
                loan.getToDate().toString()
        );
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
