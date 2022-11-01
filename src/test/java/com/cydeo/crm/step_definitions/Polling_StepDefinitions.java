package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.ActivityStreamPage;
import com.cydeo.crm.pages.LoginPage;
import com.cydeo.crm.utilities.ConfigurationReader;
import com.cydeo.crm.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class Polling_StepDefinitions {

    LoginPage loginPage= new LoginPage();
    ActivityStreamPage activityStreamPage = new ActivityStreamPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    Faker faker = new Faker();


    @Given("user is on Activity Stream page and clicks on the POLL tab")
    public void user_is_on_activity_stream_page_and_clicks_on_the_poll_tab() {

        Driver.getDriver().get(ConfigurationReader.getProperty("crm.url"));
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("helpdesk_username"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("helpdesk_password"));
        loginPage.loginButton.click();
        wait.until(ExpectedConditions.titleContains("Portal"));
        activityStreamPage.pollModule.click();
    }

    @When("user clicks on the Add more button")
    public void user_clicks_on_the_add_persons_groups_or_department_button() {
        activityStreamPage.addMoreButton.click();
    }


    @When("user adds multiple contacts for polling")
    public void user_adds_multiple_contacts_for_polling() {
        activityStreamPage.yasinak.click();
        activityStreamPage.johndoe.click();
    }


    @Then("user sees multiple contacts in the polling list")
    public void user_sees_multiple_contacts_in_the_polling_list() {

        String expectedText1= "U593";
        String expectedText2= "U512";

        String actualText1= activityStreamPage.yasinakAdded.getAttribute("data-id");
        String actualText2= activityStreamPage.johndoeAdded.getAttribute("data-id");

        Assert.assertEquals(expectedText1,actualText1);
        Assert.assertEquals(expectedText2,actualText2);

    }


    @And("user clicks on Add question button")
    public void user_clicks_on_add_question_button() {
        activityStreamPage.addQuestionButton.click();
    }


    @Then("user sees a question and multiple answers added to polling section")
    public void user_sees_a_question_and_multiple_answers_added_to_polling_section() {

        Assert.assertTrue(activityStreamPage.addedQuestion1.isDisplayed());
        Assert.assertTrue(activityStreamPage.addedAnswer1.isDisplayed());
        Assert.assertTrue(activityStreamPage.addedAnswer2.isDisplayed());

    }

    @Then("delete question button is clickable on the page")
    public void delete_question_button_is_clickable_on_the_page() {

        Assert.assertTrue(activityStreamPage.deleteQuestionButton.isDisplayed());

    }





    @When("user clicks Allow multiple choice checkbox")
    public void user_clicks_allow_multiple_choice_checkbox() {
        activityStreamPage.allowMultipleChoiceCheckbox.click();
    }


    @Then("user sees the checkbox is selected")
    public void user_sees_the_checkbox_is_selected() {
        Assert.assertTrue(activityStreamPage.allowMultipleChoiceCheckbox.isSelected());
    }

    @When("user creates a poll leaving message title empty")
    public void user_creates_a_poll_leaving_message_title_empty() {

        activityStreamPage.sendButton.click();
    }


    @Then("the message title is not specified error message is displayed on the page")
    public void the_message_title_is_not_specified_error_message_is_displayed_on_the_page() {

        String expectedErrorMessage= "The message title is not specified";
        String actualErrorMessage= activityStreamPage.mandatoryFieldErrorMessage.getText();

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);


    }

    @When("user creates a poll without adding persons for the poll")
    public void user_creates_a_poll_without_adding_persons_for_the_poll() {
        Driver.getDriver().switchTo().frame(activityStreamPage.messageTitleFrame);
        String messageTitle = faker.lorem().word();
        activityStreamPage.frameBody.sendKeys(messageTitle);
        Driver.getDriver().switchTo().parentFrame();
        activityStreamPage.allEmployeesDeleteButton.click();
        String question= faker.lorem().characters();
        activityStreamPage.question_0.sendKeys(question);
        String country1= faker.country().capital();
        String country2= faker.country().currency();
        activityStreamPage.answer_0_Answer_1.sendKeys(country1);
        activityStreamPage.answer_0_Answer_2.sendKeys(country2);
        activityStreamPage.sendButton.click();
    }


    @Then("please specify at least one person error message is displayed on the page")
    public void please_specify_at_least_one_person_error_message_is_displayed_on_the_page() {
        String expectedErrorMessage= "Please specify at least one person.";
        String actualErrorMessage= activityStreamPage.mandatoryFieldErrorMessage.getText();

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);


    }

    @When("user creates a poll without question text")
    public void user_creates_a_poll_without_question_text() {

        Driver.getDriver().switchTo().frame(activityStreamPage.messageTitleFrame);
        String messageTitle = faker.lorem().word();
        activityStreamPage.frameBody.sendKeys(messageTitle);
        Driver.getDriver().switchTo().parentFrame();
        String country1= faker.country().capital();
        String country2= faker.country().currency();
        activityStreamPage.answer_0_Answer_1.sendKeys(country1);
        activityStreamPage.answer_0_Answer_2.sendKeys(country2);
        activityStreamPage.sendButton.click();

    }


    @Then("the question text is not specified error message is displayed on the page")
    public void the_question_text_is_not_specified_error_message_is_displayed_on_the_page() {
        String expectedErrorMessage= "The question text is not specified.";
        String actualErrorMessage= activityStreamPage.mandatoryFieldErrorMessage.getText();

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

    }

    String questionUnique= faker.lorem().characters();
    @When("user creates a poll without answers")
    public void user_creates_a_poll_without_answers() {
        Driver.getDriver().switchTo().frame(activityStreamPage.messageTitleFrame);
        String messageTitle = faker.lorem().word();
        activityStreamPage.frameBody.sendKeys(messageTitle);
        Driver.getDriver().switchTo().parentFrame();

        activityStreamPage.question_0.sendKeys(questionUnique);
        activityStreamPage.sendButton.click();
    }


    @Then("the question has no answers error message is displayed on the page")
    public void the_question_has_no_answers_error_message_is_displayed_on_the_page() {
        String expectedErrorMessage= "The question \"" + questionUnique + "\" has no answers.";
        String actualErrorMessage= activityStreamPage.mandatoryFieldErrorMessage.getText();

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

    }


    @When("user creates a poll with only one answer")
    public void user_creates_a_poll_with_only_one_answer() {
        Driver.getDriver().switchTo().frame(activityStreamPage.messageTitleFrame);
        String messageTitle = faker.lorem().word();
        activityStreamPage.frameBody.sendKeys(messageTitle);
        Driver.getDriver().switchTo().parentFrame();
        String question= faker.lorem().characters();
        activityStreamPage.question_0.sendKeys(question);
        String country1= faker.country().capital();
        activityStreamPage.answer_0_Answer_1.sendKeys(country1);
        activityStreamPage.sendButton.click();
    }


    @Then("please specify at least two answers error message is displayed on the page")
    public void please_specify_at_least_two_answers_error_message_is_displayed_on_the_page() {
        String expectedErrorMessage= "Please specify at least two answers.";
        String actualErrorMessage= activityStreamPage.mandatoryFieldErrorMessage.getText();

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }




}
