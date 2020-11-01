package xyz.molzhao.innerclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InnerClassSingletonTest {
    @Test
    public void testGetInstance() {
        // Act
        InnerClassSingleton result1 = InnerClassSingleton.getInstance();
        InnerClassSingleton result2 = InnerClassSingleton.getInstance();

        // Assert
        assertEquals(result1, result2);
    }
}
