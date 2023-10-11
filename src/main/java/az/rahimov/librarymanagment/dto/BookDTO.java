package az.rahimov.librarymanagment.dto;

import az.rahimov.librarymanagment.model.Author;
import az.rahimov.librarymanagment.model.Category;
import az.rahimov.librarymanagment.model.Publisher;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDTO {
    Integer id;
    String name;
    String isbn;
    String description;
    List<AuthorDTO>authors;
    List<PublisherDTO>publishers;
    List<CategoryDTO>categories;
}
