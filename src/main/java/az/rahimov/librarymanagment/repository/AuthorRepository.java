package az.rahimov.librarymanagment.repository;

import az.rahimov.librarymanagment.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
