package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductAddToCartObjects {
    public static WebDriver driver;

    public By firstBook = By.xpath("(//div[@class='bponi-ms bponi-i flex bponi-y bponi-fc'])[1]");
    public By addCartButton = By.xpath("(//button[@class='bponi-af bponi-xd bponi-rf bponi-gg rounded bponi-ek bponi-i flex bponi-y bponi-fc'])[1]");
    public By cartIcon = By.xpath("//a[@class='flex bponi-y bponi-mca']//*[name()='svg']");
    public By cartCount = By.xpath("//span[@class='flex absolute bponi-em bponi-ha bponi-xd bponi-bx bponi-ee bponi-dta bponi-eta bponi-y bponi-fc bponi-ze']");
    public By productPrice = By.xpath("(//span[@class='bponi-uf'])[1]"); // change as needed
    public By plusIcon = By.xpath("//div[@class='bponi-lq']//button[2]//*[name()='svg']"); // or class/xpath for [+]
    public By phoneNo = By.xpath("(//input[@id='phone-number'])[1]");
    public By name = By.xpath("(//input[@id='name'])[1]");
    public By address = By.xpath("(//textarea[@id='address'])[1]");
    public By nextButton = By.xpath("(//button[contains(text(),'এগিয়ে যান')])[1]");
    public By area = By.xpath("(//div[@id='headlessui-radiogroup-option-42'])[1]");
    public By paymentOption = By.xpath("(//div[@class='bponi-da flex bponi-hd bponi-i'])[2]");
    public By deliveryCharge = By.xpath("(//p[@class='bponi-ry'])[1]");
    public By finalTotal = By.xpath("(//span[@class='bponi-uf'])[2]");

}
