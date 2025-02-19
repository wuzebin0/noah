package com.noah.feign.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {


    @HystrixCommand(fallbackMethod = "hiError")
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
