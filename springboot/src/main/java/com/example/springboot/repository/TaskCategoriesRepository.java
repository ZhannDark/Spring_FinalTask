package com.example.springboot.repository;

import com.example.springboot.model.TaskCategories;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface TaskCategoriesRepository extends JpaRepository<TaskCategories, Long> {
}
