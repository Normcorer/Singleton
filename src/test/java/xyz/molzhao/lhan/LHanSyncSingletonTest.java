package xyz.molzhao.lhan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LHanSyncSingletonTest {
    @Test
    public void testGetInstance() {
        // Act
        LHanSyncSingleton result1 = LHanSyncSingleton.getInstance();
        LHanSyncSingleton result2 = LHanSyncSingleton.getInstance();

        // Assert
        assertEquals(result1, result2);
    }
}
