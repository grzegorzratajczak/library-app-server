package pl.grzex.grzexlibraryserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzex.grzexlibraryserver.models.Copy;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Long> {
}
