package com.accolite.library_management_system.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.accolite.library_management_system.model.Member;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}