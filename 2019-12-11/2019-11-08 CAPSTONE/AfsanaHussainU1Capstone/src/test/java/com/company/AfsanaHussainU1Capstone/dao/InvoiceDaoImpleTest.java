package com.company.AfsanaHussainU1Capstone.dao;

import com.company.AfsanaHussainU1Capstone.models.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoImpleTest {
    @Autowired
    InvoiceDao invoiceDao;

    @Before
    public void setUp () {
        invoiceDao.findAllInvoice().forEach(invoice -> invoiceDao.deleteInvoiceById(invoice.getInvoiceId()));
    }
    @Test
    public void shouldAddGetDelete() {
        Invoice invoice = new Invoice();
        invoice.setName("Bob evans");
        invoice.setStreet("totowa");
        invoice.setCity("paterson");
        invoice.setState("NJ");
        invoice.setZipCode("07014");
        invoice.setItemType("console");
        invoice.setItemId(4);
        invoice.setUnitPrice(new BigDecimal(199.99).setScale(2,RoundingMode.CEILING));
        invoice.setQuantity(3);
        invoice.setSubtotal(new BigDecimal(299.99).setScale(2,RoundingMode.CEILING));
        invoice.setTax(new BigDecimal(15.99).setScale(2,RoundingMode.CEILING));
        invoice.setProcessingFee(new BigDecimal("14.99").setScale(2, RoundingMode.CEILING));
        invoice.setTotal(new BigDecimal(399.99).setScale(2,RoundingMode.CEILING));
        invoice =invoiceDao.saveInvoice(invoice);
        assertEquals(invoice, invoiceDao.findInvoiceById(invoice.getInvoiceId()));
        invoiceDao.deleteInvoiceById(invoice.getInvoiceId());
        assertNull(invoiceDao.findInvoiceById(invoice.getInvoiceId()));
    }

    @Test

    public void shouldUpdateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Bob evans");
        invoice.setStreet("totowa");
        invoice.setCity("paterson");
        invoice.setState("NJ");
        invoice.setZipCode("07014");
        invoice.setItemType("console");
        invoice.setItemId(4);
        invoice.setUnitPrice(new BigDecimal(199.99).setScale(2,RoundingMode.CEILING));
        invoice.setQuantity(3);
        invoice.setSubtotal(new BigDecimal(299.99).setScale(2,RoundingMode.CEILING));
        invoice.setTax(new BigDecimal(15.99).setScale(2,RoundingMode.CEILING));
        invoice.setProcessingFee(new BigDecimal("14.99").setScale(2, RoundingMode.CEILING));
        invoice.setTotal(new BigDecimal(399.99).setScale(2,RoundingMode.CEILING));
        invoice =invoiceDao.saveInvoice(invoice);

        invoice.setQuantity(3);
        invoiceDao.updateInvoice(invoice);
        assertEquals(invoice, invoiceDao.findInvoiceById(invoice.getInvoiceId()));
    }

    @Test
    public void shouldGetAllInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Bob evans");
        invoice.setStreet("totowa");
        invoice.setCity("paterson");
        invoice.setState("NJ");
        invoice.setZipCode("07014");
        invoice.setItemType("console");
        invoice.setItemId(4);
        invoice.setUnitPrice(new BigDecimal(199.99).setScale(2,RoundingMode.CEILING));
        invoice.setQuantity(3);
        invoice.setSubtotal(new BigDecimal(299.99).setScale(2,RoundingMode.CEILING));
        invoice.setTax(new BigDecimal(15.99).setScale(2,RoundingMode.CEILING));
        invoice.setProcessingFee(new BigDecimal("14.99").setScale(2, RoundingMode.CEILING));
        invoice.setTotal(new BigDecimal(399.99).setScale(2,RoundingMode.CEILING));
        invoice =invoiceDao.saveInvoice(invoice);



        invoice.setName("Bob evans");
        invoice.setStreet("totowa");
        invoice.setCity("paterson");
        invoice.setState("NJ");
        invoice.setZipCode("07014");
        invoice.setItemType("console");
        invoice.setItemId(4);
        invoice.setUnitPrice(new BigDecimal(199.99).setScale(2,RoundingMode.CEILING));
        invoice.setQuantity(3);
        invoice.setSubtotal(new BigDecimal(299.99).setScale(2,RoundingMode.CEILING));
        invoice.setTax(new BigDecimal(15.99).setScale(2,RoundingMode.CEILING));
        invoice.setProcessingFee(new BigDecimal("14.99").setScale(2, RoundingMode.CEILING));
        invoice.setTotal(new BigDecimal(399.99).setScale(2,RoundingMode.CEILING));
        invoice =invoiceDao.saveInvoice(invoice);

        assertEquals(2,invoiceDao.findAllInvoice().size());
    }
}
