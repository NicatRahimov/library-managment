package az.rahimov.librarymanagment.service;

import az.rahimov.librarymanagment.dto.BookDTO;
import az.rahimov.librarymanagment.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Integer id);
    String saveBook(Book book);
    String deleteBookById(Integer id);
    String updateBook(Book book,Integer id);

    void removeAuthorFromBook(Integer id);

}
