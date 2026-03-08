package com.example.Pharmacy.Controller;

import com.example.Pharmacy.Exception.DrugNotPresentException;
import com.example.Pharmacy.Model.Drug;
import com.example.Pharmacy.Response.ErrorResponse;
import com.example.Pharmacy.Service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drug")
@CrossOrigin("http://localhost:4200")
public class DrugController {

    @Autowired
    private DrugService drugService;

    @PostMapping("/saveDrug")
    public void addDrug(@RequestBody Drug drug){

       drugService.saveDrug(drug);


    }


    @GetMapping("/listDrug")
    public List<Drug> getAllDrugs(){
        return drugService.getAllDrugs();
    }



    @PutMapping("/updateDrug/{id}")
    public  void  updateDrug(@RequestBody Drug drug,@ PathVariable  Long id){

        drugService.updateDrug(id,drug);

}


     @GetMapping("/findDrugById/{id}")
     public Optional<Drug> findDrugByID(@PathVariable Long id){


        return drugService.findDrugById(id);
     }




    @GetMapping("/drugPrice/{drug_name}/{drug_quantity}")
    public long getDrugPriceAndQuantity(@PathVariable String drug_name, @PathVariable long drug_quantity){
        long price= drugService.calculatePrice(drug_name,drug_quantity);
        System.out.println(price);

        return price;

    }

    @GetMapping("/expiredDrug")
     public int getExpiredDrug(){

          return drugService.getExpiredDrugCount();


     }


    @GetMapping("/expiredDrugList")
     public List<Drug> getExpiredDrugList(){

        return drugService.getExpiredDrugList();
     }



}
