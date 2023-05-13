import Pages.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Homework16Test extends BaseTest {
    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        authorizationPage.goToAuthorizationPage();
        authorizationPage.fillInLogin("BAEVA");
        authorizationPage.fillInPassword("Start123");
        authorizationPage.clickLoginButton();
    }

    @Test
    @DisplayName(value = "Паттерны в работе")
    public void PatternTest() {
        Assertions.assertEquals(true, createNotePage.createButtonIsDisplayed());
        createNotePage.clickCreateButton();
        createNotePage.fillNoteTitleTextField("Паттерны");
        createNotePage.clickAddContent();
        createNotePage.addNoteContent("это не сложно");
        createNotePage.clickAddColor();
        createNotePage.clickAddNoteColor();
        Assertions.assertEquals(true, createNotePage.saveButtonIsDisplayed());
        createNotePage.saveNewNote();
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

}
