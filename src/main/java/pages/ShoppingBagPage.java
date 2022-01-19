package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingBagPage extends BasePage {

    @FindBy(xpath = "//button[@class = 'bag-item-remove']")
    private WebElement removeButton;

    @FindBy(xpath = "//button[@class = 'bag-item-edit-update']")
    private WebElement editUpdateButton;

    @FindBy(xpath = "//span[@class= 'bag-item-quantity-holder bag-item-select2-holder']")
    private WebElement quantityDropDownMenu;

    @FindBy(xpath = "//li[contains(@class,'select2-results')]")
    private List<WebElement> quantityMenuItems;

    @FindBy(xpath = "//h2[@class= 'empty-bag-title']")
    private WebElement emptyBagTitle;

    @FindBy(xpath = "//div[contains(@class,'bag-contents-holder-panel bag-title-holder')]")
    private WebElement shoppingBagTitle;

    Actions action = new Actions(driver);

    public ShoppingBagPage(WebDriver driver) {
        super(driver);
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public void clickEditUpdateButton() {
        editUpdateButton.click();
    }

    public void moveToQuantityDropDownMenu() {
        action.moveToElement(quantityDropDownMenu).build().perform();
    }

    public void clickQuantityDropDownMenu() {
        quantityDropDownMenu.click();
    }

    public void chooseQuantityMenuItems(int productAmount) {
        quantityMenuItems.get(productAmount-1).click();
    }

    public WebElement getEditUpdateButton() {
        return editUpdateButton;
    }

    public WebElement getEmptyBagTitle() {
        return emptyBagTitle;
    }

    public WebElement getShoppingBagTitle() {
        return shoppingBagTitle;
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }
}
