
import org.openqa.selenium.*;

public class RentPageObject {

    WebDriver driver;
    private final By rentalDateField = By.xpath(".//input[@placeholder='Когда привезти самокат']");
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
    // Локатор кнопки "ДА" в окне "Хотите оформить заказ?"
    private final By orderButtonYes = By.xpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
    // Окно "Заказ оформлен"
    public boolean isModalOrderWindowDisplayed() {
        return driver.findElement(orderButtonYes).isDisplayed();
    }
    // Конструктор класса
    public RentPageObject (WebDriver driver) {
        this.driver = driver;
    }
    // Выбор даты доставки
    public RentPageObject sendRentalDate(String date) {
        driver.findElement(rentalDateField).sendKeys(date);
        driver.findElement(rentalDateField).sendKeys(Keys.ENTER);
        return this;
    }

    // Выбор срока аренды самоката
    public RentPageObject setRentalTime() {
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
    public static class MainPageObject {
        public MainPageObject (WebDriver driver) {
            MainPageObject.driver = driver;
        }
        private static WebDriver driver;
        // Локатор кнопки "Да все привыкли" в окне куки
        private final By cookieButton = By.id("rcc-confirm-button");
        // Локатор кнопки "Заказа" в шапке
        private By headerOrderButton = By.className("Button_Button__ra12g");
        // Локатор кнопки "Заказа" расположенной на сайте и выровнена по середине
        private By middleOrderButton = By.className("Button_Middle__1CSJM");
        // Локаторы кнопок с вопросами
        private static final String[] DropDownQuestionsArray = new String[]{
                "accordion__heading-0", "accordion__heading-1", "accordion__heading-2", "accordion__heading-3", "accordion__heading-4", "accordion__heading-5", "accordion__heading-6", "accordion__heading-7"};
        // Локаторы кнопок панелей с текстом
        private static final String[] DropDownAnswersArray = new String[]{
                "accordion__panel-0", "accordion__panel-1", "accordion__panel-2", "accordion__panel-3", "accordion__panel-4", "accordion__panel-5", "accordion__panel-6", "accordion__panel-7"};
        // Открытие страницы
        public final MainPageObject openSite() {
            driver.get("https://qa-scooter.praktikum-services.ru/");
            return this;
        }
        // Клик по кнопке "Да все привыкли" в окне куки
        public MainPageObject clickCookieButton() {
            driver.findElement(cookieButton).click();
            return this;
        }
        // Локатор кнопки "Заказа" в шапке
        public MainPageObject clickHeaderOrderButton() {
            driver.findElement(headerOrderButton).click();
            return this;
        }
        // Клик по кнопке "Заказа" расположенной на сайте и выровнена по середине
        public MainPageObject clickMiddleOrderButton() {
            driver.findElement(middleOrderButton).click();
            return this;
        }
        // Скролл главной страницы до конца
        public MainPageObject scrollPageToEndOfList() {
            WebElement lastQuestionArrow = driver.findElement(By.id(DropDownQuestionsArray[7]));
            ((JavascriptExecutor) driver).executeScript ("arguments[0].scrollIntoView()",lastQuestionArrow);
            return this;
        }
    }
}
