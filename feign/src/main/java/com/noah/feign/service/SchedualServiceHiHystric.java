package com.noah.feign.service;

import org.springframework.stereotype.Service;

@Service
public class SchedualServiceHiHystric implements SchedualServiceHi{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
