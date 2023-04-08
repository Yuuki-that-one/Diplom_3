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
    public void BunsIsShownInConstructor() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingButton(); //Переключаем вкладки, чтобы проверить, что нажатие на открытую по умолчанию вкладку действительно ее вызывает
        Assert.assertTrue("Начинки не отобразились", mainPage.isFillingDisplayed());
        mainPage.clickBunsButton();
        Assert.assertTrue("Булки не отобразились", mainPage.isBunsDisplayed());

    }
    @Test
    @DisplayName("Отображение раздела 'Соусы' в конструкторе")
    public void SauceIsShownInConstructor() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSauceButton();
        Assert.assertTrue("Соусы не отобразились", mainPage.isSauceDisplayed());

    }
    @Test
    @DisplayName("Отображение раздела 'Начинки' в конструкторе")
    public void FillingIsShownInConstructor() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingButton();
        Assert.assertTrue("Начинки не отобразились", mainPage.isFillingDisplayed());

    }

}
