
import org.openqa.selenium.*;

public class RentPageObject {

    WebDriver driver;
    //Констурктор класса
    public RentPageObject (WebDriver driver) {
        this.driver = driver;
    }
    //Локатор для поля Когда привезти самокат
    private final By rentalDateField = By.xpath("//input[@type='text' and @placeholder='* Когда привезти самокат']");


    // Локатор для поля "Аренды"
    private final By rentalTimeField = By.className("Dropdown-placeholder");

    // Локатор для списка сроков аренды
    private final By rentalTime = By.xpath(".//*[(@role ='option' and text()='двое суток')]");

    // Локатор цвета самоката "Чёрный жемчуг"
    private final By checkBoxColourBlackPearl = By.xpath(".//input[@id='black']");

    // Локатор цвета самоката  "Серая безысходность"
    private final By checkBoxColourGreyDespair = By.xpath(".//input[@id='grey']");

    // Локатор поля "Комментарий"
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Локатор кнопки "Заказать"
    private final By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");

    // Локатор кнопки "Нет" в окне "Хотите оформить заказ?"
    private final By orderButtonNo = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");

    // Локатор кнопки "ДА" в окне "Хотите оформить заказ?"
    private final By orderButtonYes = By.xpath("//button[text()='Да' and contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM')]");

    // Локатор кнопки "Статус" в окне "Хотите оформить заказ?"
    private final By orderButtonStatus = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM')]");

    // Окно "Заказ оформлен"
    public boolean orderAcceptance() {
        driver.findElement(By.xpath("//button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM')]"));

        return driver.findElement(orderButtonStatus).isDisplayed();
    }
    // Выбор даты доставки
    public RentPageObject rentalDate(String date) {
        driver.findElement(rentalDateField).sendKeys(date);
        driver.findElement(rentalDateField).sendKeys(Keys.ENTER);
        return this;
    }
    // Выбор срока аренды самоката
    public RentPageObject rentalTime() {
        driver.findElement(rentalTimeField).click();
        driver.findElement(rentalTime).click();
        return this;
    }
    // Выбор цвета самоката "Чёрный жемчуг"
    public RentPageObject clickCheckBoxColourBlackPearl() {
        driver.findElement(checkBoxColourBlackPearl).click();
        return this;
    }
    // Выбор цвета самоката "Серая безысходность"
    public RentPageObject clickCheckBoxColourGreyDespair() {
        driver.findElement(checkBoxColourGreyDespair).click();
        return this;
    }
    // Заполнение поля "Комментарий для курьера"
    public RentPageObject sendComment (String userComment) {
        driver.findElement(commentField).sendKeys(userComment);
        return this;
    }
    // Клик по кнопке "Заказать"
    public RentPageObject clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }
    // Клик на кнопку "ДА" в окне "Хотите оформить заказ?"
    public RentPageObject clickOrderButtonYes() {
        driver.findElement(orderButtonYes).click();
        return this;
    }
}
