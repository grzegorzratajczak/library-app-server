package pl.grzex.grzexlibraryserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.grzex.grzexlibraryserver.dao.AuthorRepository;
import pl.grzex.grzexlibraryserver.dao.BookRepository;
import pl.grzex.grzexlibraryserver.dto.BookDto;
import pl.grzex.grzexlibraryserver.models.Book;

import java.util.ArrayList;
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
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(book -> books.add(book));
        return books;
    }

    public Set<Book> findBooksByAuthor(Long authorsId) {
        return authorRepository.findOne(authorsId).getBooks();
    }

    public Book findBookById(Long id) {
        Book book = bookRepository.findOne(id);
        return book;
    }

    @Transactional
    public Book saveBook(BookDto bookDto, Long authorsId) {
        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        book.setAuthor(authorRepository.findOne(authorsId));
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.delete(id);
    }

}
