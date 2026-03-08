package com.example.Pharmacy.Service;

import com.example.Pharmacy.Exception.DrugNotPresentException;
import com.example.Pharmacy.Model.Drug;
import com.example.Pharmacy.Repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DrugService {

    @Autowired
    private DrugRepository drugRepository;


    public void saveDrug(Drug drug) {
        drugRepository.save(drug);

    }

    public List<Drug> getAllDrugs() {

        return drugRepository.findAll();
    }


    public void updateDrug(Long id, Drug drug) {

        Optional<Drug> optionalDrug = drugRepository.findById(id);
        if (optionalDrug.isPresent()) {
            Drug d = optionalDrug.get();

            // d.setDrug_id(drug.getDrug_id());
            d.setDrugName((drug.getDrugName()));
            // d.setDrug_weight((drug.getDrug_weight()));
            d.setDrug_price((drug.getDrug_price()));

            drugRepository.save(d);

        }

    }

   /* public Drug  getDrugPriceAndQuantity(long drug_id){

        Drug drug = new Drug();

        Drug d = drugRepository.getDrugPriceANDQuantity(drug_id);

            drug.setDrug_id(d.getDrug_id());
            drug.setDrug_price(d.getDrug_price());
            drug.setDrug_quantity(d.getDrug_quantity());

            return drug;

    }*/

    public long calculatePrice(String drug_name, long drug_quantity) {

        long original_quantity = 0;
        double original_price = 0;
        long price = 0;

        Drug drug = drugRepository.getDrugPriceANDQuantity(drug_name);

        original_quantity = drug.getDrug_quantity();
        original_price = drug.getDrug_price();

        price = (long) (original_price / original_quantity);

        price = price * drug_quantity;

        drug.setDrug_quantity(original_quantity - drug_quantity);

        drugRepository.save(drug);


        return price;
    }



    public Optional<Drug> findDrugById(Long id){
        return Optional.ofNullable(drugRepository.findById(id).orElseThrow(() -> new DrugNotPresentException("No Drug with id:" + id)));
    }



     public int getExpiredDrugCount(){

         LocalDate currentDate=LocalDate.now();
         List<Drug> allDrug= drugRepository.findAll();
         int expiredCount=0;

         for(Drug drug:allDrug){



             LocalDate expiryDate=LocalDate.parse(drug.getDrug_expirydate());

             if(expiryDate.isBefore(currentDate)){
                 expiredCount++;
             }
         }
          return expiredCount;

     }



     public List<Drug> getExpiredDrugList(){

         LocalDate currentDate=LocalDate.now();

         List<Drug> drugList=new ArrayList<>();




         List<Drug> allDrug= drugRepository.findAll();

         for(Drug drug:allDrug){



             LocalDate expiryDate=LocalDate.parse(drug.getDrug_expirydate());

             if(expiryDate.isBefore(currentDate)){
                 drugList.add(drug);
             }
         }
         return drugList;
        // return drugRepository.findAll().stream().filter();


     }


}
