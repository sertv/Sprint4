import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MainPageObject {

    public MainPageObject (WebDriver driver) {
        MainPageObject.driver = driver;
    }

    private static WebDriver driver;

    //Локатор кнопки "Cамокат"
    private final By scooterButton = By.className("Header_LogoScooter__3lsAR");

    // Локатор кнопки "Да все привыкли" в окне куки
    private final By cookieButton = By.id("rcc-confirm-button");

    // Локатор кнопки "Заказа" в шапке
    private By headerOrderButton = By.className("Button_Button__ra12g");

    // Локатор кнопки "Заказа" расположенной на сайте и выровнена по середине
    private By middleOrderButton = By.xpath("//button[text()='Заказать' and contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_UltraBig__UU3Lp')]\n");

    // Локаторы кнопок с вопросами
     static final String[] dropDownQuestionsArray = new String[]{
            "accordion__heading-0", "accordion__heading-1", "accordion__heading-2", "accordion__heading-3", "accordion__heading-4", "accordion__heading-5", "accordion__heading-6", "accordion__heading-7"};

    // Локаторы кнопок панелей с текстом
    private static final String[] dropDownAnswersArray = new String[]{
            "accordion__panel-0", "accordion__panel-1", "accordion__panel-2", "accordion__panel-3", "accordion__panel-4", "accordion__panel-5", "accordion__panel-6", "accordion__panel-7"};

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
        WebElement lastQuestionArrow = driver.findElement(By.id(dropDownQuestionsArray[7]));
        ((JavascriptExecutor) driver).executeScript ("arguments[0].scrollIntoView();", lastQuestionArrow);
        return this;
    }

    // Клик по стрелке выпадающего списка "Вопросы о важном"
    public static void clickQuestionArrow(int questionNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id(dropDownQuestionsArray[questionNumber])));
        driver.findElement(By.id(dropDownQuestionsArray[questionNumber])).click();
    }

    // Проверка текста на орфографию и контекст
    public static void checkTextInOpenPanel(String expectedText, int answerNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(dropDownAnswersArray[answerNumber])));
        String answerText = driver.findElement (By.id(dropDownAnswersArray[answerNumber])).getText();
        assertEquals(expectedText, answerText);
    }
    // Клик по вопросам
    public MainPageObject clickQuestionButtonNext (String questionButtonLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
        return this;
    }
}
