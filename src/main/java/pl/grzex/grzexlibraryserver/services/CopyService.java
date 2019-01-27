package pl.grzex.grzexlibraryserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.grzex.grzexlibraryserver.dao.BookRepository;
import pl.grzex.grzexlibraryserver.dao.CopyRepository;
import pl.grzex.grzexlibraryserver.models.Copy;

import java.util.Set;

@Service
public class CopyService {

    private BookRepository bookRepository;
    private CopyRepository copyRepository;

    @Autowired
    public CopyService(BookRepository bookRepository, CopyRepository copyRepository) {
        this.bookRepository = bookRepository;
        this.copyRepository = copyRepository;
    }

    public Set<Copy> findCopysByBookId(Long bookId) {
        return bookRepository.findOne(bookId).getCopies();
    }

    public Copy findCopyById(Long copyId) {
        return copyRepository.findOne(copyId);
    }

    @Transactional
    public Copy saveCopy(Long bookId) {
        Copy copy = new Copy();
        copy.setLoan(false);
        copy.setExist(true);
        copy.setBook(bookRepository.findOne(bookId));
        return copyRepository.save(copy);
    }

    public void deleteById(Long copyId) {
        copyRepository.delete(copyId);
    }
}
