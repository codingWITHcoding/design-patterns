package singleton;

/**
 * 懒汉式（懒加载）
 * 加锁，通过减小同步代码块的方式加锁，双重判断线程安全，
 */
public class Singleton05 {
//     使用这种写法还需要加上volatile
    private static volatile Singleton05 INSTANCE;

//    构造方法私有化
    private Singleton05(){};

    public static Singleton05 getInstance(){
        if (INSTANCE == null){
//             减小加锁的同步代码块，双重判断，可行
            synchronized (Singleton05.class){
                if (INSTANCE == null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton05();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
       for (int i = 0;i<100;i++){
           new Thread(()->{
               System.out.println(Singleton05.getInstance().hashCode());
           }).start();
       }
    }

}
