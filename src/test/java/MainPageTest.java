
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

// Соответвие тексту в выподающем списке
@RunWith(Parameterized.class)

public class MainPageTest  {
    private WebDriver driver;
    private final String questionLocator;
    private final String answerLocator;
    private final String answerText;

    // Конструктор классов
    public MainPageTest(WebDriver driver,String questionLocator, String answerLocator, String answerText) {
        this.driver = driver;
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.answerText = answerText;
    }

    // Массив ОР ответы
    @Parameterized.Parameters
    public static Object[][] expectedAnswersParametersList() {
        return new Object[][]{
                {new ChromeDriver(),"accordion__heading-0", "accordion__panel-0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {new ChromeDriver(),"accordion__heading-1", "accordion__panel-1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {new ChromeDriver(),"accordion__heading-2", "accordion__panel-2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {new ChromeDriver(),"accordion__heading-3", "accordion__panel-3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {new ChromeDriver(),"accordion__heading-4", "accordion__panel-4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {new ChromeDriver(),"accordion__heading-5", "accordion__panel-5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {new ChromeDriver(),"accordion__heading-6", "accordion__panel-6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {new ChromeDriver(),"accordion__heading-7", "accordion__panel-7", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void DropDownListTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPageObject objMainPageObject = new MainPageObject(driver);
        objMainPageObject.scrollPageToEndOfList();
        objMainPageObject.clickQuestionButtonNext(questionLocator);

        String ActualAnswerText = driver.findElement(By.id(answerLocator)).getText();
        assertEquals("Выведенный текст не соответствует заявленному", answerText, ActualAnswerText);
    }
    @After
    public void tearDown() {
            driver.quit();
    }

}
