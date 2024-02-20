package com.tobeto.java3a.bootcampproject.dataaccess;

import com.tobeto.java3a.bootcampproject.entities.user.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
