package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница отдельного тикета */
public class TicketPage extends HelpdeskBasePage {

    @FindBy(xpath = "")
    WebElement ticketTitle;

    // todo: остальные поля тикета

    @FindBy(xpath = "//th[text()='Submitter E-Mail']")
    WebElement email;

    public TicketPage() {
        PageFactory.initElements(driver, this);
    }

    /** Получить имя тикета */
    public String getTicketTitle() {
        return ticketTitle.getText();
    }

    /** Получить адрес почты */
    public static String getEmail() {
        return driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div[1]/div/div/table/tbody/tr[2]/td[2]")).getText();
    }

    public static String getDue_date() {
        return driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div[1]/div/div/table/tbody/tr[1]/td[1]")).getText();
    }

    public static String getTitle() {
        return driver.findElement(By.xpath("//*[@id=\"ticket-description\"]/p")).getText();
    }

    // todo: остальные методы получения значений полей

    /**
     * Получить значение элемента таблицы
     *
     * @param columnElem элемент ячейки для которой нужно вернуть значение
     * @return текстовое значение ячейки рядом
     */
    private static String getValue(WebElement columnElem) {
        return columnElem
                // Находи следующий элемент находящийся в том же теге
                .findElement(By.xpath("./following-sibling::td[1]"))
                // Получаем текст
                .getText()
                // Обрезаем лишние пробелы
                .trim();
    }

}
