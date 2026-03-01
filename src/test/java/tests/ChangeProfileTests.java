package tests;

import dto.User;
import manager.AppManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AtlassianProfilePage;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class ChangeProfileTests extends AppManager {

    @BeforeMethod
    public void login(){
        User user = User.builder()
                .email("np170577@gmail.com")
                .password("WadiNisnas8%")
                .build();
new HomePage(getDriver()).clickBtnLogin();
new LoginPage(getDriver()).login(user);
    }

    @Test

    public void ChangeFilePhoto(){
new BoardsPage(getDriver()).openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        AtlassianProfilePage atlassianProfilePage =
                new AtlassianProfilePage(getDriver());
        atlassianProfilePage.changeMyProfilePhoto("src/main/resources/zhivotnye_osminog.jpg");
        Assert.assertTrue(atlassianProfilePage.validateMessage(
                "We've uploaded your new avatar. It may take a few minutes to display everywhere."));
    }


}
