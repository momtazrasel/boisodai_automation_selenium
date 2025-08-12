package ReusableMethods;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TestData {
    private WebDriver driver;

    public TestData(WebDriver driver){
        this.driver = driver;
    }

    public static final String USERNAME = "";
    public static final String PASSWORD = "";

    public static final List<String> EXPECTED_MENUS = Arrays.asList(
            "Dashboard",
            "My Order",
            "Membership",
            "Wholesale",
            "Affiliate",
            "Wishlist",
            "Profile",
            "Password",
            "Log Out"
    );
}
