import java.math.BigDecimal;

/**
 * @author tianpanke
 * @title: FloatPrimitiveTest
 * @projectName Test
 * @description: Java 语言支持两种基本的浮点类型： float 和 double ，以及与它们对应的包装类 Float 和 Double 。
 * 它们都依据 IEEE 754 标准，该标准用科学记数法以底数为 2 的小数来表示浮点数。但浮点运算很少是精确的。虽然一些
 * 数字可以精确地表示为二进制小数，比如说 0.5，它等于 2-1；但有些数字则不能精确的表示，比如说 0.1。因此，浮点运
 * 算可能会导致舍入误差，产生的结果接近但并不等于我们希望的结果。
 * @date 2019/7/18 10:57
 */
public class FloatPrimitiveTest {
    public static void main(String[] args) {
        float a=1.0f-0.9f;
        float b=0.9f-0.8f;
        System.out.println(a);
        System.out.println(b);
        if(a==b){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

        //包装器并不能解决精度问题
        Float a1=Float.valueOf(1.0f-0.9f);
        Float b1=Float.valueOf(0.9f-0.8f);
        System.out.println(a1);
        System.out.println(b1);
        if(a1.equals(b1)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
