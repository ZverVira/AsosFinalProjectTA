package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public RegistrationPage getRegistrationPage() {
        return new RegistrationPage(driver);
    }

    public SavedListsPage getSavedListsPage() {
        return new SavedListsPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public ShoppingBagPage getShoppingBagPage() {
        return new ShoppingBagPage(driver);
    }
}
