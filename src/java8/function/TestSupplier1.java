package java8.function;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author tianpanke
 * @title: TestSupplier1
 * @projectName Test
 * @description:
 * @date 2019/8/5 10:07
 */
public class TestSupplier1 {
    public static void main(String[] args) {
        Stream<Integer> stream=Stream.of(1,2,3,4,5);
        //返回一个optional对象
        Optional<Integer> first=stream.filter(i->i>4)
                .findFirst();
        //optional 对象有需要Supplier接口的方法
        //orElse,如果first中存在数，就返回值，如果不存在就返回传入的数
        System.out.println(first.orElse(1));
        System.out.println(first.orElse(7));
        Supplier<Integer> supplier=new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        };
        //orElseGet:如果first中存在数，就返回这个数，如果不存在，就返回supplier返回的值
        System.out.println(first.orElseGet(supplier));

    }
}
// 总结： 1.Supplier接口可以理解为一个容器，用于装数据的。
//        2.Supplier接口有一个get方法，可以返回值