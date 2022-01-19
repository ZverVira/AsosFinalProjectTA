package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id = 'chrome-search']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@id = 'myAccountDropdown']//button[@aria-label = 'My Account']//span[@type = 'accountUnfilled']")
    private WebElement myAccountDropdownButton;

    @FindBy(xpath = "//a[@data-testid = 'savedItemsIcon']")
    private WebElement savedItemsButton;

    @FindBy(xpath = "//span[@class = '_1z5n7CN']")
    private WebElement shoppingBagButton;

    @FindBy(xpath = "//a[contains(@href, '/women')][@class = 'src-GlobalBanner-Button-Button_button']")
    private WebElement womenButton;

    @FindBy(xpath = "//div[@id = 'myAccountDropdown']//a[@data-testid ='signin-link']")
    private WebElement signInLink;

    @FindBy(xpath = "//div[@id = 'myAccountDropdown']//a[@data-testid ='signup-link']")
    private WebElement joinLink;

    @FindBy(xpath = "//button[@data-testid= 'myaccount-close-btn']")
    private WebElement myAccountCloseButton;

    @FindBy(xpath = "//a[@data-testid= 'myaccount-link']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//a[@data-testid= 'myorders-link']")
    private WebElement myOrdersLink;

    @FindBy(xpath = "//a[@data-testid= 'returnsinformation-link']")
    private WebElement returnsInformationLink;

    @FindBy(xpath = "//a[@data-testid= 'contactpreferences-link']")
    private WebElement contactPreferencesLink;

    @FindBy(xpath = "//a[@data-testid = 'women-floor']")
    private WebElement womenFloorButton;

    @FindBy(xpath = "//a[@data-testid = 'men-floor']")
    private WebElement menFloorButton;

    @FindBy(xpath = "//a[@data-testid = 'asoslogo']")
    private WebElement asosLogo;

    @FindBy(xpath = "//button[@data-testid = 'search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id= 'myaccount-dropdown']")
    private WebElement myAccountPopup;

    @FindBy(xpath = "//span[@class = 'src-GlobalBanner-Content-Content_copy']")
    private WebElement saleBanner;

    @FindBy(xpath = "//div[@class = '_3qMfO1l']")
    private WebElement searchHistoryWindow;

    @FindBy(xpath = "//span[@class= '_1iEQyiq']")
    private List<WebElement> searchRequests;

    @FindBy(xpath = "//button[@data-testid= 'clear-recent-searches']")
    private WebElement clearSearchHistoryButton;

    @FindBy(xpath = "//a[@data-testid = 'miniBagIcon']")
    private WebElement emptyBagButton;

    Actions action = new Actions(driver);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.sendKeys(searchText);
    }

    public void moveToMyAccountDropdownButton() {
        action.moveToElement(myAccountDropdownButton).build().perform();
    }

    public void clickSavedItemsButton() {
        savedItemsButton.click();
    }

    public void clickWomenButton() {
        womenButton.click();
    }

    public void clickJoinLink() {
        joinLink.click();
    }

    public void clickMyAccountCloseButton() {
        action.moveToElement(myAccountCloseButton).click().build().perform();
    }

    public WebElement getContactPreferencesLink() {
        return contactPreferencesLink;
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isSignInLinkVisible() {
        return signInLink.isDisplayed();
    }

    public boolean isJoinLinkVisible() {
        return joinLink.isDisplayed();
    }

    public boolean isMyAccountLinkVisible() {
        return myAccountLink.isDisplayed();
    }

    public boolean isMyOrdersLinkVisible() {
        return myOrdersLink.isDisplayed();
    }

    public boolean isReturnsInformationLinkVisible() {
        return returnsInformationLink.isDisplayed();
    }

    public boolean isContactPreferencesLinkVisible() {
        return contactPreferencesLink.isDisplayed();
    }

    public boolean isMyAccountPopupVisible() {
        return myAccountPopup.isDisplayed();
    }

    public WebElement getSaleBanner() {
        return saleBanner;
    }

    public WebElement getMyAccountPopup() {
        return myAccountPopup;
    }

    public String getShoppingBagAmount() {
        return shoppingBagButton.getText();
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public void clickSearchField() {
        searchField.click();
    }

    public WebElement getSearchHistoryWindow() {
        return searchHistoryWindow;
    }

    public List<WebElement> getHistorySearchResults() {
        return searchRequests;
    }

    public List<String> addSearchRequestsListIntoStringList() {
        List<String> searchRequestsMessagesListText = new ArrayList<>();
        for (WebElement element : getHistorySearchResults()) {
            searchRequestsMessagesListText.add(element.getText());
        }
        return searchRequestsMessagesListText;
    }

    public void isSearchHistoryWindowVisible() {
        searchHistoryWindow.isDisplayed();
    }

    public String getEmptyBagAmount() {
        return emptyBagButton.getText();
    }
}
