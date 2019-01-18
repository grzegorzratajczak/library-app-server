package pl.grzex.grzexlibraryserver.hardcoded.data;

import org.springframework.beans.factory.annotation.Autowired;
import pl.grzex.grzexlibraryserver.models.Author;
import pl.grzex.grzexlibraryserver.services.AuthorService;

public class AuthorHardData {

    private AuthorService authorService;

    @Autowired
    public AuthorHardData(AuthorService authorService) {
        this.authorService = authorService;
    }

    Author authorsTable[] = {
            new Author("Andrzej Sapkowski"),
            new Author("JRR Tolkien"),
            new Author("Adam Mickiewicz"),
            new Author("Bracia Grim"),
            new Author("Robert Cialdini"),
            new Author("Craig Walls"),
            new Author("Juliusz Słowacki"),
            new Author("Jan Paweł II"),
            new Author("Stephen King"),
            new Author("Agatha Christie")};

    public void saveAuthorsHardData() {
        for (int i = 0; i < authorsTable.length; i++) {
            authorService.saveAuthor(authorsTable[i]);
        }
    }
}
