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


class ArchivePage extends BasePage {
    private By inputBy = By.xpath("//*[@id=\"custom-search\"]/div[2]/div[1]/div/input[1]");

    public ArchivePage(WebDriver driver) {
        super(driver);
    }

    public void find(String querry)
    {
        this.waitAndReturnElement(inputBy).sendKeys(querry + "\n");
    }

}


