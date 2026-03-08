package com.example.Pharmacy.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;

    private Long patientId;

    private String doctorName;

    private Double totalAmount;


    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<InvoiceItem> items=new ArrayList<>();



}
