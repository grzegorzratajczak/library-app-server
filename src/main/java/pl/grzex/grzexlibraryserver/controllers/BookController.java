package pl.grzex.grzexlibraryserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzex.grzexlibraryserver.models.Book;
import pl.grzex.grzexlibraryserver.services.BookService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/all")
    public List<Book> getBooks(){
        return bookService.findAllBooks();
    }

    @PostMapping(value = "/create")
    public void saveBookToDB(@RequestBody Book book){
        bookService.saveBook(book);
    }

    @GetMapping(value = "/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookService.deleteById(id);
    }
}
