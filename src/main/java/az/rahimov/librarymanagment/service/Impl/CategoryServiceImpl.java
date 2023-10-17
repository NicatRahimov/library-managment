package az.rahimov.librarymanagment.service.Impl;

import az.rahimov.librarymanagment.dto.CategoryDTO;
import az.rahimov.librarymanagment.exceptions.CategoryNotFound;
import az.rahimov.librarymanagment.model.Category;
import az.rahimov.librarymanagment.repository.CategoryRepository;
import az.rahimov.librarymanagment.service.CategoryService;
import az.rahimov.librarymanagment.util.mappers.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
    @Override
    public List<Category> getAllCategory() {
    return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        Optional<Category>categoryOpt=categoryRepository.findById(id);
        if (categoryOpt.isPresent()){
            return categoryOpt.get();
        }else throw new CategoryNotFound();
    }

    @Override
    public String saveCategory(Category category) {
        categoryRepository.save(category);
        return "Saved successfully";
    }

    @Override
    public String deleteCategory(Integer id) {
        return null;
    }

    @Override
    public String updateCategory(Category category, Integer id) {
        Category category1 = categoryRepository.findById(id).get();
        category1.setName(category.getName());
        return "Updated successfully";
    }
}
