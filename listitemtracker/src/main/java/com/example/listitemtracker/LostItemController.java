package com.example.listitemtracker;

import com.example.listitemtracker.LostItemService;
import com.example.listitemtracker.LostItemTracker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class LostItemController {

    private final LostItemService service;

    public LostItemController(LostItemService service) {
        this.service = service;
    }

    @PostMapping
    public LostItemTracker addItem(@RequestBody LostItemTracker item) {
        return service.addItem(item);
    }

    @GetMapping
    public List<LostItemTracker> getAllItems() {
        return service.getAllItems();
    }

    @PostMapping("/claim/{id}")
    public LostItemTracker claimItem(@PathVariable Long id) {
        return service.claimItem(id);
    }
}
