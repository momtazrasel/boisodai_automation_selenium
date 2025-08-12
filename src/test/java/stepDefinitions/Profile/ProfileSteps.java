package stepDefinitions.Profile;

import ReusableMethods.TestData;
import base.PageObjectManager;
import io.cucumber.java.en.When;
import locators.ProductAddToCartObjects;
import locators.ProfileObjects;
import org.openqa.selenium.WebDriver;
import utils.DriverSetup;

public class ProfileSteps {
    private WebDriver driver;
    private PageObjectManager reusableMethod;
    private TestData testData;
    private ProfileObjects profile = new ProfileObjects();

    public ProfileSteps(DriverSetup driverSetup){
        this.driver = driverSetup.driver;
        this.reusableMethod = new PageObjectManager(driver);
        this.testData = new TestData(driver);

    }

    @When("Click on the Profile icon")
    public void click_on_the_profile_icon() throws InterruptedException {
      reusableMethod.clickElement(profile.profileIcon);
      Thread.sleep(2000);
    }
}
