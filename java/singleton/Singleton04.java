package singleton;

/**
 * 懒汉式（懒加载）
 * 加锁，通过减小同步代码块的方式加锁，线程不安全
 */
public class Singleton04 {
    private static Singleton04 INSTANCE;

//    构造方法私有化
    private Singleton04(){};

    public static Singleton04 getInstance(){
        if (INSTANCE == null){
//             减小加锁的同步代码块，不可行
            synchronized (Singleton04.class){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton04();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
       for (int i = 0;i<100;i++){
           new Thread(()->{
               System.out.println(Singleton04.getInstance().hashCode());
           }).start();
       }
    }

}
