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


class StorePage extends BasePage {
    private By inputBy = By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[1]/div[1]/input");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void find(String city)
    {
        this.waitAndReturnElement(inputBy).sendKeys(city + "\n");
    }

}

