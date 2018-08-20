package com.redscarf.demo2;

import com.redscarf.demo2.persistence.mongo.repository.impl.SimpleCustomerRepository;
import com.redscarf.demo2.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//import java.util.concurrent.CountDownLatch;

/**
 * <p>function:
 * <p>User: leejohn
 * <p>Date: 16/7/8
 * <p>Version: 1.0
 */
@SpringBootApplication
@Slf4j
@EnableMongoRepositories(repositoryBaseClass = SimpleCustomerRepository.class)//mongo 模块才需要引进
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class Demo2WebApplication implements CommandLineRunner {

    @Value("${applicationName}")
    private String applicationName;

    @Autowired
    private SampleService service;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Demo2WebApplication.class);
        application.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        /* 权限设置
//        SecurityContextHolder.getContext()
//                .setAuthentication(new UsernamePasswordAuthenticationToken("user", "N/A",
//                        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER")));
        try {
            System.out.println(this.service.secure());
        }
        finally {
            SecurityContextHolder.clearContext();
        }
*/
//        CountDownLatch countDownLatch = new CountDownLatch(1);
        log.info("{} boot successfully", this.applicationName);
//        countDownLatch.await();
    }

}