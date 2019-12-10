//package com.company.AfsanaHussainU1Capstone.dao;
//
//
//import com.company.AfsanaHussainU1Capstone.models.ProcessingFee;
//import com.company.AfsanaHussainU1Capstone.models.SalesTaxRate;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.stereotype.Repository;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class SalesTaxRateDaoImpleTest {
//    @Autowired
//    private SalesTaxRateDao salesTaxRateDao;
//
//
//
//    @Test
//    public void ShouldGetsalesTaxRateByState() {
//        SalesTaxRate salesTaxRate= new SalesTaxRate();
//
//        salesTaxRate.setState("NY");
//        salesTaxRate.setRate(new BigDecimal(0.06).setScale(2,RoundingMode.HALF_UP));
//
//        assertEquals(salesTaxRate, salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState()));
//
//
//    }
//
//}
