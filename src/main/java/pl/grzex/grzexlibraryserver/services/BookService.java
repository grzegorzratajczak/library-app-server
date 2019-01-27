package pl.grzex.grzexlibraryserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.grzex.grzexlibraryserver.dao.AuthorRepository;
import pl.grzex.grzexlibraryserver.dao.BookRepository;
import pl.grzex.grzexlibraryserver.dto.BookDto;
import pl.grzex.grzexlibraryserver.models.Author;
import pl.grzex.grzexlibraryserver.models.Book;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Set<Book> findBooksByAuthor(Long authorsId) {
        return authorRepository.findOne(authorsId).getBooks();
    }

    public Book findBookById(Long id) {
        return bookRepository.findOne(id);
    }

    public Book findBookByAuthorAndId(Author author, Long bookId) {
        return bookRepository.findByAuthorAndId(author, bookId);
    }

    @Transactional
    public Book saveBook(BookDto bookDto, Long authorsId) {
        Book book = new Book(bookDto.getBookName(), authorRepository.findOne(authorsId), new HashSet<>());
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.delete(id);
    }

}
