package com.example.listitemtracker;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LostItemService {

    private final LostItemRepository repository;

    public LostItemService(LostItemRepository repository) {
        this.repository = repository;
    }

    public LostItemTracker addItem(LostItemTracker item) {
        item.setStatus("FOUND");
        item.setFoundDate(LocalDate.now());
        return repository.save(item);
    }

    public List<LostItemTracker> getAllItems() {
        return repository.findAll();
    }

    public LostItemTracker claimItem(Long id) {
        LostItemTracker item = repository.findById(id).orElseThrow();
        item.setStatus("CLAIMED");
        return repository.save(item);
    }
}
