package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.lang.module.FindException;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {

    private static final long DEFAULT_WAITING_TIME = 90;
    private static final String ASOS_URL = "https://www.asos.com/";

    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    RegistrationPage registrationPage;
    SavedListsPage savedListsPage;
    SearchResultsPage searchResultsPage;
    ShoppingBagPage shoppingBagPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ASOS_URL);
        pageFactoryManager = new PageFactoryManager(driver);

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User is on the 'Home Page' page")
    public void openHomePage() {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
    }

    @And("User puts the mouse cursor on the 'My Account' button")
    public void moveToMyAccountButton() {
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        homePage.moveToMyAccountDropdownButton();
        homePage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, homePage.getMyAccountPopup());
    }

    @And("'My Account' popup window appears")
    public void checkMyAccountPopupWindowAppears() {
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        assertTrue(homePage.isMyAccountPopupVisible());
    }

    @And("'Sign In' button is displayed")
    public void checkSignInButtonIsDisplayed() {
        homePage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, homePage.getMyAccountPopup());
        assertTrue(homePage.isSignInLinkVisible());
    }

    @And("'Join' button is displayed")
    public void checkJoinButtonIsDisplayed() {
        homePage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, homePage.getMyAccountPopup());
        assertTrue(homePage.isJoinLinkVisible());
    }

    @And("'My Account' button is displayed")
    public void checkMyAccountButtonIsDisplayed() {
        homePage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, homePage.getMyAccountPopup());
        assertTrue(homePage.isMyAccountLinkVisible());
    }

    @And("'My Orders' button is displayed")
    public void checkMyOrdersButtonIsDisplayed() {
        homePage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, homePage.getMyAccountPopup());
        assertTrue(homePage.isMyOrdersLinkVisible());
    }

    @And("'Returns Information' button is displayed")
    public void checkReturnsInformationButtonIsDisplayed() {
        homePage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, homePage.getMyAccountPopup());
        assertTrue(homePage.isReturnsInformationLinkVisible());
    }

    @And("'Contact Preferences' button is displayed")
    public void checkContactPreferencesButtonIsDisplayed() {
        homePage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, homePage.getMyAccountPopup());
        assertTrue(homePage.isContactPreferencesLinkVisible());
    }

    @And("User is able to close 'My Account' pop up window by clicking on 'Close' button")
    public void closeMyAccountPopUpWindow() {
        homePage.clickMyAccountCloseButton();
        homePage.waitInvisibilityOfElement(DEFAULT_WAITING_TIME, homePage.getContactPreferencesLink());
        assertFalse(homePage.isMyAccountPopupVisible());
    }

    @And("User navigates to 'Registration Page' page")
    public void navigateToRegistrationPage() {
        moveToMyAccountButton();
        homePage.clickJoinLink();
        registrationPage = pageFactoryManager.getRegistrationPage();
        registrationPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
    }

    @And("User clicks on 'Join Asos' button")
    public void clickJoinAsosButton() {
        registrationPage.clickJoinAsosButton();
    }

    @And("the appropriate error messages appear {string}")
    public void checkRegistrationErrorMessage(String expectedErrorMessage) {
        assertEquals(registrationPage.getErrorMessageText(), expectedErrorMessage);
    }


    @And("the following error messages appear")
    public void checkErrorMessages(List<String> expectedErrorMessages) {
        assertEquals(registrationPage.addErrorMessagesListIntoStringList(), expectedErrorMessages);
    }


    @And("Registration form is available")
    public void registrationFormIsAvailable() {
        registrationPage.isRegistrationFormAvailable();
    }

    @And("User fills the 'Email Address' field on Registration form with {string} value")
    public void fillEmailAddress(String email) {
        registrationPage.enterTextToEmailField(email);
    }

    @And("User fills the 'First Name' field on Registration form with {string} value")
    public void fillFirstName(String firstname) {
        registrationPage.enterTextToFirstNameField(firstname);
    }

    @And("User fills the 'Last Name' field on Registration form with {string} value")
    public void fillLastName(String lastname) {
        registrationPage.enterTextToLastNameField(lastname);
    }

    @And("User fills the 'Password' field on Registration form with {string} value")
    public void fillPassword(String password) {
        registrationPage.enterTextToPasswordField(password);
    }

    @And("User fills the 'Day Of Birth' field on Registration form with {string} value")
    public void selectDay(String day) {
        registrationPage.selectDayOfBirth(day);
    }

    @And("User fills the 'Month Of Birth' field on Registration form with {string} value")
    public void selectMonth(String month) {
        registrationPage.selectMonthOfBirth(month);
    }

    @And("User fills the 'Year Of Birth' field on Registration form with {string} value")
    public void selectYear(String year) {
        registrationPage.selectYearOfBirth(year);
    }

    @And("User clicks 'Asos Logo' button")
    public void clickAsosLogoButtonButton() {
        registrationPage.clickAsosLogo();
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
    }

    @And("User is redirected to the {string} page")
    public void checkRedirectedToPage(String url) {
        assertEquals(driver.getCurrentUrl(), url);
    }

    @And("User navigates to 'Women Page' page")
    public void navigateToSearchResultsPage() {
        homePage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, homePage.getSaleBanner());
        homePage.clickWomenButton();
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
    }

    @And("User moves to 'Sale' menu item")
    public void moveToSaleMainMenuItem() {
        searchResultsPage.moveToSaleMainCategoryMenuItem();
    }

    @And("User moves 'Best Of Sale' submenu item")
    public void selectBestOfSaleMenuItem() {
        searchResultsPage.moveToBestOfSaleSubCategoryMenuItem();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, searchResultsPage.getCategoryBannerTitle());
    }

    @And("User clicks 'Brand' button")
    public void clickBrandButton() {
        searchResultsPage.clickBrandFilterItem();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, searchResultsPage.getBrandSearchField());
    }

    @And("User fills the brand search field with {string} value")
    public void fillTheSearchFieldWithBrandNameValue(final String brandName) {
        searchResultsPage.enterTextIntoBrandSearchField(brandName);
    }

    @And("User fills the search field with {string} value")
    public void fillTheSearchFieldWithProductCodeValue(final String productCode) {
        homePage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, homePage.getSearchField());
        homePage.enterTextToSearchField(productCode);
    }

    @And("the {string} brand is displayed in search popup title")
    public void checkBrandInBrandLists(final String searchBrand) {
        searchResultsPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, searchResultsPage.getSelectedBrandTitle());
        assertEquals(searchResultsPage.getSelectedBrandTitleText(), searchBrand);
    }

    @And("User clicks on search result")
    public void clickOnSearchResult() {
        searchResultsPage.chooseBrandFromBrandsList();
    }

    @And("found products respond to search brand {string}")
    public void checkProductsRespondToSearchBrand(final String expectedBrand) {
        for (String string : searchResultsPage.getSearchProductsTitlesText()) {
            assertTrue(string.contains(expectedBrand));
        }
    }

    @And("User clicks 'Save for later' button on the first product")
    public void clickSaveForLaterOnTheFirstProduct() {
        searchResultsPage.clickSaveForLaterButton();
    }

    @And("the {int} product is added to 'Save for later' list")
    public void checkAmountOfProductsInSaveForLaterList(int expectedAmount) {
        searchResultsPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, searchResultsPage.getCategoryBannerTitle());
        homePage.clickSavedItemsButton();
        savedListsPage = pageFactoryManager.getSavedListsPage();
        savedListsPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        savedListsPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, savedListsPage.getHeaderSavedItems());
        assertEquals(savedListsPage.getAmountOfProductInSaveForLaterList(), expectedAmount);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
    }

    @And("User clicks 'Add to bag' button")
    public void clickAddToBagButton() {
        productPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, productPage.getAddToBagButton());
        if (productPage.isAddToBagButtonVisible()) {
            productPage.clickAddToBagButton();
        } else {
            for (int i = 0; i < searchResultsPage.getProductItemSize(); i++) {
                driver.navigate().back();
                searchResultsPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
                searchResultsPage.clickProductItem(i + 1);
                productPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, productPage.getAddToBagButton());
                if (productPage.isAddToBagButtonVisible()) {
                    productPage.clickAddToBagButton();
                }
            }
        }
    }

    @And("the amount of products in 'Shopping Bag' are {string}")
    public void checkAmountOfProductsInShoppingBag(final String expectedAmount) {
        productPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, productPage.getViewBagButton());
        assertEquals(homePage.getShoppingBagAmount(), expectedAmount);
    }

    @And("the following error messages appear {string}")
    public void checkSizeErrorMessage(final String expectedErrorMessage) {
        assertEquals(productPage.getSizeErrorMessageText(), expectedErrorMessage);
    }

    @And("User clicks on search field")
    public void clickOnSearchField() {
        homePage.clickSearchField();
        homePage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, homePage.getSearchHistoryWindow());
    }

    @And("the following search words is displayed in the search field")
    public void checkSearchRequestsHistory(List<String> expectedResults) {
        assertEquals(homePage.addSearchRequestsListIntoStringList(), expectedResults);
    }

    @And("the search history window is displayed")
    public void isSearchHistoryWindowDisplayed() {
        homePage.isSearchHistoryWindowVisible();
    }

    @And("User checks that current url contains {string} parameter")
    public void checksCurrentUrlContainsKeyword(final String keyword) {
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        assertTrue(driver.getCurrentUrl().contains(keyword));
    }

    @And("User moves to the 'Shopping Bag'")
    public void moveToTheShoppingBag() {
        productPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, productPage.getViewBagButton());
        productPage.clickViewBagButton();
        shoppingBagPage = pageFactoryManager.getShoppingBagPage();
        shoppingBagPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
    }

    @And("User clicks on 'Remove' button")
    public void clickOnRemoveButton() {
        shoppingBagPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, shoppingBagPage.getShoppingBagTitle());
        shoppingBagPage.clickRemoveButton();
    }

    @And("the product is deleted from 'Shopping Bag'")
    public void checkDeleteProductFromShoppingBag() {
        shoppingBagPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, shoppingBagPage.getEmptyBagTitle());
        assertEquals(homePage.getEmptyBagAmount(), "");
    }

    @And("User selects {int} items in 'Quantity' dropdown menu")
    public void selectAmountOfProductsInQuantityDropdownMenu(final int productAmount) {
        shoppingBagPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, shoppingBagPage.getShoppingBagTitle());
        shoppingBagPage.moveToQuantityDropDownMenu();
        shoppingBagPage.clickQuantityDropDownMenu();
        shoppingBagPage.chooseQuantityMenuItems(productAmount);
        shoppingBagPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, shoppingBagPage.getEditUpdateButton());
        shoppingBagPage.clickEditUpdateButton();
    }

    @And("the amount of products in 'Shopping Bag' is updated to {string}")
    public void checkUpdatedAmountOfProductsInShoppingBag(final String updatedAmount) {
        shoppingBagPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, shoppingBagPage.getRemoveButton());
        assertEquals(homePage.getShoppingBagAmount(), updatedAmount);
    }

    @And("User moves to 'Accessories' menu item")
    public void moveToAccessoriesMainMenuItem() {
        searchResultsPage.moveToAccessoriesMainCategoryMenuItem();
    }

    @And("User moves 'Hair Accessories' submenu item")
    public void selectHairAccessoriesMenuItem() {
        searchResultsPage.moveToHairAccessoriesSubCategoryMenuItem();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, searchResultsPage.getCategoryBannerTitle());
    }

    @And("User clicks on the {int} product")
    public void clicksOnTheFirstProduct(final int index) {
        searchResultsPage.clickProductItem(index-1);
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        productPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, productPage.getAddToBagButton());
    }
}

