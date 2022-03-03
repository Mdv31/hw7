package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/** Страница авторизации */
public class LoginPage extends HelpdeskBasePage {

    // todo: элементы страницы

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    static WebElement loginUsername = driver.findElement(By.id("username"));
    static WebElement loginPassword = driver.findElement(By.id("password"));
    public static WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/input[1]"));
    /**
     * Авторизация пользователя
     *
     * @param user     логин пользователя
     * @param password пароль пользователя
     */
    @Step("Заполнение формы логина")
    public static void login(String user, String password) {
        // todo: заполнить поля и нажать кнопку авторизации
        loginUsername.sendKeys(user);
        loginPassword.sendKeys(password);
        takeScreenshotByAllure(driver);
        loginBtn.click();
    }

    // todo: методы работы с элементами

}
