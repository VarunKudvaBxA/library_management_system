package com.accolite.library_management_system.service;
import com.accolite.library_management_system.dto.BookDTO;
import com.accolite.library_management_system.model.Book;
import com.accolite.library_management_system.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    public Book create(BookDTO dto) {
        log.info("Creating book: {}", dto.getBookName());
        Book book = Book.builder()
                .bookName(dto.getBookName())
                .genre(dto.getGenre())
                .author(dto.getAuthor())
                .available(true)
                .build();
        return bookRepository.save(book);
    }
    public List<Book> getAll() {
        log.info("Fetching all books");
        return bookRepository.findAll();
    }
    public Book getById(Long id) {
        log.info("Fetching book with id: {}", id);
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
