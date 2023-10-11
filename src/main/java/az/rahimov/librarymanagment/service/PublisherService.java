package az.rahimov.librarymanagment.service;

import az.rahimov.librarymanagment.model.Category;
import az.rahimov.librarymanagment.model.Publisher;
import az.rahimov.librarymanagment.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublisherService {
    List<Publisher> getAllPublisher();

    Publisher getPublisherById(Integer id);

    String savePublisher(Publisher publisher);

    String deletePublisher(Integer id);

    String updatePublisher(Publisher publisher,Integer id);
}
