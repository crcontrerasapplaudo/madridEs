package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{
    protected WebDriver driver;

    @FindBy(id = "twitter-widget-0")
    private WebElement twitterIframe;

    @FindBy(xpath = "//span[contains(text(),'Tweets')]")
    private WebElement iframeTitle;

    @FindBy(css = "button#iam-cookie-control-modal-action-primary")
    private WebElement acceptButton;

    @FindBy(css = ".pace-done")
    private WebElement cookiesIframe;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void navigateTo(){
        driver.manage().window().maximize();
        driver.get("https://www.madrid.es/portal/site/munimadrid");
    }

    public void clickAcceptCookies(){
        driver.switchTo().frame(cookiesIframe);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(acceptButton));
        acceptButton.click();
        driver.switchTo().defaultContent();
    }

    public String getTwitterIframeTitle (){
        driver.switchTo().frame(twitterIframe);
        String titleText = iframeTitle.getText();
        return titleText;
    }

}
