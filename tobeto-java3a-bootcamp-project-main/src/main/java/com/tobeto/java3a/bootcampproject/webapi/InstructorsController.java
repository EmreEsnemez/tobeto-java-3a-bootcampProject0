package com.tobeto.java3a.bootcampproject.webapi;

import com.tobeto.java3a.bootcampproject.business.InstructorManager;
import com.tobeto.java3a.bootcampproject.core.dtos.user.instructor.InstructorDto;
import com.tobeto.java3a.bootcampproject.core.dtos.user.instructor.SaveInstructorDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorsController {

    private InstructorManager instructorManager;

    public InstructorsController(InstructorManager instructorManager) {
        this.instructorManager = instructorManager;
    }

    @GetMapping("/")
    public List<InstructorDto> getAll() {
        return instructorManager.getAll();
    }

    @GetMapping("/{id}")
    public InstructorDto getById(@PathVariable Long id) {
        return instructorManager.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody SaveInstructorDto instructor) {
        instructorManager.add(instructor);
    }

    @PostMapping("/edit")
    public void edit(@PathVariable Long id, @RequestBody SaveInstructorDto instructor) {
        instructorManager.update(id, instructor);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        instructorManager.removeById(id);
    }
}
