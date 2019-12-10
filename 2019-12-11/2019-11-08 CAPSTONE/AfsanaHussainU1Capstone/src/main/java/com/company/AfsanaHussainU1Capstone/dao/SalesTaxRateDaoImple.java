package com.company.AfsanaHussainU1Capstone.dao;

import com.company.AfsanaHussainU1Capstone.models.SalesTaxRate;
import com.company.AfsanaHussainU1Capstone.models.Tshirts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class SalesTaxRateDaoImple implements  SalesTaxRateDao {
    private static final String GET_SALES_TAX_RATE_BY_STATE = "SELECT * FROM sales_tax_rate WHERE state = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesTaxRateDaoImple(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    @Override
    public SalesTaxRate getSalesTaxRate(String state) {
        try {
            return jdbcTemplate.queryForObject(GET_SALES_TAX_RATE_BY_STATE, this::mapper, state);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    // Helper Method
    private SalesTaxRate mapper(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setRate(rs.getBigDecimal("rate"));
        salesTaxRate.setState(rs.getString( "state"));

        return salesTaxRate;
    }
}

