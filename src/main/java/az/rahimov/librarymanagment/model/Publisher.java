package az.rahimov.librarymanagment.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "publisher")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @ManyToMany(mappedBy = "publishers",fetch = FetchType.LAZY)
    List<Book> books;
}
