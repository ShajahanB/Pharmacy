package com.example.Pharmacy.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;
    private String patient_name;

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    private int  patient_age;


    private int price;


    private int patient_mobile;

    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", patient_name='" + patient_name + '\'' +
                ", patient_age=" + patient_age +
                ", price=" + price +
                ", patient_mobile=" + patient_mobile +
                ", remarks='" + remarks + '\'' +
                ", drug=" + drug +
                '}';
    }

    public int getPatient_mobile() {
        return patient_mobile;
    }

    public void setPatient_mobile(int patient_mobile) {
        this.patient_mobile = patient_mobile;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @OneToMany( cascade =CascadeType.ALL)
    @JoinColumn(name = "fk_patient_id", referencedColumnName ="patient_id")
    @JsonIgnoreProperties("patient")
    private List<Drug> drug;

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public int getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(int patient_age) {
        this.patient_age = patient_age;
    }

    public List<Drug> getDrug() {
        return drug;
    }

    public void setDrug(List<Drug> drug) {
        this.drug = drug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        return getPatient_age() == patient.getPatient_age() && getPrice() == patient.getPrice() && getPatient_mobile() == patient.getPatient_mobile() && Objects.equals(getPatient_id(), patient.getPatient_id()) && Objects.equals(getPatient_name(), patient.getPatient_name()) && Objects.equals(getRemarks(), patient.getRemarks()) && Objects.equals(getDrug(), patient.getDrug());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPatient_id(), getPatient_name(), getPatient_age(), getPrice(), getPatient_mobile(), getRemarks(), getDrug());
    }
}

