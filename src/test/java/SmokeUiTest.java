import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SmokeUiTest {
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }


    @Test
    void checkSubmitTitleTest() {

        driver.get(BASE_URL);
        driver.findElement(By.linkText("Web form")).click();
        driver.findElement(By.id("my-text-id")).sendKeys("Test");
        driver.manage().window().maximize();
        WebElement submitButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        new Actions(driver).moveToElement(submitButton).perform();
        submitButton.click();
        WebElement submitTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals("Form submitted", submitTitle.getText());
    }
}

