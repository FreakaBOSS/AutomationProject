package com.oelisavetchi.bdd;

public enum PageElements {
    LOGIN_BUTTON("login-button"),
    USER_NAME("user-name"),
    PASSWORD("password"),
    LOGOUT("Logout"),
    REACT_BURGER_MENU_BTN("react-burger-menu-btn"),
    PRODUCT_LABEL("//*[@id=\"header_container\"]/div[2]/span"),
    SWAG_LAB_LABEL("//*[@id=\"root\"]/div/div[1]");

    private final String element;

    PageElements(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }

}
