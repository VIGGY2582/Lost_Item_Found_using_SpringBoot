package com.example.listitemtracker;

import com.example.listitemtracker.LostItem;
import com.example.listitemtracker.LostItemService;
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
    public LostItem addItem(@RequestBody LostItem item) {
        return service.addItem(item);
    }

    @GetMapping
    public List<LostItem> getAllItems() {
        return service.getAllItems();
    }

    @PutMapping("/claim/{id}")
    public LostItem claimItem(@PathVariable Long id) {
        return service.claimItem(id);
    }
}
