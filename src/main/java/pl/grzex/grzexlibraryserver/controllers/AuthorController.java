package pl.grzex.grzexlibraryserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzex.grzexlibraryserver.dto.AuthorDto;
import pl.grzex.grzexlibraryserver.models.Author;
import pl.grzex.grzexlibraryserver.services.AuthorService;

import java.util.Collections;
import java.util.List;

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

    @PostMapping(value = "/authors/")
    public List<Author> saveAuthorToDB(@RequestBody AuthorDto authorDto) {
        return Collections.singletonList(authorService.saveAuthor(authorDto));
    }

    @GetMapping(value = "/authors/{authorsId}")
    public List<Author> getAuthorById(@PathVariable Long authorsId) {
        return Collections.singletonList(authorService.findAuthorById(authorsId));
    }

    @GetMapping(value = "/authorsByAuthorName/{authorName}")
    public List<Author> getAuthorByFullName(@PathVariable String authorName) {
        return Collections.singletonList(authorService.findAuthorByAuthorName(authorName));
    }

    @DeleteMapping(value = "/authors/{authorsId}")
    public void deleteAuthorById(@PathVariable Long authorsId) {
        authorService.deleteById(authorsId);
    }
}
