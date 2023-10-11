package az.rahimov.librarymanagment.service;

import az.rahimov.librarymanagment.dto.CategoryDTO;
import az.rahimov.librarymanagment.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> getAllCategory();

    Category getCategoryById(Integer id);

    String saveCategory(Category category);

    String deleteCategory(Integer id);

    String updateCategory(Category category,Integer id);
}
