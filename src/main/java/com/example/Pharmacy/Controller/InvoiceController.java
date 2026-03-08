package com.example.Pharmacy.Controller;

import com.example.Pharmacy.Model.Drug;
import com.example.Pharmacy.Model.Invoice;
import com.example.Pharmacy.Repository.DrugRepository;
import com.example.Pharmacy.Service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/api/invoices")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class InvoiceController {


    private final InvoiceService invoiceService;
    private final DrugRepository drugRepository;

    @GetMapping("/drug/{name}")
    public ResponseEntity<Drug> getMedicineByName(@PathVariable String name) {

        Drug drug = drugRepository.getDrugPriceANDQuantity(name);
        if (drug == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(drug);


    }

    @PostMapping("/saveInvoice")
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        //return ok(invoiceService.createInvoice(invoice));
        Invoice in=invoiceService.createInvoice(invoice);
        return ResponseEntity.ok(in);
    }





}
