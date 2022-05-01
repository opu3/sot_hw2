import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;


public class FirstSeleniumTest {
    public WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getFooterText().contains("Wizards of the Coast LLC"));

        LoginPage loginPage = mainPage.login();
        Assert.assertTrue(loginPage.getBodyText().contains("Email"));
        Assert.assertTrue(loginPage.getBodyText().contains("Password"));

        ProfilePage profilePage = loginPage.login();
        Assert.assertTrue(profilePage.getBodyText().contains("First Name"));

        profilePage.changeName("Pali");
        //Assert.assertTrue(profilePage.getBodyText().contains("Pali"));

        profilePage.logout();
    }

    @Test
    public void testFinder()
    {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getTitle().contains("Magic: The Gathering"));

        StorePage storePage = mainPage.findStore();
        storePage.find("Budapest");

        Assert.assertTrue(storePage.getBodyText().contains("Metagame Kártyabolt"));
    }

    @Test
    public void testSearch()
    {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getTitle().contains("Magic: The Gathering"));

        ArticlesPage articlesPage = mainPage.toArticles();
        ArchivePage archivePage = articlesPage.toArchive();
        Assert.assertTrue(archivePage.getBodyText().contains("SEARCH THE ARCHIVE"));

        String[] querries = {"Comprehensive Rules Canges", "Oracle Changes", "Kamigawa"};
        for( int i = 0; i < querries.length; ++i )
        {
            archivePage.find(querries[i]);
            Assert.assertTrue(archivePage.getBodyText().contains(querries[i]));
        }
    }


    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}

