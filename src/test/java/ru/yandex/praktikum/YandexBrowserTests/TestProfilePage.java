package ru.yandex.praktikum.YandexBrowserTests;

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

public class TestProfilePage {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver\\yandexdriver.exe");
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
    @DisplayName("Открытие профиля авторизованного юзера")
    public void OpenProfilePageWithLoggedInUser() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
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
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue("Главная страница после логина не открылась", mainPage.isHeaderDisplayed());
        Assert.assertTrue("Кнопка заказа для авторизованного пользователя не отобразилась", mainPage.isMakeOrderDisplayed());

        mainPage.clickUpperAccountButton();
        Assert.assertTrue("Страница профиля не открылась", profilePage.isProfileButtonDisplayed());
    }
    @Test
    @DisplayName("Переход по клику на лого на странице профиля")
    public void CheckClickOnLogoAtProfilePage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
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
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue("Главная страница после логина не открылась", mainPage.isHeaderDisplayed());
        Assert.assertTrue("Кнопка заказа для авторизованного пользователя не отобразилась", mainPage.isMakeOrderDisplayed());

        mainPage.clickUpperAccountButton();
        Assert.assertTrue("Страница профиля не открылась", profilePage.isProfileButtonDisplayed());
        profilePage.clickLogo();
        Assert.assertTrue("Главная страница не открылась", mainPage.isHeaderDisplayed());
    }
    @Test
    @DisplayName("Переход по клику на лого на странице профиля")
    public void CheckClickOnConstructorButtonAtProfilePage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
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
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue("Главная страница после логина не открылась", mainPage.isHeaderDisplayed());
        Assert.assertTrue("Кнопка заказа для авторизованного пользователя не отобразилась", mainPage.isMakeOrderDisplayed());

        mainPage.clickUpperAccountButton();
        Assert.assertTrue("Страница профиля не открылась", profilePage.isProfileButtonDisplayed());
        profilePage.clickConstructorButton();
        Assert.assertTrue("Главная страница не открылась", mainPage.isHeaderDisplayed());
    }
    @Test
    @DisplayName("Разлогин по клику на кнопку 'Выход' на странице профиля")
    public void CheckLogoutButtonAtProfilePage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
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
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue("Главная страница после логина не открылась", mainPage.isHeaderDisplayed());
        Assert.assertTrue("Кнопка заказа для авторизованного пользователя не отобразилась", mainPage.isMakeOrderDisplayed());

        mainPage.clickUpperAccountButton();
        Assert.assertTrue("Страница профиля не открылась", profilePage.isProfileButtonDisplayed());
        profilePage.clickLogoutButton();
        Assert.assertTrue("Страница логина после разлогина не открылась", loginPage.isHeaderDisplayed());
    }


}
