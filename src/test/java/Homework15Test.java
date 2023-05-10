import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@DisplayName(value = "работаем с БД")
public class Homework15Test {
    WebDriver driver;


    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        int NumberGenerated = 100 + (int) (Math.random() *3000);
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(1212121212121L);
        executeQuery("INSERT INTO nfaut.notes (id,user_id,name,color,content,priority,created,archive_flg) VALUES ("+ NumberGenerated +" ,115,'Инсерт','#fff475','Автотестом',1,'"+ formater.format(date)+"',false)");
    }

    @Test
    @DisplayName(value = "Работа с БД")
    public void assert1Test() {
        driver.get("http://172.24.120.5:8081/login");
        driver.findElement(By.id("login-input")).sendKeys("BAEVA");
        driver.findElement(By.id("password-input")).sendKeys("Start123");
        driver.findElement(By.id("form_auth_button")).click();
        String titleText = driver.findElement(By.xpath("//p[@class='Card_title__K3B5U']")).getText();
        Assertions.assertEquals("Инсерт",titleText, "Верный заголовок заметки");
        String contentText = driver.findElement(By.xpath("//div[@class='Card_body__35O4X']")).getText();
        Assertions.assertEquals("Автотестом",contentText, "Верный текст заметки");
        String noteColor = driver.findElement(By.xpath("//div[@class='Card_container__YjYSI']")).getCssValue("background-color");
        Assertions.assertEquals("rgba(255, 244, 117, 1)",noteColor, "да, желтый!");
    }


    public void executeQuery(String sql) {
        try {
            String url = "jdbc:postgresql://172.24.120.5:5432/postgres";
            String login = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, login, password);
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                statement.close();
            } finally {
                connection.close();
            }
        }
        catch(Exception e) {
        e.printStackTrace();
    }
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
        executeQuery("DELETE FROM nfaut.notes WHERE name = 'Инсерт'");
    }
}