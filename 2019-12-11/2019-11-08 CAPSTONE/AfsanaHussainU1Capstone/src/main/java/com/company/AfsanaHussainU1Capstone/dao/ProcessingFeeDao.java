package com.company.AfsanaHussainU1Capstone.dao;

import com.company.AfsanaHussainU1Capstone.models.ProcessingFee;


import java.math.BigDecimal;
import java.util.List;

public interface ProcessingFeeDao {


    ProcessingFee getProcessingFeeByProductType(String productType);

    ProcessingFee saveProcessingFee(ProcessingFee processingFee);


}
