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


class ProfilePage extends BasePage {
	private By editButtonBy = By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div/section/div/button");
	private By nameBy = By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div/div[1]/form/div[2]/label[1]/input");
	private By saveBy = By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div/div[1]/form/div[3]/div[1]/button[1]");
	private By logoutBy = By.xpath("//*[@id=\"app\"]/div/div[1]/nav/div/div/div[2]/div/div/div/a");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void changeName(String newName) {
        this.waitAndReturnElement(editButtonBy).click();
        this.waitAndReturnElement(nameBy).sendKeys(newName);
        this.waitAndReturnElement(saveBy).click();
    }

    public void logout()
    {
		this.waitAndReturnElement(logoutBy).click();
    }

}



