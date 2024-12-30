package com.dw.jpaapp.dto;

import com.dw.jpaapp.repository.InstructorProfileRepository;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class InstructorProfileDTO {
    private Long id;
    private String bio;
    private String githubUrl;
    private Long instructorId;

}
