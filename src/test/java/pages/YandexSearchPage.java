package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexSearchPage {
    private static final String YANDEX_URL = "http://www.yandex.ru";
    private static final String ERROR_NOT_YANDEX_PAGE = "Это не страница Яндекс поиск!";


    private static By searchArea = By.cssSelector(".input__control.input__input");
    private static By searchButton = By.cssSelector("[type=\"submit\"]");
    private static By marketLocation = By.cssSelector("[data-id=\"market\"]");

    private WebDriver driver;


    public YandexSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCurrentPage() {
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        WebElement search =  wait.until(driver  -> driver.findElement(searchArea));
        return search.isDisplayed() &&
                this.driver.findElement(searchButton).isDisplayed();
    }

    public void gotoYandex() {
        this.driver.navigate().to(YANDEX_URL);
        Assert.assertTrue(ERROR_NOT_YANDEX_PAGE, isCurrentPage());
    }

    public void maximize() {
        this.driver.manage().window().maximize();
    }

    public YandexMarketPage gotoMarket() {
        this.driver.findElement(marketLocation).click();
        return new YandexMarketPage(this.driver);
    }
}
