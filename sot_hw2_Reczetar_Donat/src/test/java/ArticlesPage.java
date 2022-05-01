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


class ArticlesPage extends BasePage {
    private By archiveBy = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[3]/a");

    public ArticlesPage(WebDriver driver) {
        super(driver);
    }

    public ArchivePage toArchive()
    {
        this.waitAndReturnElement(archiveBy).click();
        return new ArchivePage(this.driver);
    }

}


