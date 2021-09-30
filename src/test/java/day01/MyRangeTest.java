package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyRangeTest {

    @Test
    @DisplayName("case01 start with [ ")
    public  void case01(){
        // Arrange
        String input = "[1,5)";
        MyRange myRange = new MyRange(input);

        // act
        boolean actual = myRange.isStartWithInClude();

        //assert
        assertTrue(actual,"ต้อง start ด้วย [");
    }

    @Test
    @DisplayName("case02 end with ] ")
    public  void case02(){
        // Arrange
        String input = "(1,5]";
        MyRange myRange = new MyRange(input);

        // act
        boolean actual = myRange.isEndWithInClude();

        //assert
        assertTrue(actual,"ต้อง end ด้วย ]");
    }

    @Test
    @DisplayName("case03 start with ( ")
    public  void case03(){
        // Arrange
        String input = "(1,4]";
        MyRange myRange = new MyRange(input);

        // act
        boolean actual = myRange.isStartWithParentheses();

        //assert
        assertTrue(actual,"ต้อง start ด้วย (");
    }

    @Test
    @DisplayName("case04 end with ) ")
    public  void case04(){
        // Arrange
        String input = "[1,4)";
        MyRange myRange = new MyRange(input);

        // act
        boolean actual = myRange.isEndWithParentheses();

        //assert
        assertTrue(actual,"ต้อง end ด้วย )");
    }

    @Test
    @DisplayName("case05 start number ) ")
    public  void case05(){
        // Arrange
        String input = "[1,4)";
        int expected = 1;
        MyRange myRange = new MyRange(input);

        // act
        int actual = myRange.getStart();

        //assert
        assertEquals(expected, actual);
    }

}
