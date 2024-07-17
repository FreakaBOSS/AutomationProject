package com.oelisavetchi.bdd.stepDefinition;

import com.oelisavetchi.bdd.ApplicationProperty;
import com.oelisavetchi.bdd.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.oelisavetchi.bdd.enums.Messages.*;
import static com.oelisavetchi.bdd.enums.PageElements.*;

@Log4j2
public class StepDefinitions extends Base {

    private String username;
    private String password;
    private ApplicationProperty applicationProperty;

    //login.feature

    @Given("user should navigate to swag labs login page")
    public void userShouldNavigateToSwagLabsLoginPage() {

        String url = "https://www.saucedemo.com/";
        driver = inheritance();
        driver.get(url);
    }

    @When("user enter the {string} and {string}")
    public void userEnterTheUsername(String username, String password) {
        driver.findElement(By.id(USER_NAME.getElement())).sendKeys(username);
        driver.findElement(By.id(PASSWORD.getElement())).sendKeys(password);
    }


    @When("user click the login button")
    public void userClickTheLoginButton() {
        driver.findElement(By.id(LOGIN_BUTTON.getElement())).click();
    }


    @Then("user should navigate to Swag Labs home page")
    public void userShouldNavigateToSwagLabsHomePage() throws InterruptedException {

        By ProductLabel = By.xpath(PRODUCT_LABEL.getElement());
        boolean isDisplayed = driver.findElement(ProductLabel).isDisplayed();


        if (isDisplayed) {
            synchronized (this) {
                log.info(NAVIGATED_SUCCESSFULLY.getMessage());
                this.wait(2000);
                driver.close();
            }
        } else {
            log.info(NOT_NAVIGATED.getMessage());
        }

    }

    @Then("user should not navigate to Swag Labs home page")
    public void userShouldNotNavigateToSwagLabsHomePage() throws InterruptedException {

        By SwagLabLabel = By.xpath(SWAG_LAB_LABEL.getElement());
        boolean isDisplayed = driver.findElement(SwagLabLabel).isDisplayed();

        if (isDisplayed) {
            synchronized (this) {
                log.info(NOT_NAVIGATED.getMessage());
                this.wait(2000);
                driver.close();
            }
        } else {
            log.info(NOT_NAVIGATED.getMessage());
        }

    }

//loginerrormessage.feature

    @Then("user should see the correct error message")
    public void userShouldSeeTheCorrectErrorMessage() {

        String errorMessage = driver.findElement(By.xpath(LOGIN_BUTTON_CONTAINER.getElement())).getAttribute(INNER_TEXT.getElement());

        if (username != null) {
            if (username.isEmpty() && password.isEmpty() && errorMessage.equals(USERNAME_IS_REQUIRED.getMessage())) {
                log.info(ERROR_MESSAGE_IS_CORRECT.getMessage(), errorMessage);
            } else {
                if (username.isEmpty() && password.equals(SOMETHING.getMessage()) && errorMessage.equals(USERNAME_IS_REQUIRED.getMessage())) {
                    log.info(ERROR_MESSAGE_IS_CORRECT.getMessage(), errorMessage);
                } else if (username.equals(SOMETHING.getMessage()) && password.isEmpty() && errorMessage.equals(USERNAME_IS_REQUIRED.getMessage())) {
                    log.info(ERROR_MESSAGE_IS_CORRECT.getMessage(), errorMessage);
                } else if (username.equals(SOMETHING.getMessage()) && password.equals(SOMETHINGS.getMessage()) && errorMessage.equals(USERNAME_AND_PASSWORD_DO_NOT_MATCH.getMessage())) {
                    log.info(ERROR_MESSAGE_IS_CORRECT.getMessage(), errorMessage);
                } else {
                    log.info(ERROR_MESSAGE_IS_WRONG.getMessage(), errorMessage);
                }
            }
        } else {
            log.info(USER_NAME_IS_NULL.getMessage(), errorMessage);
        }
        driver.quit();
    }

//logout.feature

    @Given("user should login to swag labs using correct {string} and {string}")
    public void userShouldLoginToSwagLabsUsingCorrectAnd(String Username, String Password) {

        String url = "https://www.saucedemo.com/";
        this.driver = this.inheritance();
        this.driver.get(url);
        driver.findElement(By.id(USER_NAME.getElement())).sendKeys(Username);
        driver.findElement(By.id(PASSWORD.getElement())).sendKeys(Password);
        driver.findElement(By.id(LOGIN_BUTTON.getElement())).click();
    }

    @Given("user should navigate to left sidebar")
    public void user_should_navigate_to_left_sidebar() throws InterruptedException {
        driver.findElement(By.id(REACT_BURGER_MENU_BTN.getElement())).click();
        synchronized (this) {
            this.wait(2000L);
        }
    }

    @When("user click the logout button")
    public void userClickTheLogoutButton() {
        driver.findElement(By.linkText(LOGOUT.getElement())).click();
    }

    @Then("user should logout from Swag Labs")
    public void userShouldLogoutFromSwagLabs() {

        boolean isDisabled = driver.findElement(By.xpath(SWAG_LAB_LABEL.getElement())).isDisplayed();

        String result = isDisabled ? LOGOUT_SUCCESSFULLY.getMessage() : UNABLE_TO_LOGOUT.getMessage();
        log.info(result);

        this.driver.quit();
    }


////footer.feature
//
//    @Then("user should see the footer")
//    public void user_should_see_the_footer() {
//
//        Helper H1 = new Helper(driver);
//        boolean var1 = H1.Footer().isDisplayed();
//
//        if (var1) {
//
//            log.info("footer is displayed");
//        } else {
//
//            log.info("Not displayed: footer");
//        }
//
//        driver.quit();
//
//    }
//
//    @Then("user should see the correct footer text")
//    public void user_should_see_the_correct_footer_text() {
//
//        Helper H1 = new Helper(driver);
//        String footerText = H1.FooterText().getAttribute("innerText");
//
//        if (footerText.equals("© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy")) {
//
//            log.info("footer Text is correct");
//        } else {
//
//            log.info("footer Text is not correct");
//        }
//
//        driver.quit();
//
//    }
//
//    @When("user clicked the twitter icon")
//    public void user_clicked_the_twitter_icon() {
//
//        driver.findElement(By.linkText("https://twitter.com/saucelabs")).click();
//
//    }
//
//    @Then("user should navigate to swag labs twitter page")
//    public void user_should_navigate_to_swag_labs_twitter_page() throws InterruptedException {
//        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs2.get(0));
//        driver.switchTo().window(tabs2.get(1));
//
//        Helper H1 = new Helper(driver);
//        String twitterpageName = H1.TwitterPage().getAttribute("innerText");
//
//        if (twitterpageName.equals("Sauce Labs")) {
//
//            log.info("Navigated to twitter page");
//        } else {
//            log.info("Not Navigated to twitter page");
//        }
//
//        Thread.sleep(1000);
//        driver.quit();
//
//    }
//
//    @When("User clicked the facebook icon")
//    public void user_clicked_the_facebook_icon() throws InterruptedException {
//        driver.findElement(By.linkText("https://www.facebook.com/saucelabs")).click();
//
//
//    }
//
//    @Then("User should navigate to swag labs facebook page")
//    public void user_should_navigate_to_swag_labs_facebook_page() throws InterruptedException {
//
//        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs2.get(0));
//        driver.switchTo().window(tabs2.get(1));
//
//        Helper H1 = new Helper(driver);
//        String fbpageName = H1.FacebookPage().getAttribute("innerText");
//
//        if (fbpageName.equals("Sauce Labs")) {
//
//            log.info("Navigated to facebook page");
//        } else {
//
//            log.info("Not Navigated to facebook page");
//        }
//
//        Thread.sleep(1000);
//        driver.quit();
//    }
//
//    @When("user clicked the linkedin icon")
//    public void user_clicked_the_linkedin_icon() {
//        driver.findElement(By.linkText("https://www.linkedin.com/company/sauce-labs/")).click();
//
////		Helper H1 = new Helper(driver);
////		H1.LinkedInButton().click();
//
//    }
//
//    @Then("user should navigate to swag labs linkedin page")
//    public void user_should_navigate_to_swag_labs_linkedin_page() throws InterruptedException {
//
//        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs2.get(0));
//        driver.switchTo().window(tabs2.get(1));
//
//        Helper H1 = new Helper(driver);
//        String linkedInPageName = H1.LinkedinPage().getAttribute("innerText");
//
//        if (linkedInPageName.equals("Sauce Labs")) {
//
//            System.out.println("Navigated to linkedIn page");
//        } else {
//
//            System.out.println("Not Navigated to linkedIn page");
//        }
//
//        Thread.sleep(1000);
//        driver.quit();
//    }
//
////product.feature
//
//    @Then("User should see the product title label")
//    public void user_should_see_the_product_label() {
//
//        Helper H1 = new Helper(driver);
//        String TitleProduct = H1.TitleProduct().getAttribute("innerText");
//
//        if (TitleProduct.equals("Products")) {
//
//            System.out.println("Product title label is correct");
//
//        } else {
//
//            System.out.println("Product title label is not correct");
//        }
//        driver.quit();
//
//    }
//
//    @Then("user should see the product sort option")
//    public void user_should_see_the_product_sort_option() {
//
//        boolean isDisplayed = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).isDisplayed();
//
//        String result = isDisplayed ? "Product sort option is displayed" : "Not displayed";
//        log.info(result);
//
//        driver.quit();
//    }
//
//    @Then("user should see the products correctly")
//    public void user_should_see_the_products_correctly() {
//
//        Helper H1 = new Helper(driver);
//        List<WebElement> items = H1.InventoryItem();
//
//        String[] itemDetailNames = {"name", "description", "price", "button text"};
//        String[] itemDetailsRecieved;
//        //items.get(1).getText().split("\\R");
//
//        String[][] itemDetailsCorrect = {{"Sauce Labs Backpack", "Carry all the things with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "$29.99", "Add to cart"}, {"Sauce Labs Bike Light", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", "$9.99", "Add to cart"}, {"Sauce Labs Bolt T-Shirt", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.", "$15.99", "Add to cart"}, {"Sauce Labs Fleece Jacket", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.", "$49.99", "Add to cart"}, {"Sauce Labs Onesie", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.", "$7.99", "Add to cart"}, {"Sauce Labs T-Shirt (Red)", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.", "$15.99", "Add to cart"},};
//
//        //itemDetailsRecieved = items.get(1).getText().split("\\R");
//        System.out.println("Number of product items :" + items.size());
//
//        for (int i = 0; i <= 5; i++) {
//
//            itemDetailsRecieved = items.get(i).getText().split("\\R");
//
//            for (int j = 0; j <= 3; j++) {
//
//                if (itemDetailsCorrect[i][j].equals(itemDetailsRecieved[j])) {
//
//                    System.out.println("Product " + (i + 1) + " " + itemDetailNames[j] + " is correct: " + itemDetailsRecieved[j]);
//                } else {
//
//                    System.out.println("Product " + (i + 1) + " " + itemDetailNames[j] + " is wrong: " + "Received --> " + itemDetailsRecieved[j] + " Expected --> " + itemDetailsCorrect[i][j]);
//                }
//            }
//        }
//        driver.quit();
//    }
//
////cart.feature
//
//    @When("user click the add to cart button (\\d+)$")
//    public void user_click_the_add_to_cart_button(int itemNumber) throws InterruptedException {
//
//
//        Helper H1 = new Helper(driver);
//        numOfItems = H1.CartBadgeContainer().getText();
//        //System.out.println("Button text before is : "+H1.AddToCartButton().get(0).getText());
//        H1.AddToCartButton().get(itemNumber).click();
//        //Thread.sleep(3000);
//        //System.out.println("Button text after is : "+H1.RemoveButton().get(0).getText());
//        System.out.println("Button is " + itemNumber);
//
//
//    }
//
//    @Then("user should see the updated cart badge")
//    public void user_should_see_the_updated_cart_badge() {
//        Helper H1 = new Helper(driver);
//        //numOfItems = H1.CartBadgeContainer().getText();
//        if (numOfItems.equals("")) {
//            numOfItems = "0";
//        }
//
//        String numOfItemsNew = H1.CartBadgeContainer().getText();
//
//        System.out.println("Number of items in the cart is : " + numOfItems);
//        System.out.println("Number of items in the cart new is : " + numOfItemsNew);
//
//        if (Integer.parseInt(numOfItemsNew) == Integer.parseInt(numOfItems) + 1) {
//            System.out.println("Cart badge is updated successfully");
//        } else {
//            System.out.println("Fail to upadted");
//        }
//        driver.quit();
//    }
//
//    @When("user click the add to cart buttons")
//    public void user_click_the_add_to_cart_buttons() {
//
//        Helper H1 = new Helper(driver);
//
//        for (int i = 0; i <= 5; i++) {
//            H1.AddToCartButton().get(0).click();
//        }
//
//    }
//
//    @Then("user should see the remove button")
//    public void user_should_see_the_remove_button() {
//
//        Helper H1 = new Helper(driver);
//        for (int i = 0; i <= 5; i++) {
//            if (H1.RemoveButton().get(i).getText().equals("Remove")) {
//                System.out.println("Remove button" + i + "is displyed");
//            } else {
//                System.out.println("Remove button" + i + "is not displyed");
//            }
//        }
//        driver.quit();
//    }
//
//
//    @When("user click the product title (\\d+)$")
//    public void user_click_the_product_title(int itemNumber) {
//        Helper H1 = new Helper(driver);
//        smallTitle = H1.TitleButtons().get(itemNumber).getText();
//        H1.TitleButtons().get(itemNumber).click();
//    }
//
//    @Then("user should see the full product view")
//    public void user_should_see_the_full_product_view() {
//
//        Helper H1 = new Helper(driver);
//        if (H1.ProductLargeTitle().getText().equals(smallTitle)) {
//            System.out.println("Navigated to large product view Correctly");
//        } else {
//            System.out.println("Incorrect Navigation to large product view");
//        }
//        driver.quit();
//
//    }
//
//    @When("user click the cart icon")
//    public void user_click_the_cart_icon() {
//        Helper H1 = new Helper(driver);
//        H1.CartBadgeContainer().click();
//
//    }
//
//    @Then("user should see the cart items added to cart")
//    public void user_should_see_the_cart_items_added_to_cart() {
//
//        Helper H1 = new Helper(driver);
//        String[] cartItemNames = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};
//
//        for (int i = 0; i <= 5; i++) {
//
//            if (H1.CartItem().get(i).getText().equals(cartItemNames[i])) {
//                System.out.println(cartItemNames[i] + " : Add to cart successfully");
//            } else {
//                System.out.println(cartItemNames[i] + " : Fail to add to cart");
//            }
//        }
//        driver.quit();
//    }
//
//    @When("user click the remove buttons")
//    public void user_click_the_remove_buttons() {
//        Helper H1 = new Helper(driver);
//
//        for (int i = 0; i <= 5; i++) {
//            H1.RemoveCartButton().get(0).click();
//        }
//    }
//
//    @Then("user should see the cart without removed item")
//    public void user_should_see_the_cart_without_removed_item() {
//        Helper H1 = new Helper(driver);
//        //String [] cartItemNames = {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"};
//
//        if (H1.CartItem().size() != 0) {
//            for (int i = 0; i <= H1.CartItem().size(); i++) {
//
//                System.out.println(H1.CartItem().get(i).getText() + " : Fail to removed from cart");
//            }
//        } else {
//
//            System.out.println("All the items removed from cart successfully");
//
//        }
//        driver.quit();
//    }
//
//    @When("user click the back to products button")
//    public void user_click_the_back_to_products_button() {
//        Helper H1 = new Helper(driver);
//        H1.BackToProductsButton().click();
//    }
//
//    @Then("user should see the product page")
//    public void user_should_see_the_product_page() {
//        Helper H1 = new Helper(driver);
//        boolean titleProduct = H1.TitleProduct().isDisplayed();
//
//        if (titleProduct) {
//
//            System.out.println("Navigated successfully");
//
//        } else {
//
//            System.out.println("Not navigated");
//        }
//        driver.quit();
//    }
//
//    @When("user click the continue shopping button")
//    public void user_click_the_continue_shopping_button() {
//        Helper H1 = new Helper(driver);
//        H1.ContinueShopingButton().click();
//    }
//
//    @When("user click the checkout button")
//    public void user_click_the_checkout_button() {
//        Helper H1 = new Helper(driver);
//        H1.CheckoutButton().click();
//    }
//
//    @Then("user should see the checkout info page")
//    public void user_should_see_the_checkout_info_page() {
//        Helper H1 = new Helper(driver);
//        boolean CheckoutInfo = H1.TitleProduct().isDisplayed();
//        if (CheckoutInfo) {
//
//            System.out.println("Navigated successfully");
//
//        } else {
//
//            System.out.println("Not navigated");
//        }
//        driver.quit();
//    }
//
//    @When("user click the sort ZA")
//    public void user_click_the_sort_za() {
//
//        itemNames = new String[6];
//        Helper H1 = new Helper(driver);
//
//        for (int i = 0; i <= 5; i++) {
//            itemNames[i] = H1.ItemNames().get(i).getText();
//            System.out.println("before sort Item name : " + itemNames[i]);
//        }
//
//        Select se = new Select(H1.SortDropDown());
//
//        se.selectByValue("za");
//    }
//
//    @When("user click the sort AZ")
//    public void user_click_the_sort_az() {
//
//        itemNames = new String[6];
//        Helper H1 = new Helper(driver);
//
//        for (int i = 0; i <= 5; i++) {
//            itemNames[i] = H1.ItemNames().get(i).getText();
//            System.out.println("before sort Item name : " + itemNames[i]);
//        }
//
//        Select se = new Select(H1.SortDropDown());
//
//        se.selectByValue("az");
//    }
//
//    @Then("user should see the ZA sorted products")
//    public void user_should_see_the_ZA_sorted_products() {
//
//        Helper H1 = new Helper(driver);
//        String itemNamesAfterSort[] = new String[6];
//
//        for (int i = 0; i <= 5; i++) {
//            itemNamesAfterSort[i] = H1.ItemNames().get(i).getText();
//            System.out.println("After clicked sort Item name : " + itemNamesAfterSort[i]);
//        }
//        //Arrays.sort(itemNames);
//        Arrays.sort(itemNames, Collections.reverseOrder());
//
//        if (Arrays.equals(itemNames, itemNamesAfterSort)) {
//
//            System.out.println("Sorted correctly Z-A");
//        } else {
//            System.out.println("Incorrectly sorted Z-A");
//        }
//        driver.quit();
//    }
//
//    @Then("user should see the AZ sorted products")
//    public void user_should_see_the_AZ_sorted_products() {
//
//        Helper H1 = new Helper(driver);
//        String itemNamesAfterSort[] = new String[6];
//
//        for (int i = 0; i <= 5; i++) {
//            itemNamesAfterSort[i] = H1.ItemNames().get(i).getText();
//            System.out.println("After clicked sort Item name : " + itemNamesAfterSort[i]);
//        }
//        Arrays.sort(itemNames);
//        if (Arrays.equals(itemNames, itemNamesAfterSort)) {
//
//            System.out.println("Sorted correctly A-Z");
//        } else {
//            System.out.println("Incorrectly sorted A-Z");
//        }
//        driver.quit();
//    }
//
//    @Then("user should see the correct products images")
//    public void user_should_see_the_correct_products_images() {
//
//        Helper H1 = new Helper(driver);
//        String[] imgSrcNames = {"sauce-backpack", "bike-light", "bolt-shirt", "sauce-pullover", "red-onesie", "red-tatt"};
//
//        int j = 1;
//        for (int i = 1; i <= 12; i += 2) {
//            String imgsrc = H1.ItemImg().get(i).getAttribute("src").toString();
//
//
//            if (imgsrc.contains(imgSrcNames[i - j])) {
//                System.out.println("Image is correct : " + imgSrcNames[i - j]);
//            } else {
//                System.out.println("Image source is wrong : " + imgsrc);
//            }
//            j++;
//        }
//        driver.quit();
//    }
//
//    @When("user click the sort low to high")
//    public void user_click_the_sort_low_to_high() {
//        itemPrices = new Float[6];
//        Helper H1 = new Helper(driver);
//
//        for (int i = 0; i <= 5; i++) {
//            itemPrices[i] = Float.parseFloat(H1.ItempRrice().get(i).getText().substring(1));
//            System.out.println("before sort Item price : " + itemPrices[i]);
//        }
//
//        Select se = new Select(H1.SortDropDown());
//
//        se.selectByValue("lohi");
//    }
//
//    @Then("user should see the low to high sorted products")
//    public void user_should_see_the_low_to_high_sorted_products() {
//        Helper H1 = new Helper(driver);
//        Float itemPricesAfterSort[] = new Float[6];
//
//        for (int i = 0; i <= 5; i++) {
//            itemPricesAfterSort[i] = Float.parseFloat(H1.ItempRrice().get(i).getText().substring(1));
//            System.out.println("After clicked sort Item price : " + itemPricesAfterSort[i]);
//        }
//
//        Arrays.sort(itemPrices);
//
//        if (Arrays.equals(itemPrices, itemPricesAfterSort)) {
//
//            System.out.println("Sorted correctly price low to high");
//        } else {
//            System.out.println("Incorrectly sorted price low to high");
//        }
//        for (int i = 0; i <= 5; i++) {
//
//            System.out.println("Aftersort Item price : " + itemPrices[i]);
//        }
//        driver.quit();
//    }
//
//    @When("user click the sort high to low")
//    public void user_click_the_sort_high_to_low() {
//        itemPrices = new Float[6];
//        Helper H1 = new Helper(driver);
//
//        for (int i = 0; i <= 5; i++) {
//            itemPrices[i] = Float.parseFloat(H1.ItempRrice().get(i).getText().substring(1));
//            System.out.println("before sort Item price : " + itemPrices[i]);
//        }
//
//        Select se = new Select(H1.SortDropDown());
//
//        se.selectByValue("hilo");
//    }
//
//    @Then("user should see the high to low sorted products")
//    public void user_should_see_the_high_to_low_sorted_products() {
//        Helper H1 = new Helper(driver);
//        Float itemPricesAfterSort[] = new Float[6];
//
//        for (int i = 0; i <= 5; i++) {
//            itemPricesAfterSort[i] = Float.parseFloat(H1.ItempRrice().get(i).getText().substring(1));
//            System.out.println("After clicked sort Item price : " + itemPricesAfterSort[i]);
//        }
//
//
//        Arrays.sort(itemPrices, Collections.reverseOrder());
//        if (Arrays.equals(itemPrices, itemPricesAfterSort)) {
//
//            System.out.println("Sorted correctly price high to low");
//        } else {
//            System.out.println("Incorrectly sorted price high to low");
//        }
//        for (int i = 0; i <= 5; i++) {
//
//            System.out.println("Aftersort Item price : " + itemPrices[i]);
//        }
//        driver.quit();
//    }


}
