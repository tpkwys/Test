import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author tianpanke
 * @title: LambdaTest
 * @projectName Test
 * @description:
 * @date 2019/6/26 15:09
 */
public class LambdaTest {


    public static void main(String[] args) {

      LambdaTest test=new LambdaTest();
       //有参数类型
        MathOperation addition=(int a,int b)->a+b;
        addition.testDefaultMethod();
        //无参数类型
        MathOperation subtraction=(a,b)->a-b;
        //有花括号，有renturn关键字
        MathOperation multiplication=(int a,int b)->{
            return  a+b;
        };
        //无花括号，无return关键字，单一表达式情况
        MathOperation division=(int a,int b)->a/b;
        System.out.println("10+5="+test.operate(10,5,addition));
        System.out.println("10-5="+test.operate(10,5,subtraction));
        System.out.println("10*5="+test.operate(10,5,multiplication));
        System.out.println("10/5="+test.operate(10,5,division));
        //有括号
        GreetingService greetingService1=message -> System.out.println("hello"+message);
        //无括号，单个参数
        GreetingService greetingService2=message -> System.out.println("hello"+message);
        //GreetingService调用情况
        greetingService1.sayMessage("tom");
        greetingService2.sayMessage("cat");
        //有括号，无参数情况
        Runnable runnable=()-> System.out.println("running");
        runnable.run();
    }
    //内部接口,所谓的函数式接口，当然首先是一个接口，然后就是在这个接口里面只能有一个抽象方法。
    // @FunctionalInterface，主要用于编译级错误检查，加上该注解，当你写的接口不符合函数式接口定义的时候，编译器会报错。打开方法2之前
    //的注释符号，编译器报错
    //函数式接口举例：
    //java.lang.Runnable,
    //java.awt.event.ActionListener,
    //java.util.Comparator,
    //java.util.concurrent.Callable
    //java.util.function包下的接口，如Consumer、Predicate、Supplier等
    @FunctionalInterface
    interface MathOperation{
        int operation(int a,int b);
        //一山不能容二虎，根据函数式接口的定义可知，不能同时包含两个或以上的抽象方法
        //int operation(1);
        //函数式接口里是可以包含默认方法，因为默认方法不是抽象方法，其有一个默认实现，所以是符合函数式接口的定义的；
        default void testDefaultMethod(){
            System.out.println("我是函数式接口里面一个默认方法，hahaha,惊讶吧？");
        }
        //函数式接口里是可以包含静态方法，因为静态方法不能是抽象方法，是一个已经实现了的方法，所以是符合函数式接口的定义的；
        static void printHello(){
            System.out.println("我是函数式接口里面一个静态方法，hahaha,惊讶吧？");
        }
        //函数式接口里是可以包含Object里的public方法，这些方法对于函数式接口来说，不被当成是抽象方法（虽然它们是抽象方法）；
        // 因为任何一个函数式接口的实现，默认都继承了Object类，包含了来自java.lang.Object里对这些抽象方法的实现；
        @Override
        boolean equals(Object obj);

    }
    interface  GreetingService{
        void sayMessage(String message);
    }
    interface Runnable{
        void run();
    }
    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}