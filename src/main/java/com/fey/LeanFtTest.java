package com.fey;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;
import com.hp.lft.sdk.web.*;
import com.hp.lft.reportbuilder.*;
import com.hp.lft.report.*;

import unittesting.*;

public class LeanFtTest extends UnitTestClassBase {

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException, ReportException {

        BrowserDescription bd = new BrowserDescription();

        bd.setType(BrowserType.CHROME); //or: bd.set("type", BrowserType.INTERNET_EXPLORER) or: bd.set("type", "INTERNET_EXPLORER")

        bd.set("version", "64");

        bd.set("osType", "Windows");

        bd.set("osVersion", "10");

        bd.set("testName", "Fey LRT SRF  Remote Execution demo");

        Browser browser = SrfLab.launchBrowser(bd);


        browser.navigate("http://advantageonlineshopping.com/#/");

        Link sPEAKERSShopNowLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("SPEAKERS Shop Now ")
                .tagName("DIV").build());
        sPEAKERSShopNowLink.click();

        WebElement dvantageWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .innerText("dvantage ")
                .tagName("SPAN").build());

        dvantageWebElement.click();

        Reporter.reportEvent("status", "passed test", Status.Passed);


    }

}