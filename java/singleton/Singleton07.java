package singleton;

/**
 * 枚举单例:不仅可以解决线程同步问题，还可以实现反序列化
 */
public enum Singleton07 {
    INSTANCE;


    public static void main(String[] args) {
        for (int i = 0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton07.INSTANCE.hashCode());
            }).start();
        }
    }
}
