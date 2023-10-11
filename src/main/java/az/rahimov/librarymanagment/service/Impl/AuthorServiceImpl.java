package az.rahimov.librarymanagment.service.Impl;

import az.rahimov.librarymanagment.dto.AuthorDTO;
import az.rahimov.librarymanagment.exceptions.AuthorNotFound;
import az.rahimov.librarymanagment.model.Author;
import az.rahimov.librarymanagment.repository.AuthorRepository;
import az.rahimov.librarymanagment.service.AuthorService;
import az.rahimov.librarymanagment.util.mappers.AuthorMapper;
import az.rahimov.librarymanagment.util.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper=AuthorMapper.INSTANCE;

    private final BookMapper bookMapper= BookMapper.INSTANCE;


    @Override
    public List<Author> getAllAuthors() {
        List<Author> all = authorRepository.findAll();
       return all;
    }

    @Override
    public Author getAuthorById(Integer id) {
        Optional<Author> authOpt = authorRepository.findById(id);
        if (authOpt.isPresent()){
            return authOpt.get();
        }else throw new AuthorNotFound();
    }

    @Override
    public String saveAuthor(Author author) {
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
    public String updateAuthor(Author author,Integer id) {
Optional<Author>authOpt=authorRepository.findById(id);
if (authOpt.isPresent()){
    Author author1=authOpt.get();
    author1.setFirstName(author.getFirstName());
    author1.setLastName(author.getLastName());
    authorRepository.save(author);
    return "Updated successfully";
}else throw new AuthorNotFound();
    }
}
