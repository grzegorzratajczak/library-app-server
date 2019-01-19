package pl.grzex.grzexlibraryserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzex.grzexlibraryserver.models.Author;
import pl.grzex.grzexlibraryserver.services.AuthorService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/all")
    public List<Author> getAuthors() {
        return authorService.findAllAuthors();
    }


    @PostMapping(value = "/create", consumes = APPLICATION_JSON_VALUE)
    public void saveAuthorToDB(@RequestBody Author author){
        authorService.saveAuthor(author);
    }

    @GetMapping(value = "/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.findAuthorById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAuthorById(@PathVariable Long id){
        authorService.deleteById(id);
    }
}
