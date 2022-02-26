package elements;

import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CreateTicketPage;
import pages.LoginPage;
import pages.TicketsPage;

/** Элемент главного меню */
public class MainMenu {

    private WebDriver driver;

    // Поиск элементов без аннотации
    //private WebElement newTicketBtn = driver.findElement(By.xpath(""));

    // todo: остальные элементы меню

    public MainMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void newTicket() {
        // todo: нажать кнопку создания нового тикета
        CreateTicketPage.ticketBtn.click();
    }

    public void logIn() {
        // todo: нажать кнопку авторизации
       LoginPage.loginBtn.click();
    }

    public void searchTicket(Ticket ticket) {
        setSearch(ticket.getTitle())
                .search();
    }

    /* Если после вызова void метода, может потребоваться вызов другого метода этого же класса,
        то можно вернуть сам класс и вызвать следующий метод через точку. */
    public MainMenu setSearch(String text) {
        // todo: ввести значение в поле поиска
        TicketsPage.ticketsSearchQuery.sendKeys(text);

        return this;
    }

    public void search() {
        // todo: нажать кнопку поиска
        TicketsPage.ticketsGoBtn.click();
    }

}
