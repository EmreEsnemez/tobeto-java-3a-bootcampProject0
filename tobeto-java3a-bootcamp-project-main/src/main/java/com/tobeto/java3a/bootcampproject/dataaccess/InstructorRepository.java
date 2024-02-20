package com.tobeto.java3a.bootcampproject.dataaccess;

import com.tobeto.java3a.bootcampproject.entities.user.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
