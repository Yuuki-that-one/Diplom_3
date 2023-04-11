package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    //https://stellarburgers.nomoreparties.site/account/profile
    private final WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    private static final By PROFILE_BUTTON =By.xpath("//a[@href=\"/account/profile\"]");
    private static final By CONSTRUCTOR_BUTTON = By.className("AppHeader_header__link__3D_hX");
    private static final By LOGO_BUTTON = By.xpath("//header//div[@class='AppHeader_header__logo__2D0X2']");
    private static final By LOGOUT_BUTTON = By.xpath("//button[text()='Выход']");

    public boolean isProfileButtonDisplayed() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(PROFILE_BUTTON)));
        return driver.findElement(PROFILE_BUTTON).isDisplayed();
    }
    public void clickLogo() {
        driver.findElement(LOGO_BUTTON).click();
    }
    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }
    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }
}
