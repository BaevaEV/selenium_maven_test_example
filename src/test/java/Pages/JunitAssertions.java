package Pages;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class JunitAssertions {
    @Test
    public void testEquals1()
    {
//Тест пройдёт
        Assertions.assertEquals(4, 2+2);
    }

    @Test
    public void testEquals2()
    {
//Тест не пройдёт
        Assertions.assertEquals(3, 2+2, "Calculator 2+2 test failed");
    }

    @Test
    public void testNotEquals1()
    {
//Тест пройдёт
        Assertions.assertNotEquals(3, 2+2);
    }

    @Test
    public void testNotEquals2()
    {
//Тест не пройдёт
        Assertions.assertNotEquals(4, 2+2, "Calculator 2+2 test failed");
    }



}
