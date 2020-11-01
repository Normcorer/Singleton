package xyz.molzhao.lhan;

/**
 * 懒汉线程安全方式1：同步
 */
public class LHanSyncSingleton {
    private static LHanSyncSingleton instance = null;

    private LHanSyncSingleton() {
    }

    public static synchronized LHanSyncSingleton getInstance() {
        if (null == instance) {
            instance = new LHanSyncSingleton();
        }
        return instance;
    }
}
