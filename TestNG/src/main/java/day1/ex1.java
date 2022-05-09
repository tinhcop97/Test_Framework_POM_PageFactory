package day1;

import org.testng.annotations.*;

public class ex1 {
    @BeforeSuite
    void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("Before Method");
    }

    @Test
    void testCase1() {
        System.out.println("Test case 1");
    }

    @Test
    void testCase2() {
        System.out.println("Test method 2");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("After Method ");
    }

    @AfterClass
    void afterCLass() {
        System.out.println("After Class");
    }

    @AfterTest
    void afterTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("After suite");
    }

}