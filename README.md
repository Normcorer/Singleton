## 前言
单例模式（Singleton Pattern）是我们最常用的一种设计模式，也是最简单的设计模式，作为后端程序员来说是必须要会的，今天我准备整理一下五种单例模式的写法。
***

## 概念
1.单例模式属于创建型模式，主要解决一个全局使用的类被频繁创建和销毁。
2.单例模式确保某个类只有一个实例，在计算机系统中，线程池，缓存，日志对象等常被设计成单例模式，这些应用或多或少会具有资源管理器的功能。
***

## 特点
**优点：**
1.在内存中只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例。
2.避免对资源的多重占用（比如写文件操作）。

**缺点：**
1.没有接口，无法继承，和单一职责原则冲突，一个类应该只关心内部的逻辑，而不关心外面怎么来实例化。
***

## 实现方式

### 懒汉式（线程不安全）

所谓懒汉：`即懒加载：用到才初始化`，这种方式是最基本的实现方式，这种实现最大的问题就就是不支持多线程。在多线程的环境下可能会生成多个实例对象。
```java
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

```

### 懒汉式（同步锁）
这种方式具备了`懒加载`，能够在多线程中很好的工作，但是效率很低，因为99%的情况下不需要同步，影响效率。
```java
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
```

### 懒汉式（双重校验）
这种方式具备了`懒加载`，相对于上一种同步锁的方式来说，做了两次null检查，确保了只有第一次调用单例的时候才会做同步，这样也是线程安全的，同时避免了每次都同步的性能损耗。
```java
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
```

### 静态内部类方式
相对于以上两种方式，利用了classloader的机制来保证初始化instance时只有一个线程，所以也是线程安全的，同时没有性能损耗，这种方式为最佳。
```java
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
```

### 饿汉式
饿汉式在类创建时同时已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
```java
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
```
***

## 区别
**单例模式主要分为懒汉和饿汉式两种：**
1.饿汉就是类一旦加载，就把单例初始化完成，不管之后会不会使用这个实例，都会占据一定的内存，但是相应的在第一次调用时速度很快。
2.懒汉式只有在调用`getInstance()`的时候，才会去初始化这个单例。

**线程安全：**
1.饿汉式天生线程安全。
2.懒汉式本身不是线程安全的，为了实现线程安全有几种写法，分别是以上几种。

**资源加载和性能：**
1.饿汉占资源但是调用速度快，懒汉不占资源，第一次初始化调用慢。
2.懒汉同步性能问题：同步 > 双重校验 > 静态内部类。
***

> 如果有小伙伴，想要一起交流学习的，欢迎添加博主微信。

![weChat](https://molzhao-pic.oss-cn-beijing.aliyuncs.com/Common/WeChat.png)




