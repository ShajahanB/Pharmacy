package com.example.Pharmacy.Repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.Pharmacy.Model.Drug;

import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection= EmbeddedDatabaseConnection.H2)
public class DrugRepositoryTest {
@Autowired
    private DrugRepository drugRepository;

    @Test
    public void drugRepository_Saveall_drugs(){

        //Arrange

         Drug drug = Drug.builder().drug_id(2L).drug_name("ZERODOL").drug_manufacturer("ABOTT").drug_price(150).drug_dosage(200).drug_quantity(10).drug_expirydate(new Date(
        2022-10-31)).build();

         //Act
         Drug saveDrug = drugRepository.save(drug);



         //Assert

        Assertions.assertThat(saveDrug).isNotNull();
        Assertions.assertThat(saveDrug.getDrug_id()).isGreaterThan(0);



    }

    @Test
    public void drugRepository_findAll(){

        Drug drug1 = Drug.builder().drug_id(3L).drug_name("CALPOL").drug_manufacturer("ABOTT").drug_price(150).drug_dosage(200).drug_quantity(10).drug_expirydate(new Date(
                2022-10-31)).build();
        Drug drug2 = Drug.builder().drug_id(4L).drug_name("PANTOCID").drug_manufacturer("ABOTT").drug_price(150).drug_dosage(200).drug_quantity(10).drug_expirydate(new Date(
                2022-10-31)).build();


        drugRepository.save(drug1);
        drugRepository.save(drug2);


        List<Drug> drugList=drugRepository.findAll();

        Assertions.assertThat(drugList).isNotNull();
        Assertions.assertThat(drugList.size()).isEqualTo(2);
        //Assertions.assertThat(drugList.size()).isGreaterThan(2);

        Assertions.assertThat(drugList.get(0).getDrug_name()).isEqualTo("CALPOL");



    }



}
