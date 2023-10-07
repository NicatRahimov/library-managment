package az.rahimov.librarymanagment.controller;

import az.rahimov.librarymanagment.dto.BookDTO;
import az.rahimov.librarymanagment.service.BookService;
import az.rahimov.librarymanagment.service.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("books")
    public List<BookDTO> getAllBooks(){
       return bookService.getAllBooks();
    }
}
