package java8.function;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author tianpanke
 * @title: TestFunction
 * @projectName Test
 * @description: function接口是一个功能型接口，它的一个作用就是转换功能，将输入数据转为另一种形式的输出数据
 * @date 2019/8/5 10:36
 */
public class TestFunction {
    public static void main(String[] args) {
        Function<String,Integer> function=new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        Stream<String> stream=Stream.of("aaa","bbbb","dad");
        Stream<Integer> stream1=stream.map(function);
        stream1.forEach(System.out::println);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

    }
}
//总结： 1.Function接口是一个功能型接口，起到一个转换数据的作用
//       2.Function 接口实现apply方法来作转换
