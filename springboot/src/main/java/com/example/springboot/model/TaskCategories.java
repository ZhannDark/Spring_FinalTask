package com.example.springboot.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "task-categories")
@Data
public class TaskCategories {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
