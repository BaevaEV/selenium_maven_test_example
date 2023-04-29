import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@DisplayName(value = "Циклы")
public class Homework10Test {
    WebDriver driver;



    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Order(1)
    @Test
    @DisplayName(value = "Part 1")
    public void for1Test() {
        driver.get("http://172.24.120.5:8081/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(By.id("login-input")).sendKeys("BAEVA");
        driver.findElement(By.id("password-input")).sendKeys("Start123");
        driver.findElement(By.id("form_auth_button")).click();
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//div[@class='Card_containerNew__adAai']")).click();
            driver.findElement(By.id("note-modal-title-new_empty")).sendKeys("О весне"+i);
            driver.findElement(By.xpath("//div[contains(text(),'Содержание')]")).click();
            driver.findElement(By.id("note-modal-content-new_empty")).sendKeys("Весна, весна! Как воздух чист!");
            driver.findElement(By.id("palette-btn-new_empty")).click();
            driver.findElement(By.id("palette-color-#fff475")).click();
            driver.findElement(By.id("note-modal-save-btn-new_empty")).click();
            WebElement title = new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style,'display')]/div[" + (i + 1) + "]")));
            String s = title.getText();
            System.out.println(s);
        }
        int f;
            for (int j = 0; j < 3; j++) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style,'display')]/div["+(j+1)+"]/div[2]/img[1]"))).click();
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

    @Order(2)
    @Test
    @DisplayName(value = "Part 2")
    public void for2Test() {
        driver.get("http://172.24.120.5:8081/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("login-input")).sendKeys("BAEVA");
        driver.findElement(By.id("password-input")).sendKeys("Start123");
        driver.findElement(By.id("form_auth_button")).click();
        if (countNote() == 0) {
            driver.findElement(By.xpath("//div[@class='Card_containerNew__adAai']")).click();
            driver.findElement(By.id("note-modal-title-new_empty")).sendKeys("Про осень!");
            driver.findElement(By.xpath("//div[contains(text(),'Содержание')]")).click();
            driver.findElement(By.id("note-modal-content-new_empty")).sendKeys("Осень наступила, высохли цветы!");
            driver.findElement(By.id("palette-btn-new_empty")).click();
            driver.findElement(By.id("palette-color-#fff475")).click();
            driver.findElement(By.id("note-modal-save-btn-new_empty")).click();

        }
        for (int j = 1; countNote() >= j; j++) {
            WebElement title1 = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style,'display')]/div["+(j+0)+"]")));
            String b = title1.getText();
            System.out.println("Iteration #" +j+ " " + b);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style,'display')]/div["+j+"]/div[2]/img[1]"))).click();
            driver.findElement(By.xpath("//div[@class='ModalCard_cardBodyInput__ghZU0 modal-title h4']")).clear();
            driver.findElement(By.xpath("//div[@class='ModalCard_cardBodyInput__ghZU0 modal-title h4']")).sendKeys("Про лето");
            driver.findElement(By.xpath("//div[@class='ModalCard_cardBodyInput__ghZU0']")).clear();
            driver.findElement(By.xpath("//div[@class='ModalCard_cardBodyInput__ghZU0']")).sendKeys("Я так хочу, чтобы лето не кончалось!");
            driver.findElement(By.xpath("//button[@class='ModalCard_cardButton__g2ndB btn btn-primary']")).click();
            WebElement title = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style,'display')]/div[" + (j) + "]")));
            String k = title.getText();
            System.out.println("Iteration #" +j+ " " + k);
        }
    }

    public int countNote() {
        List<WebElement> notes = driver.findElements(By.xpath("//div[contains(@id,'note-container')]"));
        return notes.size();
    }

    public String textFromNote() {
        List<WebElement> textNotes = driver.findElements(By.tagName("p"));
        for (WebElement text : textNotes)
        return text.getText();
        return null;
    }


    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}

