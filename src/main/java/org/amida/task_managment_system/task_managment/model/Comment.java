package org.amida.task_managment_system.task_managment.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.amida.task_managment_system.user_managment.model.User;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    private Task task;

    @ManyToOne
    private User author;
}
