package az.rahimov.librarymanagment.service;

import az.rahimov.librarymanagment.model.Book;
import az.rahimov.librarymanagment.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public ResponseEntity<Book> findById(Integer id){
        return new ResponseEntity<>(bookRepository.findById(id).get(), HttpStatus.OK);
    }
}
