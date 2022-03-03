package pages;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/** Страница со списком тикетов */
public class TicketsPage extends HelpdeskBasePage {

    // todo: элементы страницы поиска тикетов
    public static WebElement ticketsSearchQuery = driver.findElement(By.id("search_query"));
    public static WebElement ticketsGoBtn = driver.findElement(By.cssSelector("#searchform > div > div > button"));


    public TicketsPage() {
        PageFactory.initElements(driver, this);
    }

    /** Ищем строку с тикетом и нажимаем на нее */
    @Step("Ищем строку с тикетом и нажимаем на нее")
    public static void openTicket(Ticket ticket) {
        // todo: найти и открыть тикет
        ticketsSearchQuery.sendKeys(ticket.getTitle());
        ticketsGoBtn.click();
        WebElement ticketSearchQuerySort = driver.findElement(By.xpath("//*[@id=\"ticketTable\"]/thead/tr/th[4]"));
        ticketSearchQuerySort.click();
        ticketSearchQuerySort.click();
        WebElement ticketSearchQuery = driver.findElement(By.xpath("//*[@id=\"ticketTable\"]/tbody/tr[1]/td[2]/div/a"));
        ticketSearchQuery.click();
        takeScreenshotByAllure(driver);
    }

}
