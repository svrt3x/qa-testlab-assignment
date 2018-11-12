package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        // TODO Script to execute login and logout steps

        WebDriver driver = getDriver();
        driver.get(getAdminUrl());

        /** Authorization*/
        Thread.sleep(4000);                                             //To Refactor
        WebElement loginEl = driver.findElement(By.id("email"));
        String login = getAdminLogin();
        loginEl.sendKeys(login);
        WebElement passEl = driver.findElement(By.id("passwd"));
        passEl.sendKeys(getAdminPassword());
        WebElement submit = driver.findElement(By.name("submitLogin"));
        submit.click();

        Thread.sleep(3000);
        WebElement pictogram = driver.findElement(By.id("employee_infos"));
        pictogram.click();
        Thread.sleep(3000);
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
