package xyz.molzhao.ehan;

/**
 * 饿汉式单例类，在类初始化时，已经自行实例化
 * 饿汉式在类创建的同时就已经创建好一个静态的对象，以后不再改变，所有天生是线程安全的
 */
public class EHanSingleton {
    private static final EHanSingleton instance = new EHanSingleton();

    private EHanSingleton() {

    }

    public static EHanSingleton getInstance() {
        return instance;
    }
}
