package pl.grzex.grzexlibraryserver.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Copy copy;
    @ManyToOne
    private Reader reader;
    private LocalDate fromDate;
    private LocalDate toDate;

}
