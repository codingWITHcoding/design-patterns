package singleton;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.nio.channels.Pipe;

/**
 * 静态内部类方式
 * JVM保证线程安全
 * 加载外部类时不会加载内部类，实现懒加载
 */
public class Singleton06 {
    private static Singleton06 INSTANCE;

//    静态内部类（外部类加载时它不会加载）
    public static class SingletonHandler {
        private final static Singleton06 INSTANCE = new Singleton06();
    }

//    构造方法私有化
    private Singleton06(){};

//    获取类时直接取静态内部类的静态方法，实现懒加载
    public static Singleton06 getInstance(){
        return SingletonHandler.INSTANCE;
    }

    public static void main(String[] args) {
       for (int i = 0;i<100;i++){
           new Thread(()->{
               System.out.println(Singleton06.getInstance().hashCode());
           }).start();
       }
    }

}
