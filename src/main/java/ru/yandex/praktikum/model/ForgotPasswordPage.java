package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {
    //https://stellarburgers.nomoreparties.site/forgot-password
    private final WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private static final By HEADER = By.xpath("//*[@id=\"root\"]/div/main/div/h2");
    private static final By LOGIN_BUTTON = By.xpath("//a[@href=\"/login\"]");
    public boolean isHeaderDisplayed() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(HEADER)));
        String name = driver.findElement(HEADER).getText();
        return (name.equals("Восстановление пароля"));
    }
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

}
