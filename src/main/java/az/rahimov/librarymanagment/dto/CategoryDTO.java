package az.rahimov.librarymanagment.dto;

import az.rahimov.librarymanagment.model.Book;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDTO {
    Integer id;
    String name;
    List<Book>books;
}
