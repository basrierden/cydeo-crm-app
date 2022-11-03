package com.cydeo.crm.utilities;

import org.openqa.selenium.WebElement;

public class BrowserUtils {

    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }

    public static boolean assertWebElementNotPresent(WebElement webElement)  {

        try {
            webElement.getText();
            return false;
        } catch (Exception ignored) {
            return true;
        }
    }
}
