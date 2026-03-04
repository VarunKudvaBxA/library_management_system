package com.accolite.library_management_system.controller;
import com.accolite.library_management_system.dto.BookDTO;
import com.accolite.library_management_system.model.Book;
import com.accolite.library_management_system.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;
    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody BookDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Book deleted");
    }
}