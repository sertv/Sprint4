import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderParametrizedTest {
    private WebDriver driver;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final boolean isErrorFirstName;
    private final boolean isErrorLastName;
    private final boolean isErrorphoneNumber;

    public OrderParametrizedTest(WebDriver driver, String firstName, String lastName, String phoneNumber, boolean isErrorFirstName, boolean isErrorLastName, boolean isErrorphoneNumber) {
        this.driver = driver;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.isErrorFirstName = isErrorFirstName;
        this.isErrorLastName = isErrorLastName;
        this.isErrorphoneNumber = isErrorphoneNumber;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { new ChromeDriver(), "Сергей", "Тверденко", "+79529999999", false,false,false},
                { new ChromeDriver(), "123", "222", "+79529999999", true,true,false},
                { new ChromeDriver(), "Сергей", "Тверденко", "43434", false,false,true},


        };
    }
    @Test
    public void checkIsCorrectInputs() throws InterruptedException {
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderPageObject objOrderPageObject = new OrderPageObject(driver);

        objOrderPageObject.sendFirstName(firstName);
        objOrderPageObject.sendLastName(lastName);
        objOrderPageObject.sendPhoneNumber(phoneNumber);
        objOrderPageObject.stationSelect();
        boolean resultIsErrorFirstName = objOrderPageObject.isErrorSendFirstName();
        boolean resultIsErrorLastName = objOrderPageObject.isErrorSendFirstName();
        boolean resultIsErrorPhoneNumber = objOrderPageObject.isErrorSendPhoneNumber();

        // Сравни полученный и ожидаемый результаты, не забудь про сообщение об ошибке
        assertEquals("Проверьте вывод ошибки в поле Имени", isErrorFirstName, resultIsErrorFirstName);
        assertEquals("Проверьте вывод ошибки в поле Фамилии", isErrorFirstName, resultIsErrorLastName);
        assertEquals("Проверьте вывод ошибки в поле Телефона", isErrorphoneNumber, resultIsErrorPhoneNumber);


    }
    @After
    public void tearDown() {
        driver.quit();
    }

    }

