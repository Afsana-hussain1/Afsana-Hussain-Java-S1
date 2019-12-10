package com.company.AfsanaHussainU1Capstone.dao;

import com.company.AfsanaHussainU1Capstone.models.Invoice;

import java.util.List;

public  interface InvoiceDao {

    Invoice findInvoiceById(int id);

    List<Invoice>findAllInvoice();

    Invoice saveInvoice(Invoice invoice);

    void  deleteInvoiceById(int id);

    void updateInvoice(Invoice invoice);
}
