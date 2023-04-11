package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    //https://stellarburgers.nomoreparties.site/register
    private final WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By INPUT_NAME = By.xpath("(//form[@class='Auth_form__3qKeq mb-20']//div[@class='input__container']//input)[1]");
    private static final By INPUT_EMAIL = By.xpath("(//form[@class='Auth_form__3qKeq mb-20']//div[@class='input__container']//input)[2]");
    private static final By INPUT_PASSWORD =  By.xpath("(//form[@class='Auth_form__3qKeq mb-20']//div[@class='input__container']//input)[3]");
    private static final By INPUT_ERROR_SIGN = By.className("input__error");
    private static final By REGISTER_BUTTON = By.xpath("//form[@class='Auth_form__3qKeq mb-20']//button[text()='Зарегистрироваться']");
    private static final By HEADER = By.xpath("//div[@class='Auth_login__3hAey']/h2");
    private static final By LOGIN_BUTTON = By.xpath("//a[@href=\"/login\"]");

    public void inputName(String name)
    {
        driver.findElement(INPUT_NAME).sendKeys(name);
    }
    public void inputEmail(String email) {
        driver.findElement(INPUT_EMAIL).sendKeys(email);
    }
    public void inputPassword(String password) {
        driver.findElement(INPUT_PASSWORD).sendKeys(password);
    }
    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }
    public boolean isHeaderDisplayed() {
        String name = driver.findElement(HEADER).getText();
        return (name.equals("Регистрация"));
    }
    public boolean isWrongPasswordErrorDisplayed() {
        String name = driver.findElement(INPUT_ERROR_SIGN).getText();
        return (name.equals("Некорректный пароль"));
    }
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
