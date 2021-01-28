package singleton;

/**
 * 懒汉式（懒加载）
 * 线程不安全
 */
public class Singleton02 {
    private static Singleton02 INSTANCE;

//    构造方法私有化
    private Singleton02(){};

    public static Singleton02 getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
       for (int i = 0;i<100;i++){
           new Thread(()->{
               System.out.println(Singleton02.getInstance().hashCode());
           }).start();
       }
    }

}
