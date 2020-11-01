package xyz.molzhao.lhan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LHanDoubleSyncSingletonTest {
    @Test
    public void testGetInstance() {
        // Act
        LHanDoubleSyncSingleton result1 = LHanDoubleSyncSingleton.getInstance();
        LHanDoubleSyncSingleton result2 = LHanDoubleSyncSingleton.getInstance();

        // Assert
        assertEquals(result1, result2);
    }
}
