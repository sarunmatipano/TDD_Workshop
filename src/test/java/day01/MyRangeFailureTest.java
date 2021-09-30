package day01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyRangeFailureTest {

    @Test
    @DisplayName("ทดสอบ InputInvalidException case1")
    public void case01(){
        try {
            MyRange range = new MyRange("1,4]");
            range.validate();
            fail("ไม่ผิด");
        }catch (InputInvalidException e){
            if(!"Input error".equals(e.getMessage())){
                fail("Error message ผิด" + e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("ทดสอบ InputInvalidException case2")
    public void case02(){
        MyRange range = new MyRange("2,5)");
        Exception e = assertThrows(InputInvalidException.class, range::validate);
        assertEquals("Input error",e.getMessage());

    }

}
