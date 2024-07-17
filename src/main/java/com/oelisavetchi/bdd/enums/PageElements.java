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
    SWAG_LAB_LABEL("//*[@id=\"root\"]/div/div[1]");

    private final String element;

    PageElements(String element) {
        this.element = element;
    }

}
