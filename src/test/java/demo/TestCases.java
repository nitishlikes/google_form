package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.logging.Level;
import demo.wrappers.Wrappers;


public class TestCases {
    ChromeDriver driver;

    @Test
    public void testCase01() throws InterruptedException {

        String message = "I want to be the best QA Engineer!";
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA"); // navigating to specified url
        Thread.sleep(3000);
        System.out.println("Wait 1");

        // Entering Name
        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(name));
        Wrappers.enterText(name, "Crio Learner");

        // Entering Why are you practicing Automation
        WebElement automation = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        String epochTime = Wrappers.getEpochTime();
        Thread.sleep(3000);
        System.out.println("Wait 2");
        Wrappers.enterText(automation, message + " " + epochTime);

        // Selecting radio button for automation experience
        Thread.sleep(3000);
        Wrappers.radioButton(driver, "3 - 5");

        // Selecting checkboxes for skillsets
        Thread.sleep(3000);
        System.out.println("Wait 3");
        Wrappers.checkBox(driver, "Java");
        Wrappers.checkBox(driver, "Selenium");
        Wrappers.checkBox(driver, "TestNG");

        // Selecting salution dropdown
        WebElement dropDown = driver.findElement(By.xpath("//div[contains(@class,'DEh1R')]"));
        Thread.sleep(3000);
        System.out.println("Wait 4");
        Wrappers.clickElement(driver, dropDown);
        Thread.sleep(3000);
        System.out.println("Wait 5");
        Wrappers.dropDownClick(driver, "Mr");

        // Entering date
        WebElement dateBox = driver.findElement(By.xpath("//input[@type='date']"));
        String requiredDate = Wrappers.getdate();
        Thread.sleep(3000);
        System.out.println("Wait 6");
        Wrappers.enterText(dateBox, requiredDate);

        // Entering time
        WebElement hour = driver.findElement(By.xpath("(//input[@role='combobox'])[1]"));
        WebElement min = driver.findElement(By.xpath("(//input[@role='combobox'])[2]"));
        Wrappers.enterText(hour, "07");
        Wrappers.enterText(min, "30");

        // click submit
        WebElement submit = driver.findElement(By.cssSelector(".NPEfkd "));
        Wrappers.clickElement(driver, submit);
        Thread.sleep(3000);
        System.out.println("Wait 7");

        // capture success message
        String expected_message = "Thanks for your response, Automation Wizard!";
        String actual_message = driver.findElement(By.cssSelector(".vHW8K")).getText();
        System.out.println(actual_message);
        Assert.assertEquals(actual_message, expected_message);

    }

    @BeforeTest
    public void startBrowser() {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest() {
        driver.close();
        driver.quit();
    }
}