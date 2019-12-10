//package com.company.AfsanaHussainU1Capstone.dao;
//
//
//import com.company.AfsanaHussainU1Capstone.models.ProcessingFee;
// import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class ProcessingFeeDaoImpleTest {
//
//    @Autowired
//    private ProcessingFeeDao processingFeeDao;
//
//
//
//    @Test
//    public void ShouldGetProcessingFeeByProductType() {
//        ProcessingFee processingFee = new ProcessingFee();
//
//        processingFee.setFee(new BigDecimal(1.98).setScale(2,RoundingMode.CEILING));
//        processingFee.setProductType("T-shirt");
//
//
//
//        assertEquals(processingFee, processingFeeDao.getProcessingFeeByProductType(processingFee.getProductType()));
//
//
//    }
//
//    }
