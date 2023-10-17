package az.rahimov.librarymanagment.controller;

import az.rahimov.librarymanagment.model.Publisher;
import az.rahimov.librarymanagment.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("library/publishers")
@RequiredArgsConstructor
public class PublisherController {

private final PublisherService publisherService;
    @GetMapping
    public String getAllPublishers(Model model){
        List<Publisher> allPublisher = publisherService.getAllPublisher();
        model.addAttribute("publishers",allPublisher);
        return "publishers";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable("id") Integer id,Model model){
        try {
            publisherService.deletePublisher(id);
            return "redirect:/library/publishers";
        } catch (Exception e) {
            model.addAttribute("errorMessage",e.getMessage());
            return "delete-error";
        }
    }

    @GetMapping("/add")
    public String addPublisher(Model model){
Publisher publisher = new Publisher();
model.addAttribute("publisher",publisher);
return "add-publisher";
    }
    @PostMapping("/save")
    public String savePublisher(@ModelAttribute Publisher publisher){
        publisherService.savePublisher(publisher);
        return "redirect:/library/publishers";
    }
}
