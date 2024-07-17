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
    FOOTER_IS_DISPLAYED("Footer is displayed"),
    FOOTER_IS_NOT_DISPLAYED("Footer is not displayed"),
    FOOTER_RIGHTS("\"© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy\""),
    FOOTER_TEXT_IS_CORRECT("Footer text is correct"),
    FOOTER_TEXT_IS_NOT_CORRECT("Footer text is not correct"),
    SAUCE_LABS("Sauce Labs"),
    TWITTER_PAGE_IS_AVAILABLE("Twitter page is available"),
    TWITTER_PAGE_IS_NOT_AVAILABLE("Twitter page is not available"),
    FACEBOOK_PAGE_IS_AVAILABLE("Facebook page is available"),
    FACEBOOK_PAGE_IS_NOT_AVAILABLE("Facebook page is not available"),
    LINKEDIN_PAGE_IS_AVAILABLE("Linkedin page is available"),
    LINKEDIN_PAGE_IS_NOT_AVAILABLE("Linkedin page is not available"),
    USERNAME_AND_PASSWORD_DO_NOT_MATCH("Epic sadface: Username and password do not match any user in this service"),
    USER_NAME_IS_NULL("User name is null: "),
    USERNAME_IS_REQUIRED("Epic sadface: Username is required");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

}
