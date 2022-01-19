package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.cert.X509Certificate;
import java.util.List;

public class SavedListsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'productTile_KcKf2')]")
    private List<WebElement> amountOfProduct;

    @FindBy(xpath = "//h1[@class = 'header_2Vu6Z']")
    private WebElement headerSavedItems;

    public SavedListsPage(WebDriver driver) {
        super(driver);
    }

    public int getAmountOfProductInSaveForLaterList() {
        return amountOfProduct.size();
    }

    public WebElement getHeaderSavedItems() {
        return headerSavedItems;
    }
}
