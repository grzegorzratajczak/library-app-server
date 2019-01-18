package pl.grzex.grzexlibraryserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzex.grzexlibraryserver.dao.BookRepository;
import pl.grzex.grzexlibraryserver.models.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(book -> books.add(book));
        return books;
    }

    public Book findBookById(Long id){

        Book book = bookRepository.findOne(id);
        return book;
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }

    public void deleteById(Long id){
        bookRepository.delete(id);
    }

    public void deleteAll(){
        bookRepository.deleteAll();
    }
}
