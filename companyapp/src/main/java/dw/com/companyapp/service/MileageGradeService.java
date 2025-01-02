package dw.com.companyapp.service;


import dw.com.companyapp.model.MileageGrade;
import dw.com.companyapp.repository.MileageGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MileageGradeService {

    @Autowired
    MileageGradeRepository mileageGradeRepository;

    public List<MileageGrade> getAllMileages() {
        return mileageGradeRepository.findAll();
    }
}
