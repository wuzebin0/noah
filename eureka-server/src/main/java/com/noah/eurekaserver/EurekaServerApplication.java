package com.noah.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Iterator;
import java.util.ServiceLoader;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        //SpringApplication.run(EurekaServerApplication.class, args);
        //System.out.println("succ");
        //META-INF/services
        //META-INF/services
        ServiceLoader<JavaSpiTest> load = ServiceLoader.load(JavaSpiTest.class);
        Iterator<JavaSpiTest> iterator = load.iterator();
        while (iterator.hasNext()) {
            JavaSpiTest next = iterator.next();
            next.sayHello();
        }
        System.out.println("执行结束");
    }

}
