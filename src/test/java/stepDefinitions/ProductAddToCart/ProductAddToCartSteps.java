package stepDefinitions.ProductAddToCart;

import ReusableMethods.TestData;
import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import locators.ProductAddToCartObjects;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

public class ProductAddToCartSteps {
    private WebDriver driver;
    private PageObjectManager reusableMethod;
    private TestData testData;
    private ProductAddToCartObjects product = new ProductAddToCartObjects();

    public ProductAddToCartSteps(DriverSetup driverSetup){
        this.driver = driverSetup.driver;
        this.reusableMethod = new PageObjectManager(driver);
        this.testData = new TestData(driver);
    }


    @When("Click on the any book")
    public void clickOnTheAnyBook() throws InterruptedException {
        reusableMethod.performMouseHover(driver,product.firstBook);
        reusableMethod.clickElement(product.firstBook);
        Thread.sleep(2000);
    }

    @And("Click on the add cart button")
    public void clickOnTheAddCartButton() {
        String test = reusableMethod.getTextOfElement(product.cartCount).trim();
        System.out.println("Cart Count Before Add: " + test);
        Assert.assertFalse(test.isEmpty(), "Cart count is empty — check locator!");

        int cartCountBefore = Integer.parseInt(test);
        Assert.assertEquals(cartCountBefore, 0, "Cart is not empty initially");
        reusableMethod.clickElement(product.addCartButton);
    }

    @And("Click on the cart icon")
    public void clickOnTheCartIcon() throws InterruptedException {
        reusableMethod.clickElement(product.cartIcon);
        Thread.sleep(2000);
        String test = reusableMethod.getTextOfElement(product.cartCount).trim();
        System.out.println("Cart Count After Add: " + test);
        Assert.assertNotEquals(test, "0", "Cart value did not change after adding product");

    }

    @And("Increase or decrease the product by clicking the plus or minus icon")
    public void increaseOrDecreaseTheProductByClickingThePlusOrMinusIcon() {
    }
}
