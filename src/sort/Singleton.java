package sort;

/**
 * @author dengyouquan
 **/
public class Singleton {

}

//饿汉式
class Singleton1 {
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
        throw new IllegalStateException();
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}

//懒汉式-线程安全
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
        throw new IllegalStateException();
    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

//双重锁校验
class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {
        throw new IllegalStateException();
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

//静态内部类式
class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {
        throw new IllegalStateException();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static Singleton4 INSTANCE = new Singleton4();
    }
}

enum Singleton5 {
    INSTANCE;
}