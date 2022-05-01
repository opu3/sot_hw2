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


class MainPage extends BasePage {

    private By footerBy = By.xpath("//*[@id=\"__layout\"]/div/footer/div[6]/div");
    private By storeFinderBy = By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[3]/div/ul[2]/li[1]/a]");
    private By articlesBy = By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[1]/nav/ul/li[5]/a");
    private By accountBy = By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[1]/div[2]/ul/li[3]/a");
    private By titleBy = by.xpath("/html/head/title");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://magic.wizards.com/en");
    }

    public String getTitle()
    {
        return this.waitAndReturnElement(titleBy).getText();
    }

    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }

    public LoginPage login()
    {
        this.waitAndReturnElement(accountBy).click();
        return new LoginPage(this.driver);
    }

    public StorePage findStore()
    {
        this.waitAndReturnElement(storeFinderBy).click()
        return new StorePage(this.driver);
    }

    public ArticlesPage toArticles()
    {
        this.waitAndReturnElement(articlesBy).click()
        return new ArticlesPage(this.driver);
    }
}

