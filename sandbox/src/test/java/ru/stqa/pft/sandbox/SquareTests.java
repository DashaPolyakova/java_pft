package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by fbi on 11.08.2017.
 */
public class SquareTests {

@Test
    public void TestArea() {
        Square s = new Square(5);
    Assert.assertEquals(s.area(), 25.0);
    }

}
