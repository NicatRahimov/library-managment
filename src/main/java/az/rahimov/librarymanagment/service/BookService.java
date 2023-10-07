package az.rahimov.librarymanagment.service;

import az.rahimov.librarymanagment.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Integer id);
    String saveBook(BookDTO bookDTO);
    String deleteBookById(Integer id);
    String updateBook(BookDTO bookDTO,Integer id);

}
