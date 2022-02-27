package web;

import models.Ticket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

public class HelpdeskUITest {

    private WebDriver driver;
    private Ticket ticket;

    @BeforeClass
    public void setup() throws IOException {
        // Читаем конфигурационные файлы в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() throws InterruptedException {
        // Заполняем объект класс Ticket необходимыми тестовыми данными
        ticket = buildNewTicket();


        // todo: открыть главную страницу
        driver.get("https://at-sandbox.workbench.lanit.ru/");
        // todo: создать объект главной страницы и выполнить шаги по созданию тикета
        MainPage.newTicket();
        CreateTicketPage.createTicket(ticket);
        // todo: перейти к странице авторизации и выполнить вход
        driver.get("https://at-sandbox.workbench.lanit.ru/login/");
        LoginPage.login("admin", "adminat");
        // todo: найти созданный тикет и проверить поля
        TicketsPage.openTicket(ticket);

        boolean flag= Objects.equals(ticket.getSubmitter_email(), TicketPage.getEmail()) &&
                Objects.equals(ticket.getTitle(), TicketPage.getTitle())&&
                TicketPage.getDue_date().contains(ticket.getDue_date());

        Assert.assertTrue(flag);

        // Закрываем текущее окно браузера
        //driver.close();
    }

    /**
     * Создаём и заполняем объект тикета
     *
     * @return заполненный объект тикета
     */
    protected Ticket buildNewTicket() {
        Ticket ticket = new Ticket();

        ticket.setTitle(ticket.getTitle());
        // todo: заполнить остальные необходимые поля тикета

        return ticket;
    }

    @AfterTest
    public void close() {
        // Закрываем все окна браузера и освобождаем ресурсы
        driver.quit();
    }

}
