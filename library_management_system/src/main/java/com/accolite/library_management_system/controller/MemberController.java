package com.accolite.library_management_system.controller;
import com.accolite.library_management_system.dto.MemberDTO;
import com.accolite.library_management_system.model.Member;
import com.accolite.library_management_system.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepo;
    @PostMapping
    public ResponseEntity<Member> add(@Valid @RequestBody MemberDTO dto) {
        Member member = Member.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
        return ResponseEntity.ok(memberRepo.save(member));
    }
    @GetMapping
    public ResponseEntity<List<Member>> getAll() {
        return ResponseEntity.ok(memberRepo.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Member> getById(@PathVariable Long id) {
        return ResponseEntity.ok(memberRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found")));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        memberRepo.deleteById(id);
        return ResponseEntity.ok("Member deleted");
    }
}
