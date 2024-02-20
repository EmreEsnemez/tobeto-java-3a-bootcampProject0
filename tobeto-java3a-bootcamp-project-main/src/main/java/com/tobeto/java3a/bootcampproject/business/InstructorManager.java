package com.tobeto.java3a.bootcampproject.business;

import com.tobeto.java3a.bootcampproject.core.dtos.user.instructor.InstructorDto;
import com.tobeto.java3a.bootcampproject.core.dtos.user.instructor.SaveInstructorDto;
import com.tobeto.java3a.bootcampproject.dataaccess.InstructorRepository;
import com.tobeto.java3a.bootcampproject.entities.user.Instructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorManager {

    private InstructorRepository instructorRepository;
    private final ModelMapper modelMapper;

    public InstructorManager(InstructorRepository instructorRepository, ModelMapper modelMapper) {
        this.instructorRepository = instructorRepository;
        this.modelMapper = modelMapper;
    }

    public List<InstructorDto> getAll() {
        return instructorRepository.findAll().stream()
                .map(instructor -> modelMapper.map(instructor, InstructorDto.class))
                .collect(Collectors.toList());
    }

    public InstructorDto getById(Long id) {
        return modelMapper.map(instructorRepository.findById(id).get(), InstructorDto.class);
    }

    public void add(SaveInstructorDto instructorDto) {
        instructorRepository.save(modelMapper.map(instructorDto, Instructor.class));
    }

    public void update(Long id, SaveInstructorDto instructorDto) {
        Instructor instructor = modelMapper.map(instructorDto, Instructor.class);
        instructor.setId(id);

        instructorRepository.save(instructor);
    }

    public void removeById(Long id) {
        instructorRepository.deleteById(id);
    }
}
