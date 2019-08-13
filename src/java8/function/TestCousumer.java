package java8.function;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

/**
 * @author tianpanke
 * @title: TestCousumer
 * @projectName Test
 * @description: consumer接口是一个消费型的接口，通过传入参数，然后输出值
 * @date 2019/8/5 9:40
 */
public class TestCousumer {
    public static void main(String[] args) {
        //1.使用consumer接口实现方法
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);

            }
        };
        Stream<String> stream=Stream.of("aaa","bbb","ccc","ddd");
        stream.forEach(consumer);
        System.out.println("********************");
        //2.使用lambda表达式，forEach方法需要的就是一个Consumer接口
        stream=Stream.of("aaaa","bbbb","cccc","dddd");
        Consumer<String> consumer1=(s)-> System.out.println(s);//lambda返回的就是一个Consumer接口
        stream.forEach(consumer1);
        System.out.println("********************");

        //3.更直接的方式
        stream=Stream.of("aaaaa","bbbbb","ccccc","ddddd");
        stream.forEach((s)-> System.out.println(s));
        System.out.println("********************");

        //4.使用方法引用，方法引用也是一个consumer
        stream=Stream.of("aaaaaa","bbbbbb","cccccc","dddddd");
        Consumer consumer2=System.out::println;
        stream.forEach(consumer2);
        System.out.println("********************");

        //5.更直接的方法
        stream=Stream.of("aaaaaa","bbbbbb","cccccc","dddddd");
        stream.forEach(System.out::println);
        IntConsumer intConsumer=new IntConsumer() {
            @Override
            public void accept(int value) {

            }
        };


    }
}
//总结： 1.Consumer 是一个接口，并且只要实现一个accept方法，就可以作为消费者输出信息
//       2.lambda表达式、方法引用的返回值就是一个Consumer类型，所以他们能够作为forEach方法的参数，并且输出一个值

