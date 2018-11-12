package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class CheckMainMenuTest extends BaseScript{

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = getDriver();
        driver.get(getAdminUrl());

        /** Authorization*/
        Thread.sleep(4000);                                             //To Refactor
        WebElement loginEl = driver.findElement(By.id("email"));
        String login = getAdminLogin();
        loginEl.sendKeys(login);
        WebElement passEl = driver.findElement(By.id("passwd"));
        passEl.sendKeys(getAdminPassword());
        WebElement stayLogged = driver.findElement(By.id("stay_logged_in"));
        stayLogged.click();
        WebElement submit = driver.findElement(By.name("submitLogin"));
        submit.click();
        Thread.sleep(4000);

        /**Find the list of clickable elements*/
        List<WebElement> refs = driver.findElements(By.cssSelector("li[class^='maintab']"));

        Actions builder = new Actions(driver);

        /**Navbar test*/
        for (int i = 0; i < refs.size(); i++)
        {
            WebElement ref = (WebElement) refs.toArray()[i];
            Thread.sleep(4000);
            builder.moveToElement(ref);
            builder.click().build().perform();
            Thread.sleep(2000);
            String primaryTitle = driver.getTitle();
            System.out.println(primaryTitle);
            driver.navigate().refresh();
            Thread.sleep(2000);
            String refreshTitle = driver.getTitle();
            assert primaryTitle.equals(refreshTitle);
            refs = driver.findElements(By.cssSelector("li[class^='maintab']"));
            if (refs.isEmpty()){
                refs = driver.findElements(By.cssSelector("li[class^='link-levelone']"));
            }
        }

        driver.quit();
    }
}
