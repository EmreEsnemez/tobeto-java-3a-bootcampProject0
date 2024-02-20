package com.tobeto.java3a.bootcampproject.business;

import com.tobeto.java3a.bootcampproject.core.dtos.user.applicant.ApplicantDto;
import com.tobeto.java3a.bootcampproject.core.dtos.user.applicant.SaveApplicantDto;
import com.tobeto.java3a.bootcampproject.dataaccess.ApplicantRepository;
import com.tobeto.java3a.bootcampproject.entities.user.Applicant;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantManager {

    private ApplicantRepository applicantRepository;
    private final ModelMapper modelMapper;

    public ApplicantManager(ApplicantRepository applicantRepository, ModelMapper modelMapper) {
        this.applicantRepository = applicantRepository;
        this.modelMapper = modelMapper;
    }

    public List<ApplicantDto> getAll() {
        return applicantRepository.findAll().stream()
                .map(user -> modelMapper.map(user, ApplicantDto.class))
                .collect(Collectors.toList());
    }

    public ApplicantDto getById(Long id) {
        return modelMapper.map(applicantRepository.findById(id).get(), ApplicantDto.class);
    }

    public void add(SaveApplicantDto applicantDto) {
        applicantRepository.save(modelMapper.map(applicantDto, Applicant.class));
    }

    public void update(Long id, SaveApplicantDto applicantDto) {
        Applicant applicant = modelMapper.map(applicantDto, Applicant.class);
        applicant.setId(id);

        applicantRepository.save(applicant);
    }

    public void removeById(Long id) {
        applicantRepository.deleteById(id);
    }
}
