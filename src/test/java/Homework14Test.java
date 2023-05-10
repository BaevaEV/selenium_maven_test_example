import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


@DisplayName(value = "добавили JavaScript")
public class Homework14Test {
    WebDriver driver;


    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    @DisplayName(value = "тест с JS")
    public void assert1Test() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://172.24.120.5:8081/login");
        driver.findElement(By.id("login-input")).sendKeys("BAEVA");
        driver.findElement(By.id("password-input")).sendKeys("Start123");
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("form_auth_button")));
        js.executeScript("arguments[0].click();", button);
        String href = driver.findElement(By.xpath("//a[contains(text(),'Swagger')]")).getAttribute("href");
        driver.get("https://www.digitalleague.ru");
        js.executeScript("window.open('" + href +"')");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @AfterEach
    public void closeDriver() {

        driver.quit();
    }
}