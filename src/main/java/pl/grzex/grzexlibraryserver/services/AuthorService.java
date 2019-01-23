package pl.grzex.grzexlibraryserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzex.grzexlibraryserver.dao.AuthorRepository;
import pl.grzex.grzexlibraryserver.dto.AuthorDto;
import pl.grzex.grzexlibraryserver.models.Author;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(author -> authors.add(author));
        return authors;
    }

    public Author findAuthorById(Long id) {
        return authorRepository.findOne(id);
    }

    public Author findAuthorByAuthorName(String authorName) {
        return authorRepository.findByAuthorName(authorName);
    }

    public Author saveAuthor(AuthorDto authorDto) {
        if (authorRepository.findByAuthorName(authorDto.getAuthorName()) == null) {
            Author author = new Author();
            author.setAuthorName(authorDto.getAuthorName());
            return authorRepository.save(author);
        }
        return authorRepository.findByAuthorName(authorDto.getAuthorName());
    }


    public void deleteById(Long id) {
        authorRepository.delete(id);
    }

}
