package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
     //https://stellarburgers.nomoreparties.site/login
    private static final By INPUT_EMAIL = By.cssSelector("#root>div>main>div>form>fieldset:nth-child(1)>div>div>input");
    private static final By INPUT_PASSWORD = By.cssSelector("#root>div>main>div>form>fieldset:nth-child(2)>div>div>input");
    private final WebDriver driver;

    //Кнопка регистрации на странице авторизации
    private static final By REGISTER_BUTTON = By.xpath(".//a[@href='/register']");
    private static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");

    private static final By HEADER = By.xpath("//*[@id=\"root\"]/div/main/div/h2");
    private static final By CONSTRUCTOR_BUTTON = By.className("AppHeader_header__link__3D_hX");
    private static final By FORGOT_PASSWORD_BUTTON =  By.xpath(".//a[@href='/forgot-password']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //Кнопка регистрации на странице авторизации
    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
    public void inputEmail(String email) {
        driver.findElement(INPUT_EMAIL).sendKeys(email);
    }
    public void inputPassword(String password) {
        driver.findElement(INPUT_PASSWORD).sendKeys(password);
    }
    public boolean isHeaderDisplayed() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(FORGOT_PASSWORD_BUTTON))); //Ждем полной прогрузки страницы
        String name = driver.findElement(HEADER).getText();
        return (name.equals("Вход"));
    }
    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }
    public void clickForgotPasswordButton() {
        driver.findElement(FORGOT_PASSWORD_BUTTON).click();
    }


}
