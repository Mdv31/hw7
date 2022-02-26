package pages;

import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/** Страница создания тикета */
public class CreateTicketPage extends HelpdeskBasePage {

    // Способ объявления элементы страницы, через аннотацию
   /* @FindBy(xpath = "")
    private WebElement inputProblemTitle;*/
    // todo: остальные элементы
    static WebElement ticketQueue = driver.findElement(By.id("id_queue"));
    static Select selectTicketQueue = new Select(ticketQueue);
    static WebElement ticketTitle = driver.findElement(By.id("id_title"));
    static WebElement ticketBody = driver.findElement(By.id("id_body"));
    static WebElement ticketPriority = driver.findElement(By.id("id_priority"));
    static Select selectTicketPriority = new Select(ticketPriority);
    static WebElement ticketDueDate = driver.findElement(By.id("id_due_date"));
    static WebElement ticketSubEmail = driver.findElement(By.id("id_submitter_email"));
    public static WebElement ticketBtn = driver.findElement(By.cssSelector("#content-wrapper > div > div > div > div.card-body > form > button"));


    public CreateTicketPage() {
        // Необходимо инициализировать элементы класса, лучше всего это делать в конструкторе
        PageFactory.initElements(driver, this);


    }

    /** Создание тикета */
    public static void createTicket(Ticket ticket) {
        //setProblemTitle(ticket.getTitle());
        // todo: заполнение остальных полей
        selectTicketQueue.selectByIndex(ticket.getQueue());
        ticketTitle.sendKeys(ticket.getTitle());
        ticketBody.sendKeys(ticket.getTitle());
        selectTicketPriority.selectByIndex(ticket.getPriority());
        ticketDueDate.sendKeys(ticket.getDue_date());
        ticketSubEmail.sendKeys(ticket.getSubmitter_email());

        createTicket();
    }

    /** Заполнение поля "Summary of the problem" */
    public void setProblemTitle(String text) {
        // todo: заполнить поле

    }

    // todo: методы заполнения остальных полей

    /** Зажатие кнопки "Submit Ticket" */
    public static void createTicket() {
        // todo: нажать кнопку создания задания
        ticketBtn.click();
    }

}
