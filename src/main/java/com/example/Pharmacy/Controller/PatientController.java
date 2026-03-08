package com.example.Pharmacy.Controller;


import com.example.Pharmacy.Model.Drug;
import com.example.Pharmacy.Model.Patient;
import com.example.Pharmacy.Service.DrugService;
import com.example.Pharmacy.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin("http://localhost:4200")
public class PatientController {


    @Autowired
    private PatientService patientService;

    @Autowired
    private DrugService drugService;


    @PostMapping("/savePatients")
    public void addPatient(@RequestBody Patient patient) {

        Patient p = new Patient();
        List<Drug> patientdrugs = new ArrayList<>();
        for (Drug d : patient.getDrug()) {
            d.setDrug_id(d.getDrug_id());
           // d.setDrug_name(d.getDrug_name());
            d.setDrugName(d.getDrugName());
            d.setDrug_price(d.getDrug_price());
          //  d.setDrug_weight(d.getDrug_weight());
            patientdrugs.add(d);


        }
            //long drugId =patientdrugs.get(0).getDrug_id();

          //  Drug d1 =drugService.getDrugPriceAndQuantity(drugId);
        p.setPatient_id(patient.getPatient_id());
        p.setPatient_name(patient.getPatient_name());
        p.setPatient_age(patient.getPatient_age());
        p.setDrug(patientdrugs);
        patientService.savePatient(p);


    }

    @GetMapping("/allPatients")
    public List<Patient> listAllPatients() {

        return patientService.getAllPatients();

    }


    @DeleteMapping("/deletePatient/{patient_id}")
    public void deletePatient( @PathVariable  long patient_id){

            patientService.deletePatient(patient_id);

    }
     @PostMapping("/savePatient")
     public void savePatient(@RequestBody Patient patient){

         Patient pa =new Patient();
         pa.setPatient_age(patient.getPatient_age());
         pa.setPatient_name(patient.getPatient_name());
         pa.setPatient_id(patient.getPatient_id());
         pa.setPatient_mobile(patient.getPatient_mobile());
         pa.setRemarks(patient.getRemarks());
         patientService.savePatient(pa);

     }


    @PutMapping("/updatePatient/{id}")
    public  Patient  updatePatient(@RequestBody Patient patient,@ PathVariable  Long id){

        return patientService.updatePatient(id,patient);
    }

}
