package ru.kpfu.bookstore.Service;

import java.util.regex.Pattern;

/**
 * Created by Nurislam on 04.04.2017.
 */
public class RegularTest {
    public boolean isCorrectPassword(String password) {
        return Pattern.matches("^[A-Za-z0-9]{6,60}", password);
    }

    public boolean isCorrectName(String name) {
        return Pattern.matches("^[A-Za-zА-Яа-я]{4,20}", name);
    }

    public boolean isCorrectEmail(String email) {
        return Pattern.matches("^[-a-z0-9!#$%&'*+/=?^_`{|}~]+" +
                        "(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*" +
                        "([a-z]+)$",
                email);
    }
}
