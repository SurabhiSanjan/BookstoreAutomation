package com.QapitolQA;
import com.QapitolQA.base.BaseClass;
import com.QapitolQA.base.RegisterDataProvider;
import com.QapitolQA.pages.*;
import com.QapitolQA.screenshot.TakeScreenShot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BookStoreAutoTest extends BaseClass {
    LoginPage loginTest;
    SignUpPage user;
    HomePage home;
    ProductPage productTest;
    CartPage cart;
    AddressPage address;
    PaymentPage payment;
    PlaceOrderPage orderItem;
    OrderSumPage summary;
    Profile updateProfile;
    TakeScreenShot Shot;

    @BeforeMethod
    public void initialization() throws FileNotFoundException {
        setup();
        loginTest = new LoginPage(driver);
        user = new SignUpPage(driver);
        home = new HomePage(driver);
        productTest = new ProductPage(driver);
        cart = new CartPage(driver);
        address = new AddressPage(driver);
        payment = new PaymentPage(driver);
        orderItem = new PlaceOrderPage(driver);
        summary = new OrderSumPage(driver);
        updateProfile = new Profile(driver);
        Shot = new TakeScreenShot();
    }

    @Test(priority = 0)
    public void bookstoreE2E() throws InterruptedException {
        driver.get("http://139.59.27.246:3000/");
        user.registerPage();
        user.pageValidate();
        user.registration();
        loginTest.pageValidate();
        loginTest.login();
        home.pageValidate();
        home.selectBook();
        productTest.bookValidate();
        productTest.addProduct();
        cart.pageValidate();
        cart.productCheckout();
        address.pageValidate();
        address.addAddress();
        address.proceedToPay();
        payment.pageValidate();
        payment.addCard();
        orderItem.pageValidate();
        orderItem.placeOrder();
        summary.pageValidate();
        summary.getOrderID();
        loginTest.logout();
    }

    @Test(priority = 1)
    public void updateProfile() throws InterruptedException, AWTException, IOException {
        driver.get("http://139.59.27.246:3000/login");
        loginTest.pageValidate();
        loginTest.login();
        home.pageValidate();
        updateProfile.update();
        Shot.screenshot();
        Thread.sleep(4000);
        loginTest.logout();
    }

    @Test(priority = 2)
    public void chkOrderDetails() throws InterruptedException, IOException {
        driver.get("http://139.59.27.246:3000/login");
        loginTest.pageValidate();
        loginTest.login();
        home.pageValidate();
        updateProfile.details();
        Shot.screenshot();
        loginTest.logout();
    }

    @Test(priority = 3)
    public void productReview() throws InterruptedException {
        driver.get("http://139.59.27.246:3000/login");
        loginTest.pageValidate();
        loginTest.login();
        home.pageValidate();
        home.selectBook();
        productTest.bookValidate();
        productTest.addReview();
        loginTest.logout();
    }

    @Test(priority = 4)
    public void validateReview() throws InterruptedException, IOException, AWTException {
        driver.get("http://139.59.27.246:3000/login");
        loginTest.pageValidate();
        loginTest.login();
        home.pageValidate();
        home.selectBook();
        productTest.reviewValidate();
        Shot.screenshot();
        loginTest.logout();
    }

    @Test(priority = 5)
    public void editReview() throws InterruptedException, IOException {
        driver.get("http://139.59.27.246:3000/login");
        loginTest.pageValidate();
        loginTest.login();
        home.pageValidate();
        home.selectBook();
        productTest.bookValidate();
        productTest.addReview();
        productTest.editReview_Rating();
        Shot.screenshot();
        loginTest.logout();
    }

    @Test(priority = 6)
    public void validateEditedReview() throws InterruptedException, AWTException, IOException {
        driver.get("http://139.59.27.246:3000/login");
        loginTest.pageValidate();
        loginTest.login();
        home.pageValidate();
        home.selectBook();
        productTest.editedReviewValidate();
        Shot.screenshot();
        loginTest.logout();
    }

    @Test(priority = 7)
    public void chkProductQty() throws InterruptedException {
        driver.get("http://139.59.27.246:3000/login");
        loginTest.pageValidate();
        loginTest.login();
        home.pageValidate();
        home.selectBook();
        productTest.changeQty();
        loginTest.logout();
    }

    @Test(priority = 8)
    public void checkRollBack() throws InterruptedException {
        driver.get("http://139.59.27.246:3000/login");
        loginTest.pageValidate();
        loginTest.login();
        home.pageValidate();
        home.selectBook();
        productTest.pageBack();
        loginTest.logout();
    }

    @Test(priority = 9, dataProvider = "data-provider", dataProviderClass = RegisterDataProvider.class)
    public void registrationnegativesceen(String username, String name, String email, String pass, String confirm) throws InterruptedException, AWTException {
        driver.get("http://139.59.27.246:3000/");
        user.registerPage();
        user.pageValidate();
        user.negativeRegister(username, name, email, pass, confirm);
        loginTest.logout();
    }

    @AfterMethod
    public void finished() {
        closeWindow();
    }
}
