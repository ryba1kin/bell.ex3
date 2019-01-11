package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketPage {
    private static final By BUTTON_REGION_OK = By.xpath(".//span[text()='Да, спасибо']/parent::span");
    public static final By COMPUTERS = By.xpath(".//div[contains(@class,'n-w-tab_interaction-active_yes')]//a[@title='Компьютеры']");
    public static final By NOTEBOOKS = By.xpath(".//div[contains(@class,'n-w-tab_interaction-active_yes')]//a[@title='Ноутбуки']");
    public static final By COMPUTER_TECHNICS = By.xpath(".//*[text()='Компьютерная техника']/parent::a");
    private WebDriver driver;

    public YandexMarketPage(WebDriver driver) {
        this.driver = driver;
        this.closeRegionSelect();
    }

    public void select(By selector) {
        Actions actions = new Actions(this.driver);
        actions.moveToElement(this.wait(COMPUTER_TECHNICS)).perform();
        this.wait(selector).click();
    }

    private void closeRegionSelect() {
        this.wait(BUTTON_REGION_OK).click();
    }

    private WebElement wait(By selector) {
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        return wait.until(driver  -> driver.findElement(selector));
    }
}
