import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPageObject {
    private WebDriver driver;

    // Локатор поля "Имя"
    private final By FirstName = By.xpath(".//input[@placeholder='Имя']");

    // Локатор поля "Фамилия"
    private final By LastName = By.xpath(".//input[@placeholder='Фамилия']");

    // Локатор поля "Адрес: куда привезти заказ"
    private final By Address = By.xpath(".//input[@placeholder='Адрес: куда привезти заказ']");

    // Локатор поля "Станция метро"
    private By Station = By.xpath("//input[@placeholder='Станция метро']");
    private By StationSelector = By.xpath("//div[@class='select-search__select']//li");

    // Локатор поля "Телефон: на него позвонит курьер"
    private final By PhoneNumber = By.xpath(".//input[@placeholder='Телефон: на него позвонит курьер']");

    // Локатор кнопки "Далее"
    private final By ButtonNext = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    // Конструктор класса
    public OrderPageObject (WebDriver driver) {
        this.driver = driver;
    }

    // Методы для работы с элементами страницы заказа
    // Ввод имени клиента
    public OrderPageObject sendFirstName(String firstName) {
        driver.findElement(FirstName).sendKeys(firstName);
        return this;
    }
    // Ввод Фамилии
    public OrderPageObject sendLastName(String lastName) {
        driver.findElement(LastName).sendKeys(lastName);
        return this;
    }

    // Ввод адреса доставки
    public OrderPageObject sendAddress(String address) {
        driver.findElement(Address).sendKeys(address);
        return this;
    }

    // Выбор станции метро
    public OrderPageObject Station(String StationFromOrder) {
        driver.findElement(Station).click();
        driver.findElement(Station).sendKeys(StationFromOrder);
        driver.findElement(Station).sendKeys(Keys.DOWN,Keys.ENTER);
        return this;
    }

    // Ввод телефона
    public OrderPageObject sendPhoneNumber(String phoneNumber) {
        driver.findElement(PhoneNumber).sendKeys(phoneNumber);
        return this;
    }

    // Клик на кнопку далее
    public OrderPageObject clickButtonNext() {
        driver.findElement(ButtonNext).click();
        return this;
    }
}

