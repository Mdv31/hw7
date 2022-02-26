package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/** Главная страница */
public class MainPage extends HelpdeskBasePage {

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    static WebElement newTicket = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/ul/li[2]/a"));

    public static void newTicket() {
        newTicket.click();
    }
}
