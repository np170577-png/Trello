package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

import java.util.Random;

public class DeleteBoardTests extends AppManager {
    BoardsPage boardsPage;

    @BeforeMethod
    public void loginAndCreateBoard(){
     User user = User.builder()
             .email("np170577@gmail.com")
             .password("WadiNisnas8%")
             .build();
     new HomePage(getDriver()).clickBtnLogin();
     new LoginPage(getDriver()).login(user);

     boardsPage = new BoardsPage(getDriver());

     int i = new Random().nextInt(1000);
        Board board = Board.builder()
                .boardTitle("Arts" + i)
                .build();
        boardsPage.createNewBoard(board);
        boardsPage.clickBtnCreate();
    }

    @Test
    public void deleteBoardPositiveTest(){
        new MyBoardPage(getDriver()).deleteBoard();
        Assert.assertTrue(boardsPage.validatePopUpMessage("Board deleted."));

    }
}
