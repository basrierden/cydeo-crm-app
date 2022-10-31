package com.cydeo.crm.pages;

import com.cydeo.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class ActivityStreamPage {

    public ActivityStreamPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//span[@class='user-name']")
    public WebElement usernameDropdown;

    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logoutButton;

    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-vote']/span")
    public WebElement pollModule;

    @FindBy(xpath = "//a[@id='bx-destination-tag']")
    public WebElement addMoreButton;

    @FindBy(xpath = "(//div[@class='bx-finder-box-item-t7-name'])[3]")
    public WebElement yasinak;

    @FindBy(xpath = "(//div[@class='bx-finder-box-item-t7-name'])[4]")
    public WebElement johndoe;

    @FindBy(xpath = "(//span[@class='feed-add-post-destination-text'])[2]/..")
    public WebElement yasinakAdded;

    @FindBy(xpath = "(//span[@class='feed-add-post-destination-text'])[3]/..")
    public WebElement johndoeAdded;

    @FindBy(xpath = "//input[@id='question_0']")
    public WebElement question_0;

    @FindBy(xpath = "//input[@id='answer_0__0_']")
    public WebElement answer_0_Answer_1;

    @FindBy(xpath = "//input[@id='answer_0__1_']")
    public WebElement answer_0_Answer_2;

    @FindBy(xpath = "//a[.='Add question']")
    public WebElement addQuestionButton;

    @FindBy(xpath = "//input[@id='question_1']")
    public WebElement addedQuestion1;

    @FindBy(xpath = "//input[@id='answer_1__0_']")
    public WebElement addedAnswer1;

    @FindBy(xpath = "//input[@id='answer_1__0_']")
    public WebElement addedAnswer2;

    @FindBy(xpath = "(//label[@title='Delete question'])[2]")
    public WebElement deleteQuestionButton;

    @FindBy(xpath = "//input[@id='multi_0']")
    public WebElement allowMultipleChoiceCheckbox;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement messageTitleFrame;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement frameBody;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement allEmployeesDeleteButton;


    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;


    @FindBy(xpath = "//span[@class='feed-add-info-text']")
    public WebElement mandatoryFieldErrorMessage;
}
