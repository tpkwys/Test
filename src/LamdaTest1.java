import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tianpanke
 * @title: LamdaTest1
 * @projectName Test
 * @description:
 * @date 2019/7/19 10:01
 */
public class LamdaTest1 {
    public static void main(String[] args) {
        List<String> data= Arrays.asList("dqweqw","12d","eweqw","1","");
        List<String> filtered=data.stream().filter(x->x.length()>4).collect(Collectors.toList());
        System.out.println(data);
        System.out.println(filtered);


       String result=data.stream().map(x->x.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(result);

        List<Integer> primes=Arrays.asList(2,3,5,7,11,13,17,19,23,29);
        IntSummaryStatistics statistics=primes.stream().mapToInt((x)->x).summaryStatistics();
        System.out.println("max:"+statistics.getMax());
        System.out.println("min:"+statistics.getMin());
        System.out.println("sum:"+statistics.getSum());
        System.out.println("avarage:"+statistics.getAverage());
    }
}
