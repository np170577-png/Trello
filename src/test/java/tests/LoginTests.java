package tests;

import dto.User;
import manager.AppManager;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {

    @Test
    public void loginPositiveTest() {
        User user = User.builder()
                .email("np170577@gmail.com")
                .password("WadiNisnas8%")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Assert.assertTrue(new BoardsPage(getDriver()).validateURL("boards"));
    }

    @Test
    public void loginNegativeTest() {
        User user = User.builder()
                .email("np170577@gmail.com")
                .password("WadiNisnas8%")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Assert.assertFalse(new BoardsPage(getDriver()).validateURLWithException("upsd"));
    }

    @Test(expectedExceptions = TimeoutException.class)
    public void loginNegativeTestAnother() {
        User user = User.builder()
                .email("np170577@gmail.com")
                .password("WadiNisnas8%")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        new BoardsPage(getDriver()).validateURL("updc");
    }
}
