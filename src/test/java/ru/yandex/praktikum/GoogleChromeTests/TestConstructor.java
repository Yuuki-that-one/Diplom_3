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
import ru.yandex.praktikum.model.MainPage;

public class TestConstructor {
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
    @DisplayName("Отображение раздела 'Булки' в конструкторе")
    public void bunsIsShownInConstructor() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        new WebDriverWait(driver, 5); //ждем прогрузки страницы
        mainPage.clickFillingButton(); //Переключаем вкладки, чтобы проверить, что нажатие на открытую по умолчанию вкладку действительно ее вызывает
        Assert.assertTrue("Начинки не отобразились", mainPage.isFillingDisplayed());
        Assert.assertTrue("Вкладка начинок не активна", mainPage.isFillingTabActive());
        new WebDriverWait(driver, 3); //ждем анимацию прокрутки
        mainPage.clickBunsButton();
        Assert.assertTrue("Булки не отобразились", mainPage.isBunsDisplayed());
        Assert.assertTrue("Вкладка булок не активна", mainPage.isBunsTabActive());

    }
    @Test
    @DisplayName("Отображение раздела 'Соусы' в конструкторе")
    public void sauceIsShownInConstructor() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        new WebDriverWait(driver, 5); //ждем прогрузки страницы
        mainPage.clickSauceButton();
        new WebDriverWait(driver, 3); //ждем анимацию прокрутки
        Assert.assertTrue("Соусы не отобразились", mainPage.isSauceDisplayed());
        Assert.assertTrue("Вкладка соусов не активна", mainPage.isSauceTabActive());

    }
    @Test
    @DisplayName("Отображение раздела 'Начинки' в конструкторе")
    public void fillingIsShownInConstructor() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        new WebDriverWait(driver, 5); //ждем прогрузки страницы
        mainPage.clickFillingButton();
        new WebDriverWait(driver, 3); //ждем анимацию прокрутки
        Assert.assertTrue("Начинки не отобразились", mainPage.isFillingDisplayed());
        Assert.assertTrue("Вкладка начинок не активна", mainPage.isFillingTabActive());

    }

}
