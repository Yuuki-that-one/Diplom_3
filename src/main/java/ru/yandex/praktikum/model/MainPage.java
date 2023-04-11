package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    private final WebDriver driver;
    private static final By UPPER_ACCOUNT_BUTTON = By.xpath("//a[@class='AppHeader_header__link__3D_hX'][@href='/account']");
    private static final By LOWER_LOGIN_BUTTON =  By.xpath("//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button[text()='Войти в аккаунт']");
    private static final By MAKE_ORDER_BUTTON = By.xpath("//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button[text()='Оформить заказ']");
    private static final By HEADER = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']/h1");
    private static final By BUNS_IN_TAB = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']//div[contains(@class, 'tab_tab__1SPyG')]/span[text()='Булки']");
    private static final By BUNS_IN_TAB_ACTIVE = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']//div[contains(@class,'tab_tab_type_current')]/span[text()='Булки']");
    private static final By BUNS_IN_LIST = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Булки']");
    private static final By SAUCE_IN_TAB = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']//div[contains(@class, 'tab_tab__1SPyG')]/span[text()='Соусы']");
    private static final By SAUCE_IN_TAB_ACTIVE = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']//div[contains(@class,'tab_tab_type_current')]/span[text()='Соусы']");
    private static final By SAUCE_IN_LIST = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Соусы']");
    private static final By FILLING_IN_TAB = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']//div[contains(@class, 'tab_tab__1SPyG')]/span[text()='Начинки']");
    private static final By FILLING_IN_TAB_ACTIVE = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']//div[contains(@class,'tab_tab_type_current')]/span[text()='Начинки']");
    private static final By FILLING_IN_LIST = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public void clickUpperAccountButton() {
        driver.findElement(UPPER_ACCOUNT_BUTTON).click();
    }
    public boolean isHeaderDisplayed() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(HEADER)));
        String name = driver.findElement(HEADER).getText();
        return (name.equals("Соберите бургер"));
    }
    public boolean isMakeOrderDisplayed() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(MAKE_ORDER_BUTTON)));
        return driver.findElement(MAKE_ORDER_BUTTON).isDisplayed();
    }
    public void clickLowerLoginButton() {
        driver.findElement(LOWER_LOGIN_BUTTON).click();
    }
    public void clickBunsButton() {
        new WebDriverWait(driver, 3);
        driver.findElement(BUNS_IN_TAB).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(BUNS_IN_TAB_ACTIVE));


    }
    public void clickSauceButton() {
        new WebDriverWait(driver, 3);
        driver.findElement(SAUCE_IN_TAB).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(SAUCE_IN_TAB_ACTIVE));

    }
    public void clickFillingButton() {
        new WebDriverWait(driver, 3);
        driver.findElement(FILLING_IN_TAB).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(FILLING_IN_TAB_ACTIVE));


    }
    public boolean isBunsDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(BUNS_IN_LIST));
        return (driver.findElement(BUNS_IN_LIST).isDisplayed());
    }
    public boolean isBunsTabActive() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(BUNS_IN_TAB_ACTIVE));
        return (driver.findElement(BUNS_IN_TAB_ACTIVE).isDisplayed());
    }
    public boolean isSauceDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(SAUCE_IN_LIST));
        return driver.findElement(SAUCE_IN_LIST).isDisplayed();
    }
    public boolean isSauceTabActive() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(SAUCE_IN_TAB_ACTIVE));
        return driver.findElement(SAUCE_IN_TAB_ACTIVE).isDisplayed();
    }
    public boolean isFillingDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(FILLING_IN_LIST));
        return (driver.findElement(FILLING_IN_LIST).isDisplayed());
    }
    public boolean isFillingTabActive() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(FILLING_IN_TAB_ACTIVE));
        return (driver.findElement(FILLING_IN_TAB_ACTIVE).isDisplayed());
    }
}
