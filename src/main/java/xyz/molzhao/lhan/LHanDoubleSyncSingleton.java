package xyz.molzhao.lhan;

/**
 * 懒汉线程安全方式2：双重检查锁定
 */
public class LHanDoubleSyncSingleton {
    private static LHanDoubleSyncSingleton instance = null;

    private LHanDoubleSyncSingleton() {

    }

    public static LHanDoubleSyncSingleton getInstance() {
        if (null == instance) {
            synchronized (LHanDoubleSyncSingleton.class) {
                if (null == instance) {
                    instance = new LHanDoubleSyncSingleton();
                }
            }
        }
        return instance;
    }
}
