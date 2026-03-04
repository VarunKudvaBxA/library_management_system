package com.accolite.library_management_system.service;
import com.accolite.library_management_system.model.Book;
import com.accolite.library_management_system.model.BorrowRecord;
import com.accolite.library_management_system.model.Member;
import com.accolite.library_management_system.repository.BookRepository;
import com.accolite.library_management_system.repository.BorrowRecordRepository;
import com.accolite.library_management_system.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
@Slf4j
public class BorrowService {
    private final BorrowRecordRepository borrowRepo;
    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;
    public String borrow(Long bookId, Long memberId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        if (!book.isAvailable()) {
            throw new RuntimeException("Book already borrowed");
        }
        Member member = memberRepo.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        book.setAvailable(false);
        BorrowRecord record = BorrowRecord.builder()
                .book(book)
                .member(member)
                .borrowTime(LocalDateTime.now())
                .build();
        borrowRepo.save(record);
        bookRepo.save(book);
        return "Book borrowed successfully";
    }
    public String returnBook(Long bookId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setAvailable(true);
        bookRepo.save(book);
        return "Book returned successfully";
    }
}