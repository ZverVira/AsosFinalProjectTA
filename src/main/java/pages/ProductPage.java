package pages;

import io.cucumber.java.bs.A;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'add-item']//button[@aria-label= 'Add to bag']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//span[@id = 'selectSizeError']")
    private WebElement sizeErrorMessage;

    @FindBy(xpath = "//span[@class= '_1M-cSy1']")
    private WebElement viewBagButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToBagButton() {
        addToBagButton.click();
    }

    public String getSizeErrorMessageText() {
        return sizeErrorMessage.getText();
    }

    public WebElement getViewBagButton() {
        return viewBagButton;
    }

    public WebElement getAddToBagButton() {
        return addToBagButton;
    }

    public void clickViewBagButton() {
        viewBagButton.click();
    }

    public boolean isAddToBagButtonVisible() {
        return addToBagButton.isDisplayed();
    }

}
