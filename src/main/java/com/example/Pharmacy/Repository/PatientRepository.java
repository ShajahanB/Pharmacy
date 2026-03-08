package com.example.Pharmacy.Repository;

import com.example.Pharmacy.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
