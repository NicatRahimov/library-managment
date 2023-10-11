package az.rahimov.librarymanagment.service.Impl;

import az.rahimov.librarymanagment.exceptions.PublisherNotFound;
import az.rahimov.librarymanagment.model.Publisher;
import az.rahimov.librarymanagment.repository.PublisherRepository;
import az.rahimov.librarymanagment.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository repository;
    @Override
    public List<Publisher> getAllPublisher() {
        return repository.findAll();
    }

    @Override
    public Publisher getPublisherById(Integer id) {
        Optional<Publisher> opt = repository.findById(id);
        if (opt.isPresent()){
          return opt.get();
        }else throw new PublisherNotFound();
    }

    @Override
    public String savePublisher(Publisher publisher) {
       repository.save(publisher);
       return "Saved successfully";
    }

    @Override
    public String deletePublisher(Integer id) {
        repository.deleteById(id);
        return "deleted successfully";
    }

    @Override
    public String updatePublisher(Publisher publisher, Integer id) {
        Optional<Publisher> optionalPublisher = repository.findById(id);

        if (optionalPublisher.isPresent()){
            Publisher publisher1 = optionalPublisher.get();
            publisher1.setName(publisher.getName());
            return "updated";
        }else throw new PublisherNotFound();
    }
}
