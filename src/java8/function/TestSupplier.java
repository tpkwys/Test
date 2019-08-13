package java8.function;


import java.util.Random;
import java.util.function.Supplier;

/**
 * @author tianpanke
 * @title: TestSupplier
 * @projectName Test
 * @description: supplier接口是一个供给型的接口，其实说白了就是一个容器，可以用来存储数据，然后可以供其他方法使用的这么一个接口。
 * @date 2019/8/5 9:58
 */
public class TestSupplier {
    public static void main(String[] args) {
        //1.使用Supplier接口实现方法，只有一个get方法，无参数，返回一个值
        Supplier<Integer> supplier=new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        };
        System.out.println(supplier.get());
        System.out.println("********************");
        //2.使用lambda表达式
        supplier=()->new Random().nextInt(10);
        System.out.println(supplier.get());
        System.out.println("********************");
        //3.使用方法引用
        Supplier<Double> supplier1=Math::random;
        System.out.println(supplier1.get());

    }
}
