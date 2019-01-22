package pl.grzex.grzexlibraryserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzex.grzexlibraryserver.models.Book;
import pl.grzex.grzexlibraryserver.services.AuthorService;
import pl.grzex.grzexlibraryserver.services.BookService;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
public class BookController {

    private BookService bookService;
    private AuthorService authorService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping(value = "/books")
    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping(value = "/authors/{authorsId}/books")
    public Set<Book> getBooksByAuthor(@PathVariable Long authorsId) {
        return bookService.findBooksByAuthor(authorsId);
    }

    @PostMapping(value = "/authors/{authorsId}/books")
    public void saveBookToDB(@RequestBody Book book, @PathVariable Long authorsId) {
        bookService.saveBook(book, authorService.findAuthorById(authorsId));
    }

    @GetMapping(value = "/authors/{authorsId}/books/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookService.findBookById(bookId);
    }

    @DeleteMapping(value = "/authors/{authorsId}/books/{bookId}")
    public void deleteBookById(@PathVariable Long bookId) {
        bookService.deleteById(bookId);
    }
}
