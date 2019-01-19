package pl.grzex.grzexlibraryserver.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    @JsonManagedReference
    @OneToMany(mappedBy = "author")
    private Set<Book> books = new HashSet<>();

    public Author(String fullName) {
        this.fullName = fullName;
    }


}
