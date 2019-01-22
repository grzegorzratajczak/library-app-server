package pl.grzex.grzexlibraryserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzex.grzexlibraryserver.models.Author;
import pl.grzex.grzexlibraryserver.services.AuthorService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RestController
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/authors")
    public List<Author> getAuthors() {
        return authorService.findAllAuthors();
    }

    @PostMapping(value = "/authors", consumes = APPLICATION_JSON_VALUE)
    public void saveAuthorToDB(@RequestBody Author author) {
        authorService.saveAuthor(author);
    }

    @GetMapping(value = "/authors/{authorsId}")
    public Author getAuthorById(@PathVariable Long authorsId) {
        return authorService.findAuthorById(authorsId);
    }

    @GetMapping(value = "/authors/findbyname/{fullName}")
    public Author getAuthorByFullName(@PathVariable String fullName) {
        return authorService.findAuthorByFullName(fullName);
    }

    @DeleteMapping(value = "/authors/{authorsId}")
    public void deleteAuthorById(@PathVariable Long authorsId) {
        authorService.deleteById(authorsId);
    }
}
