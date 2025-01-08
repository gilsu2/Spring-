package com.dw.driverapp.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="과목")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="category")
    private String category;
    @Column(name="price")
    private double price;
    @Column(name ="image_url")
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name="instructor_name")
    private Instructor instructor_fk;

}
