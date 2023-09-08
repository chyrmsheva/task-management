package com.example.taskmanagement.entities;

import com.example.taskmanagement.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String header;
    @Enumerated
    private Status status;
}
