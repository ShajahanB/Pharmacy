package com.example.Pharmacy.Service;

import com.example.Pharmacy.Model.Drug;
import com.example.Pharmacy.Model.Patient;
import com.example.Pharmacy.Repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {



    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;


    public void savePatient(Patient patient){
        patientRepository.save(patient);

    }


    public List<Patient> getAllPatients(){

        logger.info("List of Patients");

        return patientRepository.findAll();


    }


    public  void  deletePatient(long id){
         patientRepository.deleteById(id);
        logger.info("Patient deleted"+id);

    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> existingPatient = patientRepository.findById(id);
        if (existingPatient.isPresent()) {
            Patient patient = existingPatient.get();
            patient.setPatient_name(updatedPatient.getPatient_name());
            patient.setPatient_mobile(updatedPatient.getPatient_mobile());
            patient.setPatient_age(updatedPatient.getPatient_age());
            patient.setRemarks(updatedPatient.getRemarks());
            return patientRepository.save(patient);
        } else {
            throw new RuntimeException("Patient not found with id: " + id);
        }
    }



}
