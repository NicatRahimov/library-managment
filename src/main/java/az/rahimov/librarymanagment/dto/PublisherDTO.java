package az.rahimov.librarymanagment.dto;

import az.rahimov.librarymanagment.model.Book;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PublisherDTO {
    Integer id;
    String name;
    List<Book>books;
}
