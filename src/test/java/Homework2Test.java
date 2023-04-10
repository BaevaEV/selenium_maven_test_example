import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Homework2Test {

    @Test
    public void homework2() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://172.24.120.5:8081/login");
        String AuthorizationLabelText = driver.findElement(By.xpath("//p[contains(text(),'Авторизация')]")).getText();
        driver.findElement(By.id("login-input")).sendKeys(AuthorizationLabelText);
        String AuthorizationvalueText = driver.findElement(By.xpath("//input[@id='login-input']")).getAttribute("value");
        driver.findElement(By.id("password-input")).sendKeys(AuthorizationvalueText);
        driver.findElement(By.id("password-input")).clear();
        String EnterpropertyText = driver.findElement(By.xpath("//button[@id ='form_auth_button']")).getCssValue("front-size");
        driver.findElement(By.id("password-input")).sendKeys(EnterpropertyText);
        driver.quit();
    }
}
