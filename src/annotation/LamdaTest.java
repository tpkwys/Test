package annotation;

import java.util.Arrays;
import java.util.List;

/**
 * @author tianpanke
 * @title: LamdaTest
 * @projectName Test
 * @description: TODO
 * @date 2019/7/18 11:33
 */
public class LamdaTest {
    public static void main(String[] args) {
//        new Thread(()-> System.out.println("lamda Thread")).start();
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API",
                "Date and Time API");
        features.forEach(n-> System.out.println(n));

    }
}
