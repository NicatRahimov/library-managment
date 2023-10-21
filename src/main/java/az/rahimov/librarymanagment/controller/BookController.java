package az.rahimov.librarymanagment.controller;

import az.rahimov.librarymanagment.model.Author;
import az.rahimov.librarymanagment.model.Book;
import az.rahimov.librarymanagment.service.AuthorService;
import az.rahimov.librarymanagment.service.BookService;
import az.rahimov.librarymanagment.service.CategoryService;
import az.rahimov.librarymanagment.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("library/books")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AuthorService authorService;
    @Autowired
    PublisherService publisherService;
    @GetMapping()
    public String booksPage(Model model ){
        List<Book>books=bookService.getAllBooks();
        model.addAttribute("books",books);
        return "books";
    }

    @GetMapping("/{id}")
    public String getBookById(Model model, @PathVariable Integer id){
        Book bookById = bookService.getBookById(id);
        model.addAttribute("book",bookById);
        return "book-by-id";
    }
    @GetMapping("/delete/{id}")
    public String deleteBookById(@PathVariable Integer id){
        bookService.deleteBookById(id);
        return "redirect:/library/books";
    }

    @GetMapping("/addBook")
    public String addBook(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("publishers",publisherService.getAllPublisher());
        model.addAttribute("authors",authorService.getAllAuthors());
        model.addAttribute("book",new Book());
        return "add-book";
    }
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book){
            bookService.saveBook(book);
            return "redirect:/library/books";
    }


    @GetMapping("/edit/{id}")
    public String editBookDetails(
            @PathVariable Integer id,
            Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "edit-book";
    }

    @PostMapping("/edit/{id}")
    public String applyEditedData(@ModelAttribute("book")Book book,
                                  @PathVariable Integer id){
bookService.updateBook(book,id);
        return "redirect:/library/books";
    }


    @PostMapping("/removeAuthor")
    public String removeCategoryFromBook(@RequestParam Integer bookId, @RequestParam Integer authorId) {
        // Retrieve the book and category from the database
        Book book = bookService.getBookById(bookId);
        Author author = authorService.getAuthorById(authorId);

        // Remove the category from the book
        book.getAuthors().remove(author);
        // Save the updated book
        bookService.saveBook(book);
        return "redirect:/library/books"; // Redirect to the books page
    }
}
