package testngcommands;

import org.testng.Assert;
import org.testng.annotations.*;

public class Test {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("calling @BeforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("calling @BeforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("calling @BeforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("calling @BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("calling @AfterMethod");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("calling @AfterClass");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("calling @AfterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("calling @AfterSuite");
    }

    @org.testng.annotations.Test(priority = 1)
    public void test1() {
        System.out.println("Executing test1()");
        Assert.assertTrue(true);
    }

    @org.testng.annotations.Test(priority = 0)
    public void test() {
        System.out.println("Executing test()");
        Assert.assertTrue(true);
    }

    @org.testng.annotations.Test(priority = 2)
    public void test2() {
        System.out.println("Executing test2()");
        String output = "TEST";
        Assert.assertEquals(output.toLowerCase(), "test1");
    }


}
