package ru.yandex.praktikum.GoogleChromeTests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.client.UserClient;
import ru.yandex.praktikum.model.*;
import ru.yandex.praktikum.user_model.User;
import ru.yandex.praktikum.user_model.UserGenerator;

public class TestLogin {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void cleanUp() {
        String userAccessToken = ((WebStorage) driver).getLocalStorage().getItem("accessToken");
        if (userAccessToken != null) {
            UserClient userClient = new UserClient();
            userClient.delete(userAccessToken);
        }
        new WebDriverWait(driver, 5);
        driver.quit();
    }
    @Test
    @DisplayName("Логин через кнопку 'Войти в аккаунт' внизу главной страницы")
    public void loginViaMainPageLowerLoginButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        User user = UserGenerator.getRandom();
        mainPage.open();
        mainPage.clickUpperAccountButton();
        Assert.assertTrue("Страница логина не открылась", loginPage.isHeaderDisplayed());
        loginPage.clickRegisterButton();
        Assert.assertTrue("Страница регистрации не открылась", registerPage.isHeaderDisplayed());
        registerPage.inputName(user.getName());
        registerPage.inputEmail(user.getEmail());
        registerPage.inputPassword(user.getPassword());
        registerPage.clickRegisterButton();
        Assert.assertTrue("Страница логина после регистрации не открылась", loginPage.isHeaderDisplayed());
        loginPage.clickConstructorButton(); //возврат на главную
        
        mainPage.clickLowerLoginButton();
        Assert.assertTrue("Страница логина не открылась", loginPage.isHeaderDisplayed());
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue("Главная страница после логина не открылась", mainPage.isHeaderDisplayed());
        Assert.assertTrue("Кнопка заказа для авторизованного пользователя не отобразилась", mainPage.isMakeOrderDisplayed());


    }
    @Test
    @DisplayName("Логин через кнопку 'Личный кабинет'")
    public void loginViaMainPageUpperAccountButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        User user = UserGenerator.getRandom();
        mainPage.open();
        mainPage.clickUpperAccountButton();
        Assert.assertTrue("Страница логина не открылась", loginPage.isHeaderDisplayed());
        loginPage.clickRegisterButton();
        Assert.assertTrue("Страница регистрации не открылась", registerPage.isHeaderDisplayed());
        registerPage.inputName(user.getName());
        registerPage.inputEmail(user.getEmail());
        registerPage.inputPassword(user.getPassword());
        registerPage.clickRegisterButton();
        Assert.assertTrue("Страница логина после регистрации не открылась", loginPage.isHeaderDisplayed());
        loginPage.clickConstructorButton(); //возврат на главную
        Assert.assertTrue("Главная страница не открылась", mainPage.isHeaderDisplayed());
        mainPage.clickUpperAccountButton();
        Assert.assertTrue("Страница логина не открылась", loginPage.isHeaderDisplayed());
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue("Главная страница после логина не открылась", mainPage.isHeaderDisplayed());
        Assert.assertTrue("Кнопка заказа для авторизованного пользователя не отобразилась", mainPage.isMakeOrderDisplayed());


    }
    @Test
    @DisplayName("Логин через кнопку 'Войти' на странице регистрации")
    public void loginViaRegisterPageButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        User user = UserGenerator.getRandom();
        mainPage.open();
        mainPage.clickUpperAccountButton();
        Assert.assertTrue("Страница логина не открылась", loginPage.isHeaderDisplayed());
        loginPage.clickRegisterButton();
        Assert.assertTrue("Страница регистрации не открылась", registerPage.isHeaderDisplayed());
        registerPage.inputName(user.getName());
        registerPage.inputEmail(user.getEmail());
        registerPage.inputPassword(user.getPassword());
        registerPage.clickRegisterButton();
        Assert.assertTrue("Страница логина после регистрации не открылась", loginPage.isHeaderDisplayed());
        loginPage.clickConstructorButton(); //возврат на главную
        Assert.assertTrue("Главная страница не открылась", mainPage.isHeaderDisplayed());

        mainPage.clickUpperAccountButton();
        Assert.assertTrue("Страница логина не открылась", loginPage.isHeaderDisplayed());
        loginPage.clickRegisterButton();
        Assert.assertTrue("Страница регистрации не открылась", registerPage.isHeaderDisplayed());
        registerPage.clickLoginButton();  //Нажимаем кнопку "Войти" на странице регистрации
        Assert.assertTrue("Страница логина не открылась", loginPage.isHeaderDisplayed());
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue("Главная страница после логина не открылась", mainPage.isHeaderDisplayed());
        Assert.assertTrue("Кнопка заказа для авторизованного пользователя не отобразилась", mainPage.isMakeOrderDisplayed());

    }
    @Test
    @DisplayName("Логин через кнопку 'Забыли пароль?'")
    public void loginViaForgotPasswordPageButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        User user = UserGenerator.getRandom();
        mainPage.open();
        mainPage.clickUpperAccountButton();
        Assert.assertTrue("Страница логина не открылась", loginPage.isHeaderDisplayed());
        loginPage.clickRegisterButton();
        Assert.assertTrue("Страница регистрации не открылась", registerPage.isHeaderDisplayed());
        registerPage.inputName(user.getName());
        registerPage.inputEmail(user.getEmail());
        registerPage.inputPassword(user.getPassword());
        registerPage.clickRegisterButton();
        Assert.assertTrue("Страница логина после регистрации не открылась", loginPage.isHeaderDisplayed());
        loginPage.clickConstructorButton(); //возврат на главную
        Assert.assertTrue("Главная страница не открылась", mainPage.isHeaderDisplayed());

        mainPage.clickUpperAccountButton();
        Assert.assertTrue("Страница логина не открылась", loginPage.isHeaderDisplayed());
        loginPage.clickForgotPasswordButton();
        Assert.assertTrue("Страница восстановления пароля не открылась", forgotPasswordPage.isHeaderDisplayed());
        forgotPasswordPage.clickLoginButton();
        Assert.assertTrue("Страница логина не открылась", loginPage.isHeaderDisplayed());
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue("Главная страница после логина не открылась", mainPage.isHeaderDisplayed());
        Assert.assertTrue("Кнопка заказа для авторизованного пользователя не отобразилась", mainPage.isMakeOrderDisplayed());
    }
}
