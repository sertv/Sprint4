import org.openqa.selenium.*;

public class OrderPageObject {
    private WebDriver driver;

    // Локатор поля "Имя"
    private final By firstNameInput = By.xpath(".//input[@placeholder='* Имя']");

    // Локатор поля "Фамилия"
    private final By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");

    // Локатор поля "Адрес: куда привезти заказ"
    private final By addressToDelivery = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Локатор поля "Станция метро"
    private final By metroStation = By.xpath("//input[@placeholder='* Станция метро']");


    // Локатор поля "Телефон: на него позвонит курьер"
    private final By phoneNumberInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Локатор кнопки "Далее"
    private final By buttonNext = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    // Конструктор класса
    public OrderPageObject (WebDriver driver) {
        this.driver = driver;
    }

    // Методы для работы с элементами страницы заказа
    // Ввод имени клиента
    public OrderPageObject sendFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }
    // Ввод Фамилии
    public OrderPageObject sendLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    // Ввод адреса доставки
    public OrderPageObject sendAddress(String address) {
        driver.findElement(addressToDelivery).sendKeys(address);
        return this;
    }

    // Выбор станции метро
    public OrderPageObject stationSelect (String stationFromOrder) {
        driver.findElement(metroStation).click();
        driver.findElement(metroStation).sendKeys(stationFromOrder);
        driver.findElement(metroStation).sendKeys(Keys.DOWN,Keys.ENTER);
        return this;
    }

    // Ввод телефона
    public OrderPageObject sendPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
        return this;
    }

    // Клик на кнопку далее
    public OrderPageObject clickButtonNext() {
        driver.findElement(buttonNext).click();
        return this;
    }
    //Вывод ошибки после заполнения имени
    public boolean isErrorSendFirstName() {
        By locator = By.xpath("//div[contains(@class, 'Input_ErrorMessage__3HvIb') and contains(@class, 'Input_Visible___syz6') and text()='Введите корректное имя']");
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            // Если элемент не найден, возвращаем false
            return false;
        }

    }
    //Вывод ошибки после заполнения фамилии
    public boolean isErrorSendLastName() {


        By locator = By.xpath("//div[contains(@class, 'Input_ErrorMessage__3HvIb') and contains(@class, 'Input_Visible___syz6') and text()='Введите корректную фамилию']");
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            // Если элемент не найден, возвращаем false
            return false;
        }
    }
    //Вывод ошибки после заполнения номера телефона
    public boolean isErrorSendPhoneNumber() {

        By locator = By.xpath("//div[contains(@class, 'Input_ErrorMessage__3HvIb') and contains(@class, 'Input_Visible___syz6') and text()='Введите корректный номер']");
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            // Если элемент не найден, возвращаем false
            return false;
        }
    }
    //Нажатие на текст страницы, чтобы обновлись ошибки
    public void stationSelect () {
        By locator = By.className("Order_Header__BZXOb");
        driver.findElement(locator).click();

    }


}

