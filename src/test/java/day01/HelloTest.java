package day01;

import day01.Hello;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloTest {

    private  Hello hello;

    @BeforeEach
    public void init(){
        hello = new Hello();
    }

    @Test
    @DisplayName("test sayHello 001")
    public void case001(){
        // arage
        String expected = "day01.Hello Sarun.M";

        // act
       String actual = hello.sayHello("Sarun.M");

       // aasert
        assertEquals(expected, actual);
    }
}
