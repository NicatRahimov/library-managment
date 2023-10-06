package az.rahimov.librarymanagment.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            Integer id;
    String firstName;
    String lastName;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    List<Book> books;
}
