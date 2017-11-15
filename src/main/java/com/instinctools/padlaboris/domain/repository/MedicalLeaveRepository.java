package com.instinctools.padlaboris.domain.repository;

import com.instinctools.padlaboris.domain.model.MedicalLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * MedicalLeave Repository.
 */
public interface MedicalLeaveRepository extends JpaRepository<MedicalLeave, Integer> {

    @Query(value = "SELECT * FROM medical_leaves WHERE start_date=?1", nativeQuery = true)
    List<MedicalLeave> findByStartDate(Date startDate);
}
