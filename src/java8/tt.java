package java8;

import java.math.BigDecimal;

/**
 * @author tianpanke
 * @title: tt
 * @projectName Test
 * @description: TODO
 * @date 2019/8/5 9:40
 */
public class tt {
    public static void main(String[] args) {
//        System.out.println("01234".substring(0,4));
//        System.out.println(String.format("%s,你好%s",1,2));
        BigDecimal bigDecimal=BigDecimal.ZERO;
        BigDecimal bigDecimal1=BigDecimal.ZERO;
        bigDecimal1=bigDecimal1.add(new BigDecimal(1.0));
        System.out.println(bigDecimal1.floatValue());
    }
}
