package kz.bitlab.firstProject.controller;

import kz.bitlab.firstProject.model.Items;
import kz.bitlab.firstProject.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private NotebookService NotebookService;

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("list", NotebookService.getItems());
        return "main";
    }

    @PostMapping(value = "/add-item")
    public String addItem(Items item) {
        NotebookService.addItem(item);
        return "redirect:/";
    }

    @GetMapping(value = "add-item")
    public String addItemPage() {
        return "add-item";
    }

    @GetMapping(value = "item-details/{id}")
    public String itemDetails(@PathVariable int id, Model model) {
        model.addAttribute("item", NotebookService.getItemById(id));
        return "item-details";
    }

    @PostMapping(value = "update-item")
    public String updateItem(Items item) {
        NotebookService.updateItem(item);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-item")
    public String deleteItem(long id) {
        NotebookService.deleteItem(id);
        return "redirect:/";
    }
}
