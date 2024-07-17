package com.oelisavetchi.bdd.enums;

import lombok.Getter;

@Getter
public enum PageElements {

    LOGIN_BUTTON("login-button"),
    USER_NAME("user-name"),
    PASSWORD("password"),
    LOGOUT("Logout"),
    INNER_TEXT("innerText"),
    REACT_BURGER_MENU_BTN("react-burger-menu-btn"),
    PRODUCT_LABEL("//*[@id=\"header_container\"]/div[2]/span"),
    LOGIN_BUTTON_CONTAINER("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"),
    FOOTER("/html/body/div/div/footer"),
    FOOTER_TEXT("//*[@id=\"page_wrapper\"]/footer/div"),
    TWITTER_LINK("https://x.com/saucelabs"),
    TWITTER_PAGE("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[1]/div[1]/div/div/div/div/div/div[2]/div/h2/div/div/div/div/span[1]/span/span[1]"),
    FACEBOOK_LINK("https://www.facebook.com/saucelabs"),
    FACEBOOK_PAGE("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div/div[1]/div[2]/div/div/div/div[3]/div/div/div[1]/div/div/span/h1"),
    LINKEDIN_LINK("https://www.linkedin.com/company/sauce-labs/"),
    LINKEDIN_PAGE("/html/body/main/section[1]/section/div/div[2]/div[1]/h1"),
    SWAG_LAB_LABEL("//*[@id=\"root\"]/div/div[1]");

    private final String element;

    PageElements(String element) {
        this.element = element;
    }

}
