package pl.grzex.grzexlibraryserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzex.grzexlibraryserver.models.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
