package az.rahimov.librarymanagment.service;

import az.rahimov.librarymanagment.dto.AuthorDTO;
import az.rahimov.librarymanagment.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(Integer id);

    String saveAuthor(Author author);

    String deleteAuthor(Integer id);

    String updateAuthor(Author author,Integer id);

}
