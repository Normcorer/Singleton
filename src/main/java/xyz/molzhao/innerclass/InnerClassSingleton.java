package xyz.molzhao.innerclass;

/**
 * 静态内部类：这种比懒汉的线程安全两种方式好一点，既实现类线程安全，又避免了同步带来的性能影响
 */
public class InnerClassSingleton {
    private InnerClassSingleton() {

    }

    public static final InnerClassSingleton getInstance() {
        return InnerClass.instance;
    }

    private static class InnerClass {
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }
}
