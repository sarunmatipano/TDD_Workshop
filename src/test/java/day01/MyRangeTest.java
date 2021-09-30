package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyRangeTest {

    private MyRange myRange;

    @BeforeEach
    public void initial(){
        myRange = new MyRange();
    }

    @Test
    @DisplayName("case01 start with [ ")
    public  void case01(){
        // Arrange
        String input = "[";

        // act
        boolean actual = myRange.startWithInClude(input);

        //assert
        assertTrue(actual,"ต้อง start ด้วย [");
    }
}
