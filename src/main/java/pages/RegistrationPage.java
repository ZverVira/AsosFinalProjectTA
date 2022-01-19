package pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//a[@class = 'home']")
    private WebElement asosLogo;

    @FindBy(xpath = "//input[@alt= 'Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@class= 'qa-firstname-textbox']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@class= 'qa-lastname-textbox']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@aria-describedby= 'PasswordHint']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class= 'subfield select-list']//select[@aria-describedby = 'BirthdayHint']")
    private WebElement birthDayField;

    @FindBy(xpath = "//div[@class= 'subfield long-subfield select-list']//select[@id = 'BirthMonth']")
    private WebElement birthMonthField;

    @FindBy(xpath = "//div[@class= 'subfield last-subfield select-list']//select[@id = 'BirthYear']")
    private WebElement birthYearField;

    @FindBy(xpath = "//div[@class= 'submit']//input[@type = 'submit']")
    private WebElement joinAsosButton;

    @FindBy(xpath = "//span[@id= 'Email-error']")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//span[@id= 'FirstName-error']")
    private WebElement firstNameErrorMessage;

    @FindBy(xpath = "//span[@id= 'LastName-error']")
    private WebElement lastNameErrorMessage;

    @FindBy(xpath = "//span[@id= 'Password-error']")
    private WebElement passwordErrorMessage;

    @FindBy(xpath = "//span[@id= 'BirthYear-error']")
    private WebElement dateOfBirthErrorMessage;

    @FindBy(xpath = "//div[contains(@id, 'register-form')]")
    private WebElement registrationForm;

    @FindBy(xpath = "//span[contains(@id,'-error')]")
    private WebElement errorMessage;

    Actions action = new Actions(driver);

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickAsosLogo() {
        asosLogo.click();
    }

    public void enterTextToEmailField(final String emailText) {
        emailField.sendKeys(emailText);
    }

    public void enterTextToFirstNameField(final String firstNameText) {
        firstNameField.sendKeys(firstNameText);
    }

    public void enterTextToLastNameField(final String lastNameText) {
        lastNameField.sendKeys(lastNameText);
    }

    public void enterTextToPasswordField(final String passwordText) {
        passwordField.sendKeys(passwordText);
    }

    public WebElement getBirthDayField() {
        return birthDayField;
    }

    public WebElement getBirthMonthField() {
        return birthMonthField;
    }

    public WebElement getBirthYearField() {
        return birthYearField;
    }

    public void selectDayOfBirth(String value) {
        action.moveToElement(birthDayField).build().perform();
        Select dayOfBirth = new Select(getBirthDayField());
        dayOfBirth.selectByValue(value);
    }

    public void selectMonthOfBirth(String value) {
        action.moveToElement(birthMonthField).build().perform();
        Select monthOfBirth = new Select(getBirthMonthField());
        monthOfBirth.selectByValue(value);
    }

    public void selectYearOfBirth(String value) {
        action.moveToElement(birthYearField).build().perform();
        Select yearOfBirth = new Select(getBirthYearField());
        yearOfBirth.selectByValue(value);
    }

    public void clickJoinAsosButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", joinAsosButton);
    }

    public String getEmailErrorMessageText() {
        return emailErrorMessage.getText();
    }

    public String getFirstNameErrorMessageText() {
        return firstNameErrorMessage.getText();
    }

    public String getLastNameErrorMessageText() {
        return lastNameErrorMessage.getText();
    }

    public String getPasswordErrorMessageText() {
        return passwordErrorMessage.getText();
    }

    public String getDateOfBirthErrorMessageText() {
        return dateOfBirthErrorMessage.getText();
    }

    public List<String> addErrorMessagesListIntoStringList() {
        List<String> errorMessagesListText = new ArrayList<>();
        errorMessagesListText.add(getEmailErrorMessageText());
        errorMessagesListText.add(getFirstNameErrorMessageText());
        errorMessagesListText.add(getLastNameErrorMessageText());
        errorMessagesListText.add(getPasswordErrorMessageText());
        errorMessagesListText.add(getDateOfBirthErrorMessageText());
        return errorMessagesListText;
    }

    public void isRegistrationFormAvailable() {
        registrationForm.isDisplayed();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
