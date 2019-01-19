package pl.grzex.grzexlibraryserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzex.grzexlibraryserver.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByFullName(String fullName);
}
