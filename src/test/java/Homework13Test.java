import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;


@DisplayName(value = "Исключения")
public class Homework13Test {
    WebDriver driver;


    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.get("http://172.24.120.5:8081/login");
        driver.findElement(By.id("login-input")).sendKeys("BAEVA");
        driver.findElement(By.id("password-input")).sendKeys("Start123");
        driver.findElement(By.id("form_auth_button")).click();

    }

    @Test
    @DisplayName(value = "Вот именно тут будет исключение")
    public void for1Test() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10));
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Card_containerNew__adAai']"))).click();
            }
            catch(TimeoutException e) {
                throw new TimeoutException("не успели за милисекунды");
            }
            finally {
                System.out.println("надо добавить ожидание!");
            }
            driver.findElement(By.id("note-modal-title-new_empty")).sendKeys("О весне");
            driver.findElement(By.xpath("//div[contains(text(),'Содержание')]")).click();
            driver.findElement(By.id("note-modal-content-new_empty")).sendKeys("Весна, весна! Как воздух чист!");
            driver.findElement(By.id("palette-btn-new_empty")).click();
            driver.findElement(By.id("palette-color-#fff475")).click();
            driver.findElement(By.id("note-modal-save-btn-new_empty")).click();
        }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}