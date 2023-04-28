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

    @FindBy(css = "iframe#twitter-widget-0")
    private WebElement twitterIframe;

    @FindBy(xpath = "//span[contains(text(),'Tweets')]")
    private WebElement iframeTitle;

    @FindBy(css = "button#iam-cookie-control-modal-action-primary")
    private WebElement acceptButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void navigateToHomepage(){
        visitWebPage("https://www.madrid.es/portal/site/munimadrid");
        validateURL("https://www.madrid.es/portal/site/munimadrid");
    }

    public void clickAcceptCookies() throws InterruptedException {
        waitAndClickElement(acceptButton);
    }

    public void validateTwitterIframeTitle (){
        waitForElementVisibility(twitterIframe);
        switchToIframe(twitterIframe);
        waitForElementVisibility(iframeTitle);
        validateTextHardAssert(iframeTitle,"Tweets de @MADRID");
        System.out.println("Extracted title from Twitter Iframe: "+iframeTitle.getAttribute("innerText")+"\n");
        switchToDefaultIframe();
    }

}
