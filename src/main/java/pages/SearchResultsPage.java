package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//button[contains(@data-auto-id,'saveForLater')]")
    private List<WebElement> saveForLaterButton;

    @FindBy(xpath = "//section[@id = 'category-banner-wrapper']")
    private WebElement categoryBannerTitle;

    @FindBy(xpath = "//li[@data-dropdown-id = 'brand']")
    private WebElement brandFilterItem;

    @FindBy(xpath = "//div[@class = '_2EAcS_V _2H7teJE']//input[@type= 'search']")
    private WebElement brandSearchField;

    @FindBy(xpath = "//ul[@class= 'C_vX7H2 dV6RFzr']//div[@class = 'kx2nDmW']")
//"//ul[@class= 'C_vX7H2 dV6RFzr']//input[@type = 'checkbox']")
    private WebElement brandsTitle;

    @FindBy(xpath = "//div[@class= '_3J74XsK']")
    private List<WebElement> searchProductsTitles;

    @FindBy(xpath = "//div[@class = '_22hmIFt']//p[contains(@data-auto-id, 'selectedFacetValueList')]")
    private WebElement selectedBrandTitle;

    @FindBy(xpath = "//button[@data-testid= 'primarynav-button']")
    private List<WebElement> mainCategoryMenuLists;

    @FindBy(xpath = "//ul[@aria-labelledby = 'shop-sale-by-product-a11']//a[@data-testid ='text-link']")
    private List<WebElement> subCategoryMenuItems;

    @FindBy(xpath = "//div[@class = '_3WEsAhb']")
    private List<WebElement> productItem;

    @FindBy(xpath = "//a[contains(@href,'hair-accessories')]//div[@class = 'dpxaPBA nHj_v_i oWutxMh']")
    private WebElement hairAccessories;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickSaveForLaterButton() {
        saveForLaterButton.get(0).click();
    }

    public WebElement getCategoryBannerTitle() {
        return categoryBannerTitle;
    }

    public void clickBrandFilterItem() {
        brandFilterItem.click();
    }

    public void enterTextIntoBrandSearchField(final String searchBrand) {
        brandSearchField.sendKeys(searchBrand);
    }

    public void chooseBrandFromBrandsList() {
        brandsTitle.click();
    }

    public List<WebElement> getSearchProductsTitles() {
        return searchProductsTitles;
    }

    public List<String> getSearchProductsTitlesText() {
        List<String> searchProductsTitlesList = new ArrayList<>();
        for (WebElement element : getSearchProductsTitles()) {
            searchProductsTitlesList.add(element.getText());
        }
        return searchProductsTitlesList;
    }

    public String getSelectedBrandTitleText() {
        return selectedBrandTitle.getText();
    }

    public WebElement getSelectedBrandTitle() {
        return selectedBrandTitle;
    }

    public WebElement getBrandSearchField() {
        return brandSearchField;
    }

    public void moveToSaleMainCategoryMenuItem() {
        mainCategoryMenuLists.get(0).click();
    }

    public void moveToBestOfSaleSubCategoryMenuItem() {
        subCategoryMenuItems.get(0).click();
    }

    public void moveToAccessoriesMainCategoryMenuItem() {
        mainCategoryMenuLists.get(5).click();
    }

    public void moveToHairAccessoriesSubCategoryMenuItem() {
        hairAccessories.click();
    }

    public void clickProductItem(final int index) {
        productItem.get(index).click();
    }

    public int getProductItemSize() {
        return productItem.size();
    }
}
