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


class LoginPage extends BasePage {
	private By emailBy = By.xpath("//*[@id=\"loginEmail\"]/input");
	private By passwordBy = By.xpath("//*[@id=\"loginPassword\"]/input");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage login() {
        this.waitAndReturnElement(emailBy).sendKeys("tecala6483@idurse.com");
        this.waitAndReturnElement(passwordBy).sendKeys("tecala6483\n");

        return new ProfilePage(this.driver);
    }

}


