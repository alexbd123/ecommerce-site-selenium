package com.webdriver.test;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleElements {

    WebDriver driver = new ChromeDriver();

    @Test
    public void elementsAreDisplayed() {
        assert driver.findElement(By.id("idExample")).isDisplayed();
        assert driver.findElement(By.className("buttonClass")).isDisplayed();
        assert driver.findElement(By.linkText("Click this link")).isDisplayed();
        assert driver.findElement(By.name("button1")).isDisplayed();
        assert driver.findElement(By.tagName("select")).isDisplayed();
        assert driver.findElement(By.xpath("//*[@id=\"button1\"]")).isDisplayed();
        assert driver.findElement(By.cssSelector(".et_pb_button.et_pb_promo_button[href='https://courses.ultimateqa.com/users/sign_in']")).isDisplayed();
    }

    @Test
    public void clickButtonById() {
    WebElement greenIdButton = driver.findElement(By.id("idExample"));
    greenIdButton.click();
    assert driver.findElement(By.className("entry-title")).getText().equals("Button success");
    }

    @Test
    public void clickButtonByClassName() {
        driver.findElement(By.className("buttonClass")).click();
        System.out.println(driver.findElement(By.className("entry-title")).getText());
        assert driver.findElement(By.className("entry-title")).getText().equals("Button success");
    }

    @Test
    public void clickClickableIcon() {
        driver.findElement(By.className("et-waypoint")).click();
        assert driver.findElement(By.className("entry-title")).getText().equals("Link success");
    }

    @Test
    public void sendEmail() throws InterruptedException {
        driver.findElement(By.id("et_pb_contact_name_0")).sendKeys("Craig");
        driver.findElement(By.id("et_pb_contact_email_0")).sendKeys("craig@gmail.com");
        driver.findElement(By.name("et_builder_submit_button")).click();
        Thread.sleep(2500);
        assert driver.findElement(By.className("et-pb-contact-message")).getText().equals("Thanks for contacting us");
    }

    @Test
    public void radioButtons() throws InterruptedException {
        List<WebElement> genders = driver.findElements(By.name("gender"));
        System.out.println(genders.get(0).getAttribute("value"));
        System.out.println(genders.get(1).getAttribute("value"));
        System.out.println(genders.get(2).getAttribute("value"));
        genders.get(0).click();
        Thread.sleep(100);
        assert genders.get(0).isSelected();
    }

    @Test
    public void readTabContent() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Tab Content: " + driver.findElement(By.className("et_pb_tab_content")).getText());
    }

    @Test
    public void dropDownItems() {
        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select select = new Select(dropdown);
        List<WebElement> dropdownElements = select.getOptions();
        for (WebElement option : dropdownElements) {
            System.out.println("Value: " + option.getAttribute("value") + ", Text: " + option.getText());
        }
        assert dropdownElements.get(0).getText().equals("Volvo");
        assert dropdownElements.get(1).getText().equals("Saab");
        assert dropdownElements.get(2).getText().equals("Opel");
        assert dropdownElements.get(3).getText().equals("Audi");
    }

    @Test
    public void findEachXPathButton() throws InterruptedException {
        assert driver.findElement(By.xpath("//*[@id='button1'][1]")).isDisplayed();
        assert driver.findElement(By.xpath("//*[@id='button1'][2]")).isDisplayed();
        assert driver.findElement(By.xpath("//*[@id='button1'][3]")).isDisplayed();
        assert driver.findElement(By.xpath("//*[@id='button1'][4]")).isDisplayed();
    }

    @Test
    public void getRowForQAEngineerFromTableWithId() {
        WebElement table = driver.findElement(By.id("htmlTableId"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            // Find all cells (td elements) within the row
            List<WebElement> cells = row.findElements(By.tagName("td"));
            // Find a row where the first cell contains the text Quality Assurance Engineer
            if (!cells.isEmpty() && cells.get(0).getText().equals("Quality Assurance Engineer")) {
                // Iterate through each cell and print its text
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + "  ");
                }
            }
        }
    }

    @BeforeEach
    public void setUp(){
       driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       //set the Chrome window to open on the screen to the left of the main (use 1920 for screen on the right)
       Point position = new Point(-1920, 0);
       driver.manage().window().setPosition(position);
       driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
       // driver.quit();
    }

}
