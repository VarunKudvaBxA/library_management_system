package com.accolite.library_management_system.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class MemberDTO {
    @NotBlank
    private String name;
    @Email
    private String email;
}