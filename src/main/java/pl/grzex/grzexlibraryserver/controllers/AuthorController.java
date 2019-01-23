package pl.grzex.grzexlibraryserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzex.grzexlibraryserver.models.Author;
import pl.grzex.grzexlibraryserver.services.AuthorService;
import pl.grzex.grzexlibraryserver.services.BookService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RestController
public class AuthorController {

    private AuthorService authorService;
    private BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping(value = "/authors")
    public List<Author> getAuthors() {
        return authorService.findAllAuthors();
    }

    @PostMapping(value = "/authors", consumes = APPLICATION_JSON_VALUE)
    public void saveAuthorToDB(@RequestBody Author author) {
        authorService.saveAuthor(author);
    }

//    @GetMapping(value = "/authors/{authorsId}")
//    public AuthorDto getAuthorById(@PathVariable Long authorsId) {

//        AuthorDto authorDto = new AuthorDto(authorService.findAuthorById(authorsId).getFullName(), bookDtos);
//        return authorDto;
//    }

    @GetMapping(value = "/authors/findbyname/{fullName}")
    public Author getAuthorByFullName(@PathVariable String fullName) {
        return authorService.findAuthorByFullName(fullName);
    }

    @DeleteMapping(value = "/authors/{authorsId}")
    public void deleteAuthorById(@PathVariable Long authorsId) {
        authorService.deleteById(authorsId);
    }
}
