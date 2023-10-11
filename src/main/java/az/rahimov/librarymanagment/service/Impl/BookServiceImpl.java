package az.rahimov.librarymanagment.service.Impl;

import az.rahimov.librarymanagment.dto.BookDTO;
import az.rahimov.librarymanagment.model.Book;
import az.rahimov.librarymanagment.repository.BookRepository;
import az.rahimov.librarymanagment.service.BookService;
import az.rahimov.librarymanagment.exceptions.BookNotFound;
import az.rahimov.librarymanagment.util.mappers.BookMapper;
import jakarta.transaction.Transactional;
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
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }
    @Override
    public Book getBookById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
       if (book.isPresent()){
           return book.get();
       }else {
           throw new BookNotFound("NO user found with ID: "+id);
       }
    }
    @Override
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "Saved successfully";
    }

    @Override
    public String deleteBookById(Integer id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent()){
            bookRepository.delete(bookOpt.get());
            return "Successfully deleted";
  }else throw new BookNotFound("No user found with id: "+id);
    }

    @Override
    public String updateBook(Book book, Integer id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent()){
           book = bookOpt.get();
            book.setName(book.getName());
            book.setIsbn(book.getIsbn());
            book.setDescription(book.getDescription());
            bookRepository.save(book);
            return "Updated successfully";
        }else throw new BookNotFound("No book with "+id+" id");
    }
}
