package stepDefinitions.Profile;

import ReusableMethods.TestData;
import base.PageObjectManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.ProductAddToCartObjects;
import locators.ProfileObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DriverSetup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProfileSteps {
    private WebDriver driver;
    private PageObjectManager reusableMethod;
    private TestData testData;
    private ProfileObjects profile = new ProfileObjects();

    public ProfileSteps(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.reusableMethod = new PageObjectManager(driver);
        this.testData = new TestData(driver);

    }

    @When("Click on the Profile icon")
    public void click_on_the_profile_icon() throws InterruptedException {
        reusableMethod.clickElement(profile.profileIcon);
        Thread.sleep(2000);
    }

    @Then("All the menu is available")
    public void all_the_menu_is_available() {
        // Find all menu items inside the container
        WebElement menuNav = driver.findElement(profile.menuContainer);
        List<WebElement> menuItems = menuNav.findElements(By.tagName("a")); // assuming menu links are <a> tags
        //Print menu list
        for (WebElement menu : menuItems) {
            System.out.println(menu.getText().trim());
        }

        // Expected menu names
//        List<String> expectedMenus = Arrays.asList("Dashboard", "My Order", "Membership", "Wholesale", "Affiliate", "Wishlist", "Profile", "Password", "Log Out");

        // Extract menu text
        List<String> actualMenus = menuItems.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

        // Assert
        Assert.assertEquals(actualMenus, testData.EXPECTED_MENUS, "Menu items do not match!");

//        for (int i = 0; i < menuItems.size(); i++) {
//            // Re-fetch elements each time to avoid StaleElementReferenceException
//            menuItems = driver.findElements(By.tagName("a"));
//
//            WebElement menu = menuItems.get(i);
//            System.out.println("Clicking menu: " + menu.getText().trim());
//            menu.click();
//
//            // Optional: Verify the page loaded or perform an assertion here
//
//            // Go back to menu page if needed before clicking next
////            driver.navigate().back();
//
//        }

        for (WebElement menu : menuItems) {
            if (menu.getText().trim().equalsIgnoreCase("My Order")) {
                menu.click();
                break;
            }
        }
    }}
