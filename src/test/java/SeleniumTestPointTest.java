/**
 * 1. Создать класс, который будет инициализировать web driver  и переходить на страницу
 * 2. Открыть браузер Chrome и развернуть на весь экран.
 * 3. Зайти на yandex.ru
 * 4. Перейти в яндекс маркет
 * 5. Выбрать раздел Компьютеры
 * 6. Выбрать раздел Ноутбуки
 * 7. Реализуем в нем переходы с применением неявных ожиданий
 */

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.YandexMarketPage;
import pages.YandexSearchPage;


import static java.util.concurrent.TimeUnit.SECONDS;

@RunWith(JUnit4.class)
public class SeleniumTestPointTest {
    private WebDriver driver;
    @Before
    public void tearsUp() {
        System.setProperty("webdriver.chrome.driver", "E:/_drivers_for_programming/chromedriver.exe");
         // 2. Открыть браузер Chrome и развернуть на весь экран.
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(50, SECONDS);
    }

    @After
    public void tearsDown() {
        this.driver.quit();
    }

    @Test
    public void runTest() {
        //3. Зайти на yandex.ru
        YandexSearchPage searchPage = new YandexSearchPage(this.driver);
        searchPage.maximize();
        searchPage.gotoYandex();
        //4. Перейти в яндекс маркет
        YandexMarketPage marketPage = searchPage.gotoMarket();
        //5. Выбрать раздел Компьютеры
        marketPage.select(marketPage.COMPUTERS);
        //6. Выбрать раздел Ноутбуки
        marketPage.select(marketPage.NOTEBOOKS);
        //7. Реализуем в нем переходы с применением неявных ожиданий
        // TODO не работает, несмотря на вроде бы нормальную инициализацию chromedriver
    }
}
