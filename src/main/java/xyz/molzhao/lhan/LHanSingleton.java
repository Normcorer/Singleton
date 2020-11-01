package xyz.molzhao.lhan;

/**
 * 懒汉式单例的实现没有考虑线程安全问题，它是线程不安全的，并发环境下很可能出现多个Singleton实例
 */
public class LHanSingleton {
    private static LHanSingleton instance = null;

    private LHanSingleton() {

    }

    public static LHanSingleton getInstance() {
        if (null == instance) {
            instance = new LHanSingleton();
        }
        return instance;
    }
}
