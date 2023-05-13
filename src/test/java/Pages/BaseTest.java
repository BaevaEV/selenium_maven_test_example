package Pages;

import Pages.AuthorizationPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BaseTest {
    public static AuthorizationPage authorizationPage;
    public static WebDriver driver;
    public static MainPage mainPage;
    public static CreateNewNote createNotePage;



    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        authorizationPage = new AuthorizationPage(driver);
        mainPage = new MainPage(driver);
        createNotePage = new CreateNewNote(driver);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}

