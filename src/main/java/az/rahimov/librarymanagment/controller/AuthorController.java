package az.rahimov.librarymanagment.controller;

import az.rahimov.librarymanagment.model.Author;
import az.rahimov.librarymanagment.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("library/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping()
    public String getAllAuthors(Model model){
        List<Author>authors=authorService.getAllAuthors();
        model.addAttribute("authors",authors);
        return "authors";
    }
    @GetMapping("/add")
    public String addAuthor(Model model){
        Author author = new Author();
        model.addAttribute("author",author);
        return "add-author";
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("author") Author author){
        authorService.saveAuthor(author);
        return "redirect:/library/books/addBook";
    }
}
