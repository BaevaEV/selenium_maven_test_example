import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DisplayName(value = "Ожидания")
public class Homework4Test {
    WebDriver driver;

    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Order(1)
    @Test
    @DisplayName(value = "Явное")
    public void waitingTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://172.24.120.5:8081/login");
        driver.findElement(By.id("login-input")).sendKeys("BAEVA");
        driver.findElement(By.id("password-input")).sendKeys("Start123");
        driver.findElement(By.id("form_auth_button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Удаленные')]"))).click();;
    }

    @Order(2)
    @Test
    @DisplayName(value = "Неявное")
    public void waiting2Test() {
        driver.get("http://172.24.120.5:8081/login");
        driver.findElement(By.id("login-input")).sendKeys("BAEVA");
        driver.findElement(By.id("password-input")).sendKeys("Start123");
        driver.findElement(By.id("form_auth_button")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Удаленные')]")).click();
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}


