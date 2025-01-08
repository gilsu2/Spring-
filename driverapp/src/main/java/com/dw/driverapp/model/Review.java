package com.dw.driverapp.model;

import com.dw.driverapp.enums.InstructorRating;
import com.dw.driverapp.enums.SubjectRating;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name="instructor_id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name="user_name")
    private User user;

    @Column(name="subject_point", nullable = false)
    @Enumerated(EnumType.STRING)
    private SubjectRating point;

    @Column(name="instructor_point",nullable = false)
    @Enumerated(EnumType.STRING)
    private InstructorRating point1;

    @Column(name="review_text", columnDefinition = "TEXT")
    private String reviewText;
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

}
