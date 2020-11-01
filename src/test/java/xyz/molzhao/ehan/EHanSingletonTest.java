package xyz.molzhao.ehan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EHanSingletonTest {

    @Test
    public void testGetInstance() {
        // Act
        EHanSingleton result1 = EHanSingleton.getInstance();
        EHanSingleton result2 = EHanSingleton.getInstance();

        // Assert
        assertEquals(result1, result2);
    }
}
