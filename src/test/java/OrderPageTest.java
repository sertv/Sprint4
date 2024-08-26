import io.github.bonigarcia.wdm.WebDriverManager;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class OrderPageTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Проверка на корректное заполнение полей
    @Test
    public void openMainPage() throws Exception {
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderPageObject objOrderPageObject = new OrderPageObject(driver);

        objOrderPageObject.sendFirstName("Сергей");
        objOrderPageObject.sendLastName("Тверденко");
        objOrderPageObject.sendAddress("Сантк-Петербург Большая монетная улица 45");
        objOrderPageObject.stationSelect("Черкизовская");
        objOrderPageObject.sendPhoneNumber("+79529999999");
        objOrderPageObject.clickButtonNext();

    }
    //Проверка на вывод ошибок при некорректном заполнении полей
    @Test
    public void incorrectOpenMainPage() throws Exception {
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderPageObject objOrderPageObject = new OrderPageObject(driver);

        objOrderPageObject.sendFirstName("123");

        objOrderPageObject.sendLastName("222");
        objOrderPageObject.sendAddress("32123");
        objOrderPageObject.stationSelect("Тверская");
        objOrderPageObject.sendPhoneNumber("4343423");
        objOrderPageObject.clickButtonNext();


        Thread.sleep(10_000);

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
