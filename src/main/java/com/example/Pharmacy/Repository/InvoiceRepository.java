package com.example.Pharmacy.Repository;

import com.example.Pharmacy.Model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

}
