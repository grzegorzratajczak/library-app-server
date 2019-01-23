package pl.grzex.grzexlibraryserver.services;

import org.springframework.stereotype.Service;
import pl.grzex.grzexlibraryserver.dao.*;

@Service
public class LoanService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private CopyRepository copyRepository;
    private LoanRepository loanRepository;
    private ReaderRepository readerRepository;

    public LoanService(AuthorRepository authorRepository, BookRepository bookRepository, CopyRepository copyRepository, LoanRepository loanRepository, ReaderRepository readerRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.copyRepository = copyRepository;
        this.loanRepository = loanRepository;
        this.readerRepository = readerRepository;
    }
}
