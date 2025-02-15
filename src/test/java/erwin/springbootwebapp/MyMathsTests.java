package erwin.springbootwebapp;

import erwin.springbootwebapp.JUnit.MyMaths;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@MockitoSettings
public class MyMathsTests {

    private final MyMaths myMaths=new MyMaths();

    @Test
    void CalculateThreeSum(){
        assertEquals(10, myMaths.calcualateSum(new int[]{1,2,3,4}));
        System.out.println("Passed");
    }

    @Test
    void CalculateSum(){
        assertEquals(0, myMaths.calcualateSum(new int[]{}));
    }

    private final List<String> todos = Arrays.asList("Aws","GCP");

    @Test
    void Test(){
        boolean test = todos.contains("Aws");
        boolean test1 = todos.contains("Azure");
        assertTrue(test);
        assertFalse(test1);

    }

}
