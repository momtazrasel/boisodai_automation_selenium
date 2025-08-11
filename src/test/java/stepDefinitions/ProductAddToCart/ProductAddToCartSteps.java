package stepDefinitions.ProductAddToCart;

import ReusableMethods.TestData;
import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import locators.ProductAddToCartObjects;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverSetup;

import java.time.Duration;

public class ProductAddToCartSteps {
    private WebDriver driver;
    private PageObjectManager reusableMethod;
    private TestData testData;
    private ProductAddToCartObjects product = new ProductAddToCartObjects();

    String phone = reusableMethod.getRandomPhoneNumber();
    String name = reusableMethod.getRandomName();
    String address = reusableMethod.getRandomAddress();

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
        String priceBeforeText = reusableMethod.getTextOfElement(product.productPrice)
                .replace("মোট", "")
                .replace("৳", "")
                .trim();
        int priceBefore = Integer.parseInt(priceBeforeText);
        System.out.println("Price before: " + priceBefore);

        reusableMethod.clickElement(product.plusIcon);

        // ✅ Step 3: Wait until price updates
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(driver1 -> {
            String updatedText = reusableMethod.getTextOfElement(product.productPrice)
                    .replace("মোট", "")
                    .replace("৳", "")
                    .trim();
            return !updatedText.equals(priceBeforeText);
        });

        // ✅ Step 4: Get price after
        String priceAfterText = reusableMethod.getTextOfElement(product.productPrice)
                .replace("মোট", "")
                .replace("৳", "")
                .trim();
        int priceAfter = Integer.parseInt(priceAfterText);
        System.out.println("Price after: " + priceAfter);

        // ✅ Step 5: Assert price increased
        Assert.assertTrue(priceAfter > priceBefore, "Price did not increase after clicking '+' icon");

    }

    @And("Enter the valid address")
    public void enterTheValidAddress() throws InterruptedException {
        reusableMethod.sendKeysToElement(product.phoneNo,phone);
        reusableMethod.sendKeysToElement(product.name,name);
        reusableMethod.sendKeysToElement(product.address,name);
        Thread.sleep(2000);
    }

    @And("Click on the Next Button")
    public void clickOnTheNextButton() throws InterruptedException {
        reusableMethod.clickElement(product.nextButton);
        Thread.sleep(2000);
    }

    @And("Select area and payment option")
    public void selectAreaAndPaymentOption() {
        reusableMethod.clickElement(product.area);
        reusableMethod.clickElement(product.paymentOption);

        String priceBeforeText = reusableMethod.getTextOfElement(product.productPrice)
                .replace("মোট", "")
                .replace("৳", "")
                .trim();
        int summaryPrice = Integer.parseInt(priceBeforeText);
        System.out.println("Price before: " + summaryPrice);
        // Get product total price (without delivery)
        String productTotalText = reusableMethod.getTextOfElement(product.productPrice)
                .replace("মোট", "")
                .replace("৳", "")
                .trim();
        double productTotal = Double.parseDouble(productTotalText);
        System.out.println("Price before: " + productTotal);

// Get delivery charge
        String deliveryChargeText = reusableMethod.getTextOfElement(product.deliveryCharge)
                .replace("৳", "")
                .trim();
        double deliveryCharge = Double.parseDouble(deliveryChargeText);
        System.out.println("Price before: " + deliveryCharge);

// Get final total (displayed in checkout)
        String finalTotalText = reusableMethod.getTextOfElement(product.finalTotal)
                .replace("৳", "")
                .trim();
        double finalTotal = Double.parseDouble(finalTotalText);
        System.out.println("Price before: " + finalTotal);

// Assert that product total + delivery charge = final total
        Assert.assertEquals(productTotal + deliveryCharge, finalTotal,
                "Total amount mismatch! Expected: " + (productTotal + deliveryCharge) + " but found: " + finalTotal);


    }
}
