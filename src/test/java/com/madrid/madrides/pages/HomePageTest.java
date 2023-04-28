package com.madrid.madrides.pages;

import com.madrid.madrides.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setupPages(){
        this.homePage = new HomePage(driver);
    }

    @Test(priority = 1,groups = "homePageGroup")
    public void madridESWorkflow() throws InterruptedException{
        System.out.println("Executing Test 1 of HomePage\n");
        homePage.navigateToHomepage();
        homePage.clickAcceptCookies();
        System.out.println("Finishing Test 1 of HomePage\n");
    }

}
