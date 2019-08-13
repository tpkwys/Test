package java8.function;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tianpanke
 * @title: TestPredicate1
 * @projectName Test
 * @description:
 * @date 2019/8/5 10:30
 */
public class TestPredicate1 {
    public static void main(String[] args) {
        Predicate<Integer> predicate=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer>5)
                     return  true;
                return false;
            }
        };
        Stream<Integer> stream=Stream.of(1,34,2,6,9,4);
        List<Integer> list=stream.filter(predicate).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
// 总结：1.Predicate 是一个谓词型接口，其实只是起到一个判断作用
//       2.Predicate通过实现一个test方法做判断