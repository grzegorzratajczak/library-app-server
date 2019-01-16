package pl.grzex.grzexlibraryserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzex.grzexlibraryserver.models.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
