package com.example.listitemtracker;

import com.example.listitemtracker.LostItemTracker;
import com.example.listitemtracker.LostItemRepository;
import com.example.listitemtracker.LostItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items/ui")
public class ItemUiController {

    private final LostItemService service;

    public ItemUiController(LostItemService service) {
        this.service = service;
    }

    @GetMapping
    public String viewItems(Model model) {
        model.addAttribute("items", service.getAllItems());
        return "items";
    }

    @PostMapping("/add")
    public String addItem(LostItemTracker item) {
        service.addItem(item);
        return "redirect:/items/ui";
    }

    @PostMapping("/claim/{id}")
    public String claimItem(@PathVariable Long id) {
        service.claimItem(id);
        return "redirect:/items/ui";
    }
}
