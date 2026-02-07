package com.example.listitemtracker;

import com.example.listitemtracker.LostItem;
import com.example.listitemtracker.LostItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LostItemService {

    private final LostItemRepository repository;

    public LostItemService(LostItemRepository repository) {
        this.repository = repository;
    }

    public LostItem addItem(LostItem item) {
        item.setStatus("FOUND");
        item.setFoundDate(LocalDate.now());
        return repository.save(item);
    }

    public List<LostItem> getAllItems() {
        return repository.findAll();
    }

    public LostItem claimItem(Long id) {
        LostItem item = repository.findById(id).orElseThrow();
        item.setStatus("CLAIMED");
        return repository.save(item);
    }
}
