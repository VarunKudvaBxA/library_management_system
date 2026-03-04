package com.accolite.library_management_system.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class BookDTO {
    @NotBlank
    private String bookName;
    @NotBlank
    private String genre;
    @NotBlank
    private String author;
}