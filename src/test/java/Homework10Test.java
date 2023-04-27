import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


@DisplayName(value = "Циклы")
public class Homework10Test {
    WebDriver driver;


    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @DisplayName(value = "create Note")
    public void assert1Test() {
        driver.get("http://172.24.120.5:8081/login");
        driver.findElement(By.id("login-input")).sendKeys("BAEVA");
        driver.findElement(By.id("password-input")).sendKeys("Start123");
        driver.findElement(By.id("form_auth_button")).click();
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//div[@class='Card_containerNew__adAai']")).click();
            driver.findElement(By.id("note-modal-title-new_empty")).sendKeys("О весне"+ i);
            driver.findElement(By.xpath("//div[contains(text(),'Содержание')]")).click();
            driver.findElement(By.id("note-modal-content-new_empty")).sendKeys("Весна, весна! Как воздух чист!");
            driver.findElement(By.id("palette-btn-new_empty")).click();
            driver.findElement(By.id("palette-color-#fff475")).click();
            driver.findElement(By.id("note-modal-save-btn-new_empty")).click();
            WebElement title = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style,'display')]/div["+(i+1)+"]")));
            String s = title.getText();
            System.out.println(s);
            }

            for (int j = 0; j < 3; j++) {
                driver.findElement(By.xpath("//p[contains(text(),'О весне')]/ancestor::div[@class = 'Card_container__YjYSI']/descendant::div[@class='Card_fullscreenBtnBar__hP-57']/img[@class='img-fluid']")).click();
                driver.findElement(By.xpath("//div[@class='ModalCard_cardBodyInput__ghZU0 modal-title h4']")).clear();
                driver.findElement(By.xpath("//div[@class='ModalCard_cardBodyInput__ghZU0 modal-title h4']")).sendKeys("О зиме"+j);
                driver.findElement(By.xpath("//div[@class='ModalCard_cardBodyInput__ghZU0']")).clear();
                driver.findElement(By.xpath("//div[@class='ModalCard_cardBodyInput__ghZU0']")).sendKeys("Мороз и солнце, день чудесный!");
                driver.findElement(By.xpath("//button[@class='ModalCard_cardButton__g2ndB btn btn-primary']")).click();
                WebElement title = new WebDriverWait(driver, Duration.ofSeconds(20))
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style,'display')]/div["+(j+1)+"]")));
                String k = title.getText();
                System.out.println(k);
            }

        }
    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}

