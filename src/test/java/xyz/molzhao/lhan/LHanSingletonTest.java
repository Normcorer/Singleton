package xyz.molzhao.lhan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LHanSingletonTest {
    @Test
    public void testGetInstance() {
        // Act
        LHanSingleton result1 = LHanSingleton.getInstance();
        LHanSingleton result2 = LHanSingleton.getInstance();

        // Assert
        assertEquals(result1, result2);
    }
}
