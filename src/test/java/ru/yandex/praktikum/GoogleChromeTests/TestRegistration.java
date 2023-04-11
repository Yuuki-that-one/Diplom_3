package ru.yandex.praktikum.GoogleChromeTests;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
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

public class TestRegistration {
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
    @DisplayName("Регистрация, затем сразу логин на той же странице")
    public void registrationAndThenLogin() {
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
        //Далее проверяем, что можно залогинится созданным пользователем
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue("Главная страница после логина не открылась", mainPage.isHeaderDisplayed());
        Assert.assertTrue("Кнопка заказа для авторизованного пользователя не отобразилась", mainPage.isMakeOrderDisplayed());

    }

    @Test
    @DisplayName("Ошибка регистрации с паролем короче 6 символов")
    public void canNotRegisterWithShortPassword() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        User user = UserGenerator.getRandom();
        user.setPassword(RandomStringUtils.randomAlphabetic(5));
        mainPage.open();
        mainPage.clickUpperAccountButton();
        Assert.assertTrue("Страница логина не открылась", loginPage.isHeaderDisplayed());
        loginPage.clickRegisterButton();
        Assert.assertTrue("Страница регистрации не открылась", registerPage.isHeaderDisplayed());
        registerPage.inputName(user.getName());
        registerPage.inputEmail(user.getEmail());
        registerPage.inputPassword(user.getPassword());
        registerPage.clickRegisterButton();
        Assert.assertTrue("Ошибка ввода короткого пароля не отобразилась", registerPage.isWrongPasswordErrorDisplayed());
        Assert.assertTrue("Произошел переход со страницы регистрации", registerPage.isHeaderDisplayed());

    }


}
