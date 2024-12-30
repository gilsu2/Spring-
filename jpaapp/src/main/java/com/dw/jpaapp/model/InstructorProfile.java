package com.dw.jpaapp.model;

import com.dw.jpaapp.dto.InstructorDTO;

import com.dw.jpaapp.dto.InstructorProfileDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table (name = "instructor_profile")
public class InstructorProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bio",length = 3000) // length는 글자수(바이트 수 아님)
    private String bio; // 강사 소개

    @Column(name = "github_url")
    private String githubUrl;

    @OneToOne
    @JoinColumn(name = "instructor_id") // 단방향 참조
    private Instructor instructor;

    // InstructorProfile 매핑 메서드
    public InstructorProfileDTO ToDTO() {
        InstructorProfileDTO instructorProfileDTO = new InstructorProfileDTO();
        instructorProfileDTO.setId(this.id);
        instructorProfileDTO.setBio(this.bio);
        instructorProfileDTO.setGithubUrl(this.githubUrl);
        instructorProfileDTO.setInstructorId(this.instructor.getId());
        return instructorProfileDTO;
    }

}
