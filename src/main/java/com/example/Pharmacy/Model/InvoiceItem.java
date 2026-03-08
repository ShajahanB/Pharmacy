package com.example.Pharmacy.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "invoice")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drugName;

    private Integer quantity;

    private Double price;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @JsonBackReference
    private Invoice invoice;
}
