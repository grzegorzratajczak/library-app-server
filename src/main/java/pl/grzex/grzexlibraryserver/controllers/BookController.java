package pl.grzex.grzexlibraryserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzex.grzexlibraryserver.dto.BookDto;
import pl.grzex.grzexlibraryserver.models.Book;
import pl.grzex.grzexlibraryserver.services.AuthorService;
import pl.grzex.grzexlibraryserver.services.BookService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class BookController {

    private BookService bookService;
    private AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping(value = "/books")
    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping(value = "/books/{bookId}")
    public List<Book> getBookById(@PathVariable Long bookId) {
        return Collections.singletonList(bookService.findBookById(bookId));
    }

    @GetMapping(value = "/authors/{authorsId}/books")
    public List<Book> getBooksByAuthor(@PathVariable Long authorsId) {
        List<Book> bookList = new ArrayList<>(bookService.findBooksByAuthor(authorsId));
        return bookList;
    }

    @PostMapping(value = "/authors/{authorsId}/books")
    public List<Book> saveBookToDB(@RequestBody BookDto bookDto, @PathVariable Long authorsId) {
        return Collections.singletonList(bookService.saveBook(bookDto, authorsId));
    }

    @GetMapping(value = "/authors/{authorsId}/books/{bookId}")
    public List<Book> getBook(@PathVariable Long authorsId, @PathVariable Long bookId) {
        return Collections.singletonList(bookService.findBookByAuthorAndId(authorService.findAuthorById(authorsId), bookId));
    }

    @DeleteMapping(value = "/authors/{authorsId}/books/{bookId}")
    public void deleteBookById(@PathVariable Long bookId) {
        bookService.deleteById(bookId);
    }
}
