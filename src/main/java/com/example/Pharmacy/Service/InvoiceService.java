package com.example.Pharmacy.Service;


import com.example.Pharmacy.Model.Drug;
import com.example.Pharmacy.Model.Invoice;
import com.example.Pharmacy.Model.InvoiceItem;
import com.example.Pharmacy.Repository.DrugRepository;
import com.example.Pharmacy.Repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final DrugRepository drugRepository;
    private final InvoiceRepository invoiceRepository;


    @Transactional
    public Invoice createInvoice(Invoice invoiceRequest) {
        double total = 0.0;

        for (InvoiceItem item : invoiceRequest.getItems()) {

            Drug drug = drugRepository.getDrugPriceANDQuantity(item.getDrugName());
                  //  .orElseThrow(() -> new RuntimeException("Drug not Found:" + item.getDrugName()));
            Optional<Drug> optionalDrug   =drugRepository.findById(drug.getDrug_id());
            if(optionalDrug.isPresent()) {

                if (drug.getDrug_quantity() < item.getQuantity()) {
                    throw new RuntimeException("InSufficinet Stock" + drug.getDrugName());
                }

                drug.setDrug_quantity(drug.getDrug_quantity() - item.getQuantity());
                drugRepository.save(drug);


                item.setPrice(drug.getDrug_price());
                item.setTotal((item.getQuantity() * drug.getDrug_price())/ drug.getPerStrip());
                item.setInvoice(invoiceRequest);
                total += item.getTotal();

            }
        }


        invoiceRequest.setTotalAmount(total);
        return invoiceRepository.save(invoiceRequest);

    }


}
