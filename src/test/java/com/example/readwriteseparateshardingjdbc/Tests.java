package com.example.readwriteseparateshardingjdbc;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@Log4j2
class Tests {

    @Test
    void contextLoads() {
        System.out.println("------0%3-------------"+634448119525801985L%3);
        System.out.println("------0%4-------------"+634448119525801985L%4);
        System.out.println("------1%3-------------"+634447010564407296L%3);
        System.out.println("------1%4-------------"+634447010564407296L%4);
        log.info("------0%3-------------");
    }

}
