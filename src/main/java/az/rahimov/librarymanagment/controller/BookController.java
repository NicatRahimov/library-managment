package az.rahimov.librarymanagment.controller;

import az.rahimov.librarymanagment.model.Book;
import az.rahimov.librarymanagment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public String homePage(){
        return "home";
    }
}
