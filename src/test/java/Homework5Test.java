import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@DisplayName(value = "Утверждения")
public class Homework5Test {
    WebDriver driver;


    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Order(1)
    @Test
    @DisplayName(value = "Note title")
    public void assert1Test() {
        driver.get("http://172.24.120.5:8081/login");
        driver.findElement(By.id("login-input")).sendKeys("BAEVA");
        driver.findElement(By.id("password-input")).sendKeys("Start123");
        driver.findElement(By.id("form_auth_button")).click();
        driver.findElement(By.xpath("//div[@class='Card_containerNew__adAai']")).click();
        driver.findElement(By.id("note-modal-title-new_empty")).sendKeys("О весне");
        driver.findElement(By.xpath("//div[contains(text(),'Содержание')]")).click();
        driver.findElement(By.id("note-modal-content-new_empty")).sendKeys("Весна, весна! Как воздух чист!");
        driver.findElement(By.id("palette-btn-new_empty")).click();
        driver.findElement(By.id("palette-color-#fff475")).click();
        driver.findElement(By.id("note-modal-save-btn-new_empty")).click();
        String titleText = driver.findElement(By.xpath("//p[@class='Card_title__K3B5U']")).getText();
        Assertions.assertEquals("О весне",titleText, "Верный заголовок заметки");
    }

    @Order(2)
    @Test
    @DisplayName(value = "Note content")
    public void assert12est() {
        driver.get("http://172.24.120.5:8081/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("login-input")).sendKeys("BAEVA");
        driver.findElement(By.id("password-input")).sendKeys("Start123");
        driver.findElement(By.id("form_auth_button")).click();
        String contentText = driver.findElement(By.xpath("//div[@class='Card_body__35O4X']")).getText();
        Assertions.assertEquals("Весна, весна! Как воздух чист!",contentText, "Верный текст заметки");
    }

    @Order(3)
    @Test
    @DisplayName(value = "Note color")
    public void assert3Test() {
        driver.get("http://172.24.120.5:8081/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("login-input")).sendKeys("BAEVA");
        driver.findElement(By.id("password-input")).sendKeys("Start123");
        driver.findElement(By.id("form_auth_button")).click();;
        driver.findElement(By.xpath("//div[contains(text(),'Весна, весна! Как воздух чист!')]")).click();
        String noteColor = driver.findElement(By.xpath("//div[@class='Card_container__YjYSI']")).getCssValue("background-color");
        Assertions.assertEquals("rgba(255, 244, 117, 1)",noteColor, "да, желтый!");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}
