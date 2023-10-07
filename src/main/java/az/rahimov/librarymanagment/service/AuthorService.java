package az.rahimov.librarymanagment.service;

import az.rahimov.librarymanagment.dto.AuthorDTO;
import az.rahimov.librarymanagment.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    List<AuthorDTO> getAllAuthors();

    AuthorDTO getAuthorById(Integer id);

    String saveAuthor(AuthorDTO authorDTO);

    String deleteAuthor(Integer id);

    String updateAuthor(AuthorDTO authorDTO,Integer id);

}
