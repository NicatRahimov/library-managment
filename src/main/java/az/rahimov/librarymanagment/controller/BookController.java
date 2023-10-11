package az.rahimov.librarymanagment.controller;

import az.rahimov.librarymanagment.dto.CategoryDTO;
import az.rahimov.librarymanagment.model.Author;
import az.rahimov.librarymanagment.model.Book;
import az.rahimov.librarymanagment.model.Category;
import az.rahimov.librarymanagment.service.AuthorService;
import az.rahimov.librarymanagment.service.BookService;
import az.rahimov.librarymanagment.service.CategoryService;
import az.rahimov.librarymanagment.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Binding;
import java.io.File;
import java.util.List;


@Controller
@RequestMapping("library")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AuthorService authorService;
    @Autowired
    PublisherService publisherService;
    @GetMapping("/home")
    public String homePage(){
        return "home";
    }
    @GetMapping("/books")
    public String booksPage(Model model ){
        List<Book>books=bookService.getAllBooks();
        model.addAttribute("books",books);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String getBookById(Model model, @PathVariable Integer id){
        Book bookById = bookService.getBookById(id);
        model.addAttribute("book",bookById);
        return "book-by-id";
    }
    @GetMapping("/books/delete/{id}")
    public String deleteBookById(@PathVariable Integer id){
        bookService.deleteBookById(id);
        return "redirect:/library/books";
    }

    @GetMapping("/books/addBook")
    public String addBook(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("publishers",publisherService.getAllPublisher());
        model.addAttribute("authors",authorService.getAllAuthors());
        model.addAttribute("book",new Book());
        return "add-book";
    }
    @PostMapping("/books/save")
    public String saveBook(Model model,@ModelAttribute("book") Book book){

            bookService.saveBook(book);
            model.addAttribute("books",bookService.getAllBooks());
            return "redirect:/library/books";

    }
}
