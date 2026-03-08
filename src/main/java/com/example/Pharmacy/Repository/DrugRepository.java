package com.example.Pharmacy.Repository;

import com.example.Pharmacy.Model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DrugRepository extends JpaRepository<Drug,Long> {


    @Query("select d from Drug d where d.drugName=?1")
    Drug  getDrugPriceANDQuantity( String drugName);






}
