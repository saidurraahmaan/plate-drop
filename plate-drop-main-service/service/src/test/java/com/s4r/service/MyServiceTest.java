package com.s4r.service;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest("service.message=Hello")
public class MyServiceTest {

//    @Autowired
//    private MyService myService;
//
//    @Test
//    public void contextLoads() {
//        assertThat(myService.message()).isNotNull();
//    }

    @SpringBootApplication
    static class TestConfiguration {
    }

}