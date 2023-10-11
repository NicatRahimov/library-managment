package az.rahimov.librarymanagment;

import az.rahimov.librarymanagment.model.Author;
import az.rahimov.librarymanagment.model.Book;
import az.rahimov.librarymanagment.model.Category;
import az.rahimov.librarymanagment.model.Publisher;
import az.rahimov.librarymanagment.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
public class LibraryManagmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagmentApplication.class, args);
    }

}
