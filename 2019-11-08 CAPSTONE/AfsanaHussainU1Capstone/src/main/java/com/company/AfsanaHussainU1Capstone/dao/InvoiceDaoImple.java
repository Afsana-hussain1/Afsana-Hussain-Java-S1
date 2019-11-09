package com.company.AfsanaHussainU1Capstone.dao;


import com.company.AfsanaHussainU1Capstone.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoImple implements InvoiceDao {

    private static final String FIND_INVOICE_BY_ID = " SELECT * FROM  invoice where invoice_id = ?";
    private static final String FIND_ALL_INVOICE = "Select * from invoice";
    private static final String SAVE_INVOICE = "INSERT INTO invoice (name, street, city, state, zipcode, item_type,item_id, unit_price,quantity,subtotal, tax,processing_fee,total) VALUES (?,?,?,?,?,?,?,?,?,?,?,?, ?)";
    private static final String DELETE_INVOICE = "DELETE FROM invoice where invoice_id =?";
    private static final String UPDATE_INVOICE = " Update invoice SET name=?, street= ?, city =?, state =?, zipcode =?, item_type =?, item_id =?, unit_price =?,quantity =?,subtotal =?, tax =?,processing_fee=?, total =?, invoice_id=?";
    private static final String SELECT_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override

    public Invoice findInvoiceById(int id) {
        try {
            return jdbcTemplate.queryForObject(FIND_INVOICE_BY_ID, this::mapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override

    public List<Invoice> findAllInvoice() {
        return jdbcTemplate.query(FIND_ALL_INVOICE, this::mapper);
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        jdbcTemplate.update(SAVE_INVOICE,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipCode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal()
        );

        int id = jdbcTemplate.queryForObject(SELECT_LAST_INSERT_ID, Integer.class);
        invoice.setInvoiceId(id);
        return invoice;
    }


    @Override
    public void updateInvoice(Invoice invoice) {
        jdbcTemplate.update(UPDATE_INVOICE,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipCode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal(),
                invoice.getInvoiceId());
    }

    @Override

    public void deleteInvoiceById(int id) {
        jdbcTemplate.update(DELETE_INVOICE, id);
    }

    // Helper Method
    private Invoice mapper(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setName(rs.getString("name"));
        invoice.setStreet(rs.getString("street"));
        invoice.setCity(rs.getString("city"));
        invoice.setState(rs.getString("state"));
        invoice.setZipCode(rs.getString("zipcode"));
        invoice.setItemType(rs.getString("item_type"));
        invoice.setItemId(rs.getInt("item_id"));
        invoice.setUnitPrice(rs.getBigDecimal("unit_price"));
        invoice.setQuantity(rs.getInt("quantity"));
        invoice.setSubtotal(rs.getBigDecimal("subtotal"));
        invoice.setTax(rs.getBigDecimal("tax"));
        invoice.setProcessingFee(rs.getBigDecimal("processing_fee"));
        invoice.setTotal(rs.getBigDecimal("total"));

        invoice.setInvoiceId(rs.getInt("invoice_id"));
        return invoice;
    }
}




