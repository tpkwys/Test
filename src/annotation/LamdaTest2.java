package annotation;

import java.util.Arrays;
import java.util.List;

/**
 * @author tianpanke
 * @title: LamdaTest2
 * @projectName Test
 * @description:
 * @date 2019/7/18 15:59
 */
public class LamdaTest2 {
    public static void main(String[] args) {
        List<Integer> costBeforeTax= Arrays.asList(100,200,300,400,500);
//        for(Integer cost:costBeforeTax){
//            double price=cost+.12*cost;
//            System.out.println(price);
//        }
//        costBeforeTax.stream().map((cost)->cost+.12*cost).forEach(System.out::println);
//        double total=0;
//        for(Integer cost:costBeforeTax){
//            double price=cost+.12*cost;
//            total=total+price;
//        }
//        System.out.println("Total:"+total);

        double bill=costBeforeTax.stream().map((cost)->cost+.12*cost)
                .reduce((sum,cost)->sum+cost).get();
        System.out.println("total:"+bill);
    }
}
