package pl.grzex.grzexlibraryserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzex.grzexlibraryserver.dao.AuthorRepository;
import pl.grzex.grzexlibraryserver.dao.BookRepository;
import pl.grzex.grzexlibraryserver.dao.CopyRepository;

@Service
public class CopyService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private CopyRepository copyRepository;

    @Autowired
    public CopyService(AuthorRepository authorRepository, BookRepository bookRepository, CopyRepository copyRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.copyRepository = copyRepository;
    }
}
