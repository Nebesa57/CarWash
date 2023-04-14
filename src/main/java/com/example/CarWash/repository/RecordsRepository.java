package com.example.CarWash.repository;

import com.example.CarWash.models.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordsRepository extends JpaRepository<Records,Long> {
    Optional<Records> findById(Long id);
}
