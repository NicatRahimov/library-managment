package az.rahimov.librarymanagment.controller;

import az.rahimov.librarymanagment.model.Category;
import az.rahimov.librarymanagment.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("library/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public String getAllCategories(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return "redirect:/library/categories";
    }
    @GetMapping("/add")
    public String addCategory(Model model){
        Category category = new Category();
        model.addAttribute("category",category);
        return "add-category";
    }
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category){
        categoryService.saveCategory(category);
        return "redirect:/library/categories";
    }
}
