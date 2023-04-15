import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@DisplayName(value = "Регистрация на тестовом стенде")
public class Homework3Test {
    WebDriver driver;

@BeforeAll
public static void meth1() {
System.out.println("Начало тестирования");
}

@BeforeEach
public void initDriver() {
driver = new ChromeDriver();
}

@Order(1)
@Test
@DisplayName(value="Тест регистрации")
public void registrationTest(){
    driver.get("http://172.24.120.5:8081/login");
    driver.findElement(By.id("form_register_button")).click();
    driver.findElement(By.xpath("//input[@placeholder='Логин']")).sendKeys("BAEVA");
    driver.findElement(By.xpath("//input[@placeholder='Пароль']")).sendKeys("Start123");
    driver.findElement(By.xpath("//button[contains(text(),'Создать')]")).click();
}

@Order(2)
@Test
@DisplayName(value="Тест входа по логину и паролю")
public void registration2Test(){
    driver.get("http://172.24.120.5:8081/login");
    driver.findElement(By.id("login-input")).sendKeys("BAEVA");
    driver.findElement(By.id("password-input")).sendKeys("Start123");
    driver.findElement(By.id("form_auth_button")).click();
}

@AfterEach
    public void closeDriver(){
    driver.quit();
}

@AfterAll
    public static void meth4() {
        System.out.println("Окончание тестирования");
    }
}