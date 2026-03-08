package com.example.Pharmacy.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drug_id;


    private String drugName;



    private String drug_manufacturer;


    private double  drug_price;


    private int drug_dosage;

    private long drug_quantity;
    private String drug_expirydate;

    private int perStrip;


/*@ManyToOne
    @JsonIgnoreProperties("drug")
    private Patient patient;*/

   /* public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }*/

    public Long getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(Long drug_id) {
        this.drug_id = drug_id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrug_manufacturer() {
        return drug_manufacturer;
    }

    public void setDrug_manufacturer(String drug_manufacturer) {
        this.drug_manufacturer = drug_manufacturer;
    }

    public double getDrug_price() {
        return drug_price;
    }

    public void setDrug_price(double drug_price) {
        this.drug_price = drug_price;
    }

    public int getDrug_dosage() {
        return drug_dosage;
    }

    public void setDrug_dosage(int drug_dosage) {
        this.drug_dosage = drug_dosage;
    }

    public long getDrug_quantity() {
        return drug_quantity;
    }

    public void setDrug_quantity(long drug_quantity) {
        this.drug_quantity = drug_quantity;
    }

    public String getDrug_expirydate() {
        return drug_expirydate;
    }

    public void setDrug_expirydate(String drug_expirydate) {
        this.drug_expirydate = drug_expirydate;
    }


    public int getPerStrip() {
        return perStrip;
    }

    public void setPerStrip(int perStrip) {
        this.perStrip = perStrip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drug drug)) return false;
        return Double.compare(getDrug_price(), drug.getDrug_price()) == 0 && getDrug_dosage() == drug.getDrug_dosage() && getDrug_quantity() == drug.getDrug_quantity() && getPerStrip() == drug.getPerStrip() && Objects.equals(getDrug_id(), drug.getDrug_id()) && Objects.equals(getDrugName(), drug.getDrugName()) && Objects.equals(getDrug_manufacturer(), drug.getDrug_manufacturer()) && Objects.equals(getDrug_expirydate(), drug.getDrug_expirydate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrug_id(), getDrugName(), getDrug_manufacturer(), getDrug_price(), getDrug_dosage(), getDrug_quantity(), getDrug_expirydate(), getPerStrip());
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drug_id=" + drug_id +
                ", drugName='" + drugName + '\'' +
                ", drug_manufacturer='" + drug_manufacturer + '\'' +
                ", drug_price=" + drug_price +
                ", drug_dosage=" + drug_dosage +
                ", drug_quantity=" + drug_quantity +
                ", drug_expirydate='" + drug_expirydate + '\'' +
                ", perStrip=" + perStrip +
                '}';
    }
}

