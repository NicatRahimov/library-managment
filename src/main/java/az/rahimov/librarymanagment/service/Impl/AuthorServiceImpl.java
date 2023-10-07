package az.rahimov.librarymanagment.service.Impl;

import az.rahimov.librarymanagment.dto.AuthorDTO;
import az.rahimov.librarymanagment.exceptions.AuthorNotFound;
import az.rahimov.librarymanagment.model.Author;
import az.rahimov.librarymanagment.repository.AuthorRepository;
import az.rahimov.librarymanagment.service.AuthorService;
import az.rahimov.librarymanagment.util.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper=AuthorMapper.INSTANCE;


    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<Author> all = authorRepository.findAll();
       return authorMapper.toDtoList(all);
    }

    @Override
    public AuthorDTO getAuthorById(Integer id) {
        Optional<Author> authOpt = authorRepository.findById(id);
        if (authOpt.isPresent()){
            return authorMapper.toDto(authOpt.get());
        }else throw new AuthorNotFound();
    }

    @Override
    public String saveAuthor(AuthorDTO authorDTO) {
   Author author = Author.builder()
           .firstName(authorDTO.getFirstName())
           .lastName(authorDTO.getLastName())
           .books(authorDTO.getBooks())
           .build();
   authorRepository.save(author);
   return "Saved successfully";
    }

    @Override
    public String deleteAuthor(Integer id) {
        Optional<Author> authOpt = authorRepository.findById(id);
        if (authOpt.isPresent()){
            authorRepository.delete(authOpt.get());
            return "Deleted successfully";
        }else throw new AuthorNotFound();
    }

    @Override
    public String updateAuthor(AuthorDTO authorDTO,Integer id) {

    }
}
