
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.Assert.assertEquals;


public class OrderSamokat  {
    private WebDriver driver;

    @Before
    public void startUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }
    // Заказ самоката, через расположенную кнопка в шапке
    @Test
    public void samokatOrderHeaderOrderButton() throws InterruptedException {

        // перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPageObject objectOrder = new MainPageObject (driver);
        objectOrder.clickHeaderOrderButton();
        OrderPageObject objectSamokatOrder = new OrderPageObject(driver);
        objectSamokatOrder.sendFirstName("Сергей");
        objectSamokatOrder.sendLastName("Тверденко");
        objectSamokatOrder.sendAddress("Санкт-Петерубруг, улица бассейная");
        objectSamokatOrder.stationSelect("Университет");
        objectSamokatOrder.sendPhoneNumber("79529999999");
        objectSamokatOrder.clickButtonNext();
        RentPageObject objRent = new RentPageObject(driver);
        objRent.rentalDate("31.08.2024");
        objRent.rentalTime();
        objRent.clickCheckBoxColourBlackPearl();
        objRent.sendComment ("Привет");
        objRent.clickOrderButton();
        objRent.clickOrderButtonYes();
        objRent.orderAcceptance();

        assertEquals("Заказ не создан", true, objRent.orderAcceptance() );

    }
    // Заказ самоката, расположенная кнопка по середине страницы
    @Test
    public void samokatOrderMiddleOrderButton() throws InterruptedException {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPageObject objectOrder = new MainPageObject(driver);
        objectOrder.scrollPageToEndOfList();
        objectOrder.clickMiddleOrderButton();
        OrderPageObject objectSamokatOrder = new OrderPageObject(driver);
        objectSamokatOrder.sendFirstName("Сергей");
        objectSamokatOrder.sendLastName("Тверденко");
        objectSamokatOrder.sendAddress("Санкт-Петерубруг, улица бассейная");
        objectSamokatOrder.stationSelect("Университет");
        objectSamokatOrder.sendPhoneNumber("79529999999");
        objectSamokatOrder.clickButtonNext();
        RentPageObject objRent = new RentPageObject(driver);
        objRent.rentalDate("30.08.2024");
        objRent.rentalTime();
        objRent.clickCheckBoxColourGreyDespair();
        objRent.sendComment ("Привет");
        objRent.clickOrderButton();
        objRent.clickOrderButtonYes();
        objRent.orderAcceptance();
        assertEquals("Заказ не создан", true, objRent.orderAcceptance() );
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
