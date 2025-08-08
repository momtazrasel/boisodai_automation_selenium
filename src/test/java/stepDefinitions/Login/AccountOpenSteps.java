package stepDefinitions.Login;

import ReusableMethods.ExcelDataReader;
import ReusableMethods.TestData;
import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.AccountOpenObjectPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

import java.io.IOException;
import java.util.List;

public class AccountOpenSteps {
    private WebDriver driver;
    private PageObjectManager reusableMethod;
    private TestData testData;
    private AccountOpenObjectPage loginPage = new AccountOpenObjectPage();

    public AccountOpenSteps(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.reusableMethod = new PageObjectManager(driver);
        this.testData = new TestData(driver);
    }

    @When("User enter valid username")
    public void userEnterValidUsername() throws IOException {
        reusableMethod.clickElement(loginPage.emailTextField);
        reusableMethod.sendKeysToElement(loginPage.emailTextField,testData.USERNAME);
    }

    @When("User enter valid passwor")
    public void userEnterValidPasswor() throws IOException, InterruptedException {
        Thread.sleep(2000);
        reusableMethod.clickElement(loginPage.passwordTextField);
        reusableMethod.sendKeysToElement(loginPage.passwordTextField,testData.PASSWORD);
    }
    @And("Clicks on Log in button")
    public void clicksOnLogInButton() {
        reusableMethod.clickElement(loginPage.loginButton);
    }
    @Then("Verify that the username or password is invalid")
    public void verifyThatTheUsernameOrPasswordIsInvalid() {
        Assert.assertEquals(reusableMethod.getTextOfElement(loginPage.alertText),"Warning: No match for E-Mail Address and/or Password.");
    }

    @When("Click on the My Account Button")
    public void clickOnTheMyAccountButton() throws InterruptedException {
        reusableMethod.waitUntilElementIsVisible(loginPage.loginLink);
        reusableMethod.clickElement(loginPage.loginLink);
        reusableMethod.clickElement(loginPage.loginHereLink);
        Thread.sleep(2000);


    }

    @And("Click on the Login Option")
    public void clickOnTheLoginOption() {
        reusableMethod.waitUntilElementIsVisible(loginPage.loginOption);
        reusableMethod.clickElement(loginPage.loginOption);
    }

    @When("User enter valid username and invalid password in login form")
    public void userEnterValidUsernameAndInvalidPasswordInLoginForm() throws IOException {
        String filePath = "TestData/Credentials.xlsx";
        String sheetName = "Sheet1";
        List<String[]> excelData = ExcelDataReader.readDataFromExcel(filePath, sheetName);

        for (String[] row : excelData) {
            String username1 = row[0];
            String password = row[2];

            reusableMethod.sendKeysToElement(loginPage.emailTextField, username1);
            reusableMethod.sendKeysToElement(loginPage.passwordTextField, password);
        }
    }

    @When("User enter invalid username and valid password in login form")
    public void userEnterInvalidUsernameAndValidPasswordInLoginForm() throws IOException {
        String filePath = "TestData/Credentials.xlsx";
        String sheetName = "Sheet1";
        List<String[]> excelData = ExcelDataReader.readDataFromExcel(filePath, sheetName);

        for (String[] row : excelData) {
            String username1 = row[3];
            String password = row[1];

            reusableMethod.sendKeysToElement(loginPage.emailTextField, username1);
            reusableMethod.sendKeysToElement(loginPage.passwordTextField, password);
        }
    }

    @And("Click on the Register option")
    public void clickOnTheRegisterOption() throws InterruptedException {
//    AccountOpenObjectPage.getRegisterOption().click();
        reusableMethod.clickElement(loginPage.registerOption);
    }

    @And("Click on the First Name text field and Insert the First Name")
    public void clickOnTheFirstNameTextFieldAndInsertTheFirstName() {
        reusableMethod.sendKeysToElement(loginPage.firstName, reusableMethod.generateRandomFirstName());
    }

    @And("Click on the Last Name text field and Insert the Last Name")
    public void clickOnTheLastNameTextFieldAndInsertTheLastName() {
        reusableMethod.sendKeysToElement(loginPage.lastName, reusableMethod.generateRandomFirstName());
    }

    @And("Click on the Email text field and Insert the Email")
    public void clickOnTheEmailTextFieldAndInsertTheEmail() {
        reusableMethod.sendKeysToElement(loginPage.email, reusableMethod.generateRandomGmail());
    }

    @And("Click on the Telephone text field and Insert the Telephone Number")
    public void clickOnTheTelephoneTextFieldAndInsertTheTelephoneNumber() {
        reusableMethod.sendKeysToElement(loginPage.telephone, reusableMethod.generateRandomPhoneNumber());
    }

    @And("Click on the Password text field and Insert the Password")
    public void clickOnThePasswordTextFieldAndInsertThePassword() {
        reusableMethod.sendKeysToElement(loginPage.password, "Abc123#");
    }

    @And("Click on the Confirm Password text field and Insert the Confirm Password")
    public void clickOnTheConfirmPasswordTextFieldAndInsertTheConfirmPassword() {
        reusableMethod.sendKeysToElement(loginPage.confirmPassword, "Abc123#");
    }

    @And("Click on the Privacy Checkbox")
    public void clickOnThePrivacyCheckbox() {
        reusableMethod.clickElement(loginPage.privacyCheckbox);

    }

    @And("Click on the Continue Button")
    public void clickOnTheContinueButton() {
        reusableMethod.clickElement(loginPage.continueButton);
    }

    @Then("Verify that the New Account Successfully Created")
    public void verifyThatTheNewAccountSuccessfullyCreated() throws InterruptedException {
        reusableMethod.isElementDisplayed(loginPage.accountCreated);
        reusableMethod.getTextOfElement(loginPage.accountCreated);
    }

    @When("User enter valid password")
    public void userEnterValidPassword() throws InterruptedException {
        Thread.sleep(2000);
        reusableMethod.clickElement(loginPage.passwordTextField);
        reusableMethod.sendKeysToElement(loginPage.passwordTextField,testData.PASSWORD);
    }
}
