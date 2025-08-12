package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileObjects {
    public static WebDriver driver;

    public By profileIcon = By.xpath("(//a[@class='flex bponi-y border bponi-md bponi-rf bponi-fj bponi-a shadow bponi-k bponi-gsa'])[1]");
    public By menuContainer = By.xpath("(//nav[@class='hidden bponi-j text-13px text-dark-900 bponi-yf'])[1]");


}
