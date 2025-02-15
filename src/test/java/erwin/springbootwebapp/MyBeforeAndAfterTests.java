package erwin.springbootwebapp;

import org.junit.jupiter.api.*;


public class MyBeforeAndAfterTests {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("MyBeforeEach.setUp");
    }
    @Test
    void test() {
        System.out.println("Hello World");
    }


    @AfterEach
    void afterEach() {
        System.out.println("AfterEach.setUp");
    }
    @Test
    void test1() {
        System.out.println("Hello World");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }

}
