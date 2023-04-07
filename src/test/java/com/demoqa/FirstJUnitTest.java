package com.demoqa;

import org.junit.jupiter.api.*;

public class FirstJUnitTest {

    @BeforeAll
    static void  beforeAll(){
        System.out.println("#### @BeforeAll");
    }

    @AfterAll
    static void  afterAll(){
        System.out.println("#### @AfterAll");
    }

@BeforeEach
void beforeEach(){
    System.out.println("    #### @BeforeEach");
}

    @AfterEach
    void afterEach(){
        System.out.println("    #### @AfterEach");
    }
    @Test
void firstTest() {
         Assertions.assertTrue(3 > 2);
  System.out.println("    #### @test firstTest()");
    }

    @Test
    void secondTest() {
        Assertions.assertTrue(3 > 2);
        System.out.println("    #### @Test secondTest()");
    }
}
