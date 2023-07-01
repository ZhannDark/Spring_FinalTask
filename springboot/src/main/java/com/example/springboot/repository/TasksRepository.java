package com.example.springboot.repository;

import com.example.springboot.model.Tasks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    List<Tasks> findAllByFolders_Id(Long id);
    void deleteByFolders_Id(Long id);
}
