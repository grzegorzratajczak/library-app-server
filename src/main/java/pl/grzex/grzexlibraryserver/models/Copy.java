package pl.grzex.grzexlibraryserver.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Book book;
    @OneToMany(mappedBy = "copy")
    private Set<Loan> loans = new HashSet<>();
    private boolean isExist;
    private boolean isLoan;
}
