package singleton;

/**
 * 懒汉式（懒加载）
 * 加锁，线程安全
 * 效率变低
 */
public class Singleton03 {
    private static Singleton03 INSTANCE;

//    构造方法私有化
    private Singleton03(){};

    public static synchronized Singleton03 getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
       for (int i = 0;i<100;i++){
           new Thread(()->{
               System.out.println(Singleton03.getInstance().hashCode());
           }).start();
       }
    }

}
