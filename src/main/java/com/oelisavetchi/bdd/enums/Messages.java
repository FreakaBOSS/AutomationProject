package com.oelisavetchi.bdd.enums;

import lombok.Getter;

@Getter
public enum Messages {

    NAVIGATED_SUCCESSFULLY("Navigated Successfully"),
    NAVIGATED_TO_HOME_PAGE("Navigated to Home page"),
    NOT_NAVIGATED("Not navigated"),
    ERROR_MESSAGE_IS_CORRECT("Error message is correct: "),
    ERROR_MESSAGE_IS_WRONG("Error message is wrong: "),
    SOMETHING("something"),
    SOMETHINGS("somethings"),
    LOGOUT_SUCCESSFULLY("Logout successfully"),
    UNABLE_TO_LOGOUT("Unable to logout"),
    USERNAME_AND_PASSWORD_DO_NOT_MATCH("Epic sadface: Username and password do not match any user in this service"),
    USER_NAME_IS_NULL("User name is null: "),
    USERNAME_IS_REQUIRED("Epic sadface: Username is required");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

}
