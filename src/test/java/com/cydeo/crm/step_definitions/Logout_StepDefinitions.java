package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.ActivityStreamPage;
import com.cydeo.crm.pages.LoginPage;
import com.cydeo.crm.utilities.ConfigurationReader;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class Logout_StepDefinitions {

    LoginPage loginPage=new LoginPage();
    ActivityStreamPage activityStreamPage=new ActivityStreamPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    Actions actions= new Actions(Driver.getDriver());
    WebDriver driver1;
    WebDriver driver2;

    @Given("user is on the CRM24 Activity Stream page")
    public void user_is_on_the_crm24_activity_stream_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("crm.url"));
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("helpdesk_username"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("helpdesk_password"));
        loginPage.loginButton.click();
        wait.until(ExpectedConditions.titleContains("Portal"));

    }

    @When("user clicks on the username dropdown")
    public void user_clicks_on_the_username_dropdown() {
        activityStreamPage.usernameDropdown.click();
    }

    @When("user clicks on the Log out button")
    public void user_clicks_on_the_log_out_button() {
        activityStreamPage.logoutButton.click();
    }

    @Then("user sees the title is Authorization")
    public void user_sees_the_title_is_authorization() throws InterruptedException {
        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle= "Authorization";
        wait.until(ExpectedConditions.titleIs("Authorization"));
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(3000);
    }

    @When("user clicks on the username dropdown and on the Log out button")
    public void user_clicks_on_the_username_dropdown_and_on_the_log_out_button() {
        activityStreamPage.usernameDropdown.click();
        activityStreamPage.logoutButton.click();

    }

    @When("user clicks on the step back button")
    public void user_clicks_on_the_step_back_button() throws InterruptedException {
        Driver.getDriver().navigate().back();
        Thread.sleep(3000);
        Driver.getDriver().navigate().back();
        Thread.sleep(3000);
    }

    @When("user open multiple tabs and enter valid credentials")
    public void user_open_multiple_tabs_and_enter_valid_credentials() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get(ConfigurationReader.getProperty("crm.url"));
        Thread.sleep(3000);
        WebElement usernameBox1= driver1.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement passwordBox1= driver1.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        WebElement loginButton1= driver1.findElement(By.xpath("//input[@value='Log In']"));
        usernameBox1.sendKeys("hr2@cybertekschool.com");
        passwordBox1.sendKeys("UserUser");
        loginButton1.click();

        WebDriverManager.chromedriver().setup();
        driver2 = new ChromeDriver();
        driver2.manage().window().maximize();
        driver2.get(ConfigurationReader.getProperty("crm.url"));
        Thread.sleep(3000);
        WebElement usernameBox2= driver2.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement passwordBox2= driver2.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        WebElement loginButton2= driver2.findElement(By.xpath("//input[@value='Log In']"));
        usernameBox2.sendKeys("hr2@cybertekschool.com");
        passwordBox2.sendKeys("UserUser");
        loginButton2.click();

    }
    
    @When("user closes all tabs")
    public void user_closes_all_tabs() {
        Driver.closeDriver();
        driver1.close();
        driver2.close();

    }


    @When("user opens new tab and types URL address of the app")
    public void user_opens_new_tab_and_types_url_addreess_of_the_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("crm.url"));
    }

    @Then("user sees the page of the title is Authorization")
    public void user_sees_the_page_of_the_title_is_authorization() {

        String expectedTitle= "Authorization";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }




}
