/**
 * @author tianpanke
 * @title: VolatileTest
 * @projectName Test
 * @description: volatile关键字学习
 * @date 2019/6/26 16:38
 */
public class VolatileTest {
    public volatile int inc=0;
    public void increase(){
        inc++;
    }
    public static void main(String[] args) throws  Exception{
        final VolatileTest test=new VolatileTest();
        for(int i=0;i<10;i++){
           Thread t1= new Thread(){
                @Override
                public void run() {
                    for(int j=0;j<10000;j++)
                        test.increase();
                }
            };
           t1.start();
           t1.join();
        }
        System.out.println("xxx:"+test.inc);
    }
}
