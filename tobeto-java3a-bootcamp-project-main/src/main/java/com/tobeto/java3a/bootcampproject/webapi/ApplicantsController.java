package com.tobeto.java3a.bootcampproject.webapi;

import com.tobeto.java3a.bootcampproject.business.ApplicantManager;
import com.tobeto.java3a.bootcampproject.core.dtos.user.applicant.ApplicantDto;
import com.tobeto.java3a.bootcampproject.core.dtos.user.applicant.SaveApplicantDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantsController {

    private ApplicantManager applicantManager;

    public ApplicantsController(ApplicantManager applicantManager) {
        this.applicantManager = applicantManager;
    }

    @GetMapping("/")
    public List<ApplicantDto> getAll() {
        return applicantManager.getAll();
    }

    @GetMapping("/{id}")
    public ApplicantDto getById(@PathVariable Long id) {
        return applicantManager.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody SaveApplicantDto applicant) {
        applicantManager.add(applicant);
    }

    @PostMapping("/edit/{id}")
    public void edit(@PathVariable Long id, @RequestBody SaveApplicantDto applicant) {
        applicantManager.update(id, applicant);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        applicantManager.removeById(id);
    }
}
