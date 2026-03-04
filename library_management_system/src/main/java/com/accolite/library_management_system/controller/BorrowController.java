package com.accolite.library_management_system.controller;
import com.accolite.library_management_system.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/borrow")
@RequiredArgsConstructor
public class BorrowController {
    private final BorrowService service;
    @PostMapping("/borrow")
    public ResponseEntity<String> borrow(@RequestParam Long bookId,
                                         @RequestParam Long memberId) {
        return ResponseEntity.ok(service.borrow(bookId, memberId));
    }

    @PostMapping("/return")
    public ResponseEntity<String> returnBook(@RequestParam Long bookId) {
        return ResponseEntity.ok(service.returnBook(bookId));
    }
}