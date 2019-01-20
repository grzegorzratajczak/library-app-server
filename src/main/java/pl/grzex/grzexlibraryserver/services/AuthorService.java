package pl.grzex.grzexlibraryserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzex.grzexlibraryserver.dao.AuthorRepository;
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

    public Author findAuthorByFullName(String fullName){
        return authorRepository.findByFullName(fullName);
    }

    public void saveAuthor(Author author) {
        if (authorRepository.findByFullName(author.getFullName()) == null)
            authorRepository.save(author);
    }

    public void deleteById(Long id) {
        authorRepository.delete(id);
    }

}
