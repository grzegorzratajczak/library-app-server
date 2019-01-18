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
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @OneToMany(mappedBy = "author")
    private Set<Book> books = new HashSet<>();

    public Author(String fullName) {
        this.fullName = fullName;
    }
}
