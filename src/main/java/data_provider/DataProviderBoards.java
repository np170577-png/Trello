package data_provider;

import dto.Board;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderBoards {

    @DataProvider
    public Board[] newBoardDataProvider(){
        Board board = Board.builder().boardTitle("Art0").build();
        Board board1 = Board.builder().boardTitle("Art1").build();
        Board board2 = Board.builder().boardTitle("Art2").build();
        return new Board[]{board2, board1, board};
    }

    @DataProvider
    public Iterator<Board> newBoarsDataProviderFile() {
        List<Board> boardList = new ArrayList<>();
        BufferedReader bufRead;
        try {
            bufRead = new BufferedReader(new FileReader("src/main/resources/Boards.csv"));
            String line = bufRead.readLine();
            while(line!=null){
                boardList.add(Board.builder().boardTitle(line).build());
                line = bufRead.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return boardList.iterator();
    }
 }
