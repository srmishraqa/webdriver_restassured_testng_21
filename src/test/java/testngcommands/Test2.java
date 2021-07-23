package testngcommands;

import org.testng.Assert;
import org.testng.annotations.*;

public class Test2 {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("calling @BeforeSuite in Test2 Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("calling @BeforeTest in Test2 Class");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("calling @BeforeClass in Test2 Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("calling @BeforeMethod in Test2 Class");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("calling @AfterMethod in Test2 Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("calling @AfterClass in Test2 Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("calling @AfterTest in Test2 Class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("calling @AfterSuite in Test2 Class");
    }

    @org.testng.annotations.Test(priority = 1)
    public void test1() {
        System.out.println("Executing test1() in Test2 Class");
        Assert.assertTrue(true);
    }

    @org.testng.annotations.Test(priority = 0)
    public void test() {
        System.out.println("Executing test() in Test2 Class");
        Assert.assertTrue(true);
    }

    @org.testng.annotations.Test(priority = 2)
    public void test2() {
        System.out.println("Executing test2() in Test2 Class");
        String output = "TEST";
        Assert.assertEquals(output.toLowerCase(), "test");
    }

}
