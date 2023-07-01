package com.example.springboot.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Tasks {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private int status;

    @Column(name = "comment_name")
    private String comment_name;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    private Folders folders;
}
