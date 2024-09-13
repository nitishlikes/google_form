package demo.wrappers;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wrappers {

    public static void enterText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void radioButton(ChromeDriver driver, String text) {
        try {
            WebElement element = driver.findElement(By.xpath("//span[contains(@class,'OvPDhc') and contains(text(),'"
                    + text + "')]/../../..//div[@class='vd3tt']"));
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkBox(ChromeDriver driver, String text) {
        try {
            WebElement element = driver.findElement(By.xpath("//span[contains(@class,'n5vBHf') and contains(text(),'"
                    + text + "')]/../../preceding-sibling::div[contains(@id,'i')]"));
            element.click();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void dropDownClick(ChromeDriver driver, String text) {
        try {
            WebElement element = driver
                    .findElement(By.xpath("//div[contains(@class,'QXL7Te')]//span[text()='" + text + "']"));
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickElement(ChromeDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getdate() {

        LocalDate date = LocalDate.now();
        LocalDate reqDate = date.minusDays(7); // Subtract 7 days
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = reqDate.format(formatter);
        return formattedDate;
    }

    public static String getEpochTime() {

        long epochTime = System.currentTimeMillis() / 1000;
        String epochTimeString = String.valueOf(epochTime);
        return epochTimeString;
    }
}
