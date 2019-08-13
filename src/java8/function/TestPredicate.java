package java8.function;

import java.util.function.Predicate;

/**
 * @author tianpanke
 * @title: TestPredicate
 * @projectName Test
 * @description: predicate
 * @date 2019/8/5 10:22
 */
public class TestPredicate {
    public static void main(String[] args) {
        //1.使用predicate接口实现方法，只有一个test方法，传入一个参数就返回一个bool值
        Predicate<Integer> predicate=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer>5)
                    return true;
                return false;
            }
        };
        System.out.println(predicate.test(6));
        System.out.println(predicate.test(5));
        //2.使用lambda表达式
        predicate=(t)->t>5;
        System.out.println(predicate.test(7));

    }
}
