package pl.grzex.grzexlibraryserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzex.grzexlibraryserver.models.Author;
import pl.grzex.grzexlibraryserver.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByAuthorAndId(Author author, Long bookId);
}
