package com.example.readwriteseparateshardingjdbc;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
@Log4j2
class ReadwriteseparateShardingjdbcApplicationTests {

    @Test
    void contextLoads() {
        Random random = new Random();
        int s = random.nextInt(4);
        log.info("-------------------"+s);
    }

}
