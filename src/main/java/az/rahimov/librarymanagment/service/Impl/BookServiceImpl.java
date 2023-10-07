package az.rahimov.librarymanagment.service.Impl;

import az.rahimov.librarymanagment.dto.BookDTO;
import az.rahimov.librarymanagment.model.Book;
import az.rahimov.librarymanagment.repository.BookRepository;
import az.rahimov.librarymanagment.service.BookService;
import az.rahimov.librarymanagment.exceptions.UserNotFound;
import az.rahimov.librarymanagment.util.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
private final BookMapper bookMapper = BookMapper.INSTANCE;

private final BookRepository bookRepository;


    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toDtoList(books);
    }

    @Override
    public BookDTO getBookById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        BookDTO bookDto;
       if (book.isPresent()){
           bookDto = bookMapper.toDto(book.get());
       }else {
           throw new UserNotFound("NO user found with ID: "+id);
       }
       return bookDto;
    }

    @Override
    public String saveBook(BookDTO bookDTO) {
        bookRepository.save(bookMapper.toEntity(bookDTO));
        return "Saved successfully";
    }

    @Override
    public String deleteBookById(Integer id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent()){
            bookRepository.delete(bookOpt.get());
            return "Successfully deleted";
  }else throw new UserNotFound("No user found with id: "+id);
    }

    @Override
    public String updateBook(BookDTO bookDTO,Integer id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent()){
            Book book = bookOpt.get();
            book.setName(bookDTO.getName());
            book.setIsbn(bookDTO.getIsbn());
            book.setDescription(bookDTO.getDescription());
            book.setAuthors(bookDTO.getAuthors());
            book.setPublishers(bookDTO.getPublishers());
            book.setCategories(bookDTO.getCategories());
            bookRepository.save(book);
            return "Updated successfully";
        }else throw new UserNotFound("There is no user for update request");
    }
}
