package com.company.AfsanaHussainU1Capstone.controller;


import com.company.AfsanaHussainU1Capstone.exceptions.NotFoundException;
import com.company.AfsanaHussainU1Capstone.models.Invoice;
import com.company.AfsanaHussainU1Capstone.service.ServiceLayer;
import com.company.AfsanaHussainU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(InvoiceViewModel invoice){
        return serviceLayer.saveInvoice(invoice);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel getInvoiceById(int id){
        InvoiceViewModel invoice = serviceLayer.findInvoiceByInvoiceId(id);
        if(invoice == null)
            throw new NotFoundException("not found in db");

        return invoice;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel>getAll(){
        return serviceLayer.getAllInvoices();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoiceById(int id){
        serviceLayer.deleteInvoiceById(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@PathVariable("id")int id, @RequestBody @Valid InvoiceViewModel invoiceViewModel){
        if (invoiceViewModel.getInvoiceId()==0)
            invoiceViewModel.setInvoiceId(id);
        if(id != invoiceViewModel.getInvoiceId()){
            throw  new IllegalArgumentException("invoice id must match invoice ");
        }
        serviceLayer.updateInvoice(invoiceViewModel);
    }


}
