package stepDefinitions.Login;

import ReusableMethods.TestData;
import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import locators.LoginObjectPage;
import org.openqa.selenium.WebDriver;
import utils.DriverSetup;

import java.io.IOException;

public class LoginSteps {
    private WebDriver driver;
    private PageObjectManager reusableMethod;
    private TestData testData;
    private LoginObjectPage loginPage = new LoginObjectPage();

    public LoginSteps(DriverSetup driverSetup) {
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

    @When("Click on the login link")
    public void clickOnTheLoginLink() throws InterruptedException {
        reusableMethod.waitUntilElementIsVisible(loginPage.loginLink);
        reusableMethod.clickElement(loginPage.loginLink);
        reusableMethod.clickElement(loginPage.loginHereLink);
        Thread.sleep(2000);

    }

    @And("Click on the Continue Button")
    public void clickOnTheContinueButton() {
        reusableMethod.clickElement(loginPage.continueButton);
    }

    @When("User enter valid password")
    public void userEnterValidPassword() throws InterruptedException {
        Thread.sleep(2000);
        reusableMethod.clickElement(loginPage.passwordTextField);
        reusableMethod.sendKeysToElement(loginPage.passwordTextField,testData.PASSWORD);
    }


}
