package com.accolite.library_management_system.repository;
import com.accolite.library_management_system.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
}
