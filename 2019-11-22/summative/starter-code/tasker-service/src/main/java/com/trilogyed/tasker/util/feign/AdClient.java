package com.trilogyed.tasker.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "ad-service")
public interface AdClient {

    @RequestMapping(value = "/ad",method = RequestMethod.GET)
    public String adv();
}
