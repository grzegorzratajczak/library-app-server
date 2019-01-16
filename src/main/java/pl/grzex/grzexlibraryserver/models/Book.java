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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    @ManyToOne
    private Author author;
    @OneToMany(mappedBy = "book")
    private Set<Copy> copies = new HashSet<>();
}
