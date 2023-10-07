package az.rahimov.librarymanagment.dto;

import az.rahimov.librarymanagment.model.Book;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    String firstName;
    String lastName;
    List<Book>books;
}
