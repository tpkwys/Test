import java.util.Random;

/**
 * @author tianpanke
 * @title: TestFinal
 * @projectName Test
 * @description: TODO
 * @date 2019/7/29 9:21
 */
public class TestFinal {
    private final int m=getM();
    public static void main(String[] args) {
        System.out.println(new TestFinal().m);
        System.out.println(new TestFinal().m);
        System.out.println(new TestFinal().m);
        System.out.println(new TestFinal().m);
    }
    private static int getM(){
        return new Random().nextInt(10);
    }
}
