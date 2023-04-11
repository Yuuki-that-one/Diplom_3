package ru.yandex.praktikum.user_model;

import java.util.Locale;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    static Faker faker = new Faker(new Locale("en"));


    public static User getRandom() {

        String email = faker.internet().safeEmailAddress();
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        return new User(email, password, name);
    }

}

