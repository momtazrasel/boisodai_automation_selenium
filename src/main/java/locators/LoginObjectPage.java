package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginObjectPage {
    public static WebDriver driver;

    public By emailTextField = By.xpath("(//input[@id = 'phone-number'])[2]");
    public By passwordTextField = By.xpath("(//input[@class = 'bponi-i border bponi-yh bponi-w bponi-dr bponi-pb bponi-fqa bponi-hw bponi-gh bponi-mb bponi-rr bponi-sj bponi-tj bponi-uj bponi-zj bponi-ak bponi-tg'])");
    public  By continueButton = By.xpath("(//button[contains(text(), 'Continue')])[2]");
    public  By loginLink = By.xpath("(//a[@class = 'bponi-lp bponi-fe'])[1]");
    public  By loginHereLink = By.xpath("(//div[@class = 'page__content'])[1]");

}
