package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.LoginPage;
import com.cydeo.crm.utilities.ConfigurationReader;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

    LoginPage loginPage= new LoginPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("user is on the CRM24 login page")
    public void user_is_on_the_crm24_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("crm.url"));
    }


    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String string, String string2) {
        loginPage.inputUsername.sendKeys(string);
        loginPage.inputPassword.sendKeys(string2);
        loginPage.loginButton.click();
    }


    @Then("Activity Stream page should be displayed")
    public void activity_stream_page_should_be_displayed() {
        String expectedInTitle= "Portal";
        String actualTitle= Driver.getDriver().getTitle();
        wait.until(ExpectedConditions.titleContains("Portal"));
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }


    @When("user enters wrong {string} or wrong {string}")
    public void user_enters_wrong_or_wrong(String string, String string2) {
        loginPage.inputUsername.sendKeys(string);
        loginPage.inputPassword.sendKeys(string2);
        loginPage.loginButton.click();
    }


    @Then("Incorrect login or password {string} should be displayed for invalid credentials")
    public void incorrect_login_or_password_should_be_displayed_for_invalid_credentials(String string) {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }


    @When("user leaves username {string} or password {string} empty")
    public void user_leaves_username_or_password_empty(String string, String string2) {
        loginPage.inputUsername.sendKeys(string);
        loginPage.inputPassword.sendKeys(string2);
        loginPage.loginButton.click();

    }


    @Then("Please fill out this field {string} should be displayed")
    public void please_fill_out_this_field_should_be_displayed(String string) {
        String actualErrorMessage= loginPage.errorMessage.getText();
        Assert.assertEquals(string, actualErrorMessage);
    }


    @When("user clicks forgot password link")
    public void user_clicks_forgot_password_link() {
        loginPage.forgotPasswordLink.click();
    }


    @Then("user land on {string} page")
    public void user_land_on_page(String string) {
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(string,actualTitle);

    }


    @When("user clicks remember me link")
    public void user_clicks_remember_me_link() {
        loginPage.rememberMeCheckBox.click();

    }


    @Then("user sees checkbox is selected")
    public void user_sees_checkbox_is_selected() {
        Assert.assertTrue(loginPage.rememberMeCheckBox.isSelected());
    }


    @When("user enter credentials in password box")
    public void user_enter_credentials_in_password_box() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("helpdesk_password"));
    }


    @Then("user sees password in bullet signs")
    public void user_sees_password_in_bullet_signs() {

        String expectedAttribute= "password";
        String actualAttribute= loginPage.inputPassword.getAttribute("type");

        Assert.assertEquals(expectedAttribute, actualAttribute);
    }


    @When("user enters username {string} and password {string} and clicks Enter key")
    public void user_enters_username_and_password_and_clicks_enter_key(String string, String string2) {
        loginPage.inputUsername.sendKeys(string);
        loginPage.inputPassword.sendKeys(string2 + Keys.ENTER);
    }

    @Then("user lands on the Activity Stream page")
    public void user_lands_on_the_activity_stream_page() {

        String expectedInTitle= "Portal";
        String actualTitle= Driver.getDriver().getTitle();
        wait.until(ExpectedConditions.titleContains("Portal"));
        Assert.assertTrue(actualTitle.contains(expectedInTitle));


    }




}
