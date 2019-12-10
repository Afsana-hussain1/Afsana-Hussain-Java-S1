package com.company.AfsanaHussainU1Capstone.dao;


import com.company.AfsanaHussainU1Capstone.models.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProcessingFeeDaoImple  implements  ProcessingFeeDao{

    private static final String GET_PROCESSING_FEE_BY_PRODUCT_TYPE = "SELECT * FROM processing_fee WHERE product_type = ?";
    private static final String SAVE_PROCESSING_FEE = "INSERT INTO processing_fee (product_type, fee) VALUES(?, ?)";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeDaoImple(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    @Override
    public ProcessingFee getProcessingFeeByProductType(String productType) {
        try {
            return jdbcTemplate.queryForObject(GET_PROCESSING_FEE_BY_PRODUCT_TYPE, this::mapper, productType);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    @Override
    public ProcessingFee saveProcessingFee(ProcessingFee processingFee){
        jdbcTemplate.update(SAVE_PROCESSING_FEE,
                processingFee.getProductType(),
                processingFee.getFee());
        return processingFee;
    }


    // Helper Method
    private ProcessingFee mapper(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }
}



