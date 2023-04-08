package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    private final WebDriver driver;
    private static final By UPPER_ACCOUNT_BUTTON = By.xpath(".//header/nav/a[@href='/account']");
    private static final By LOWER_LOGIN_BUTTON =  By.xpath("//main/section[2]/div/button[text()='Войти в аккаунт']");
    private static final By MAKE_ORDER_BUTTON = By.xpath("//main/section[2]/div/button[text()='Оформить заказ']");

    private static final By HEADER = By.xpath(".//main/section[1]/h1");

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
        String name = driver.findElement(MAKE_ORDER_BUTTON).getText();
        return (name.equals("Оформить заказ"));
    }
    public void clickLowerLoginButton() {
        driver.findElement(LOWER_LOGIN_BUTTON).click();
    }
}
