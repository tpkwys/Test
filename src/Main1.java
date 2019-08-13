import java.math.BigDecimal;

/**
 * @author tianpanke
 * @title: Main1
 * @projectName Test
 * @description:
 * @date 2019/7/10 13:45
 */
public class Main1 {
    public static void main(String[] args) {
        BigDecimal testNumber1=new BigDecimal(0.322);
        BigDecimal testNumber2=new BigDecimal(0.328);
        BigDecimal testNumber5=new BigDecimal(0.325);

        BigDecimal testNumber3=new BigDecimal(-0.322);
        BigDecimal testNumber4=new BigDecimal(-0.328);
        BigDecimal testNumber6=new BigDecimal(-0.325);
        //ROUND_DOWM (截断操作，不改变原始数据对象) 该模式永远不会增加被操作数的值,只保留到精度位
        System.out.println("截端操作1:"+testNumber1.setScale(2,BigDecimal.ROUND_DOWN));
        System.out.println("截端操作2:"+testNumber2.setScale(2,BigDecimal.ROUND_DOWN));
        System.out.println("截端操作3:"+testNumber3.setScale(2,BigDecimal.ROUND_DOWN));
        System.out.println("截端操作4:"+testNumber4.setScale(2,BigDecimal.ROUND_DOWN));

        //ROUND_UP(增端操作,不改变原始数据对象) 该模式永远不会减少被操作的数的值,在精度位增加一个单位(无论正负)

        System.out.println("增端操作1:"+testNumber1.setScale(3,BigDecimal.ROUND_UP));
        System.out.println("增端操作2:"+testNumber2.setScale(3,BigDecimal.ROUND_UP));
        System.out.println("增端操作3:"+testNumber3.setScale(3,BigDecimal.ROUND_UP));
        System.out.println("增端操作4:"+testNumber4.setScale(3,BigDecimal.ROUND_UP));

        //ROUND_CEILING(天花板) 朝正无穷方向 round 如果为正数和round_up一样，如果为负数行为和round_down一样

        System.out.println("天花板操作1:"+testNumber1.setScale(3,BigDecimal.ROUND_CEILING));
        System.out.println("天花板操作2:"+testNumber2.setScale(3,BigDecimal.ROUND_CEILING));
        System.out.println("天花板操作3:"+testNumber3.setScale(3,BigDecimal.ROUND_CEILING));
        System.out.println("天花板操作4:"+testNumber4.setScale(3,BigDecimal.ROUND_CEILING));

        //ROUND_FLOOR(地板) 朝负无穷方向 如果为正数行为和round_down一样，如果为负数和round_up一样

        System.out.println("地板操作1:"+testNumber1.setScale(3,BigDecimal.ROUND_FLOOR));
        System.out.println("地板操作2:"+testNumber2.setScale(3,BigDecimal.ROUND_FLOOR));
        System.out.println("地板操作3:"+testNumber3.setScale(3,BigDecimal.ROUND_FLOOR));
        System.out.println("地板操作4:"+testNumber4.setScale(3,BigDecimal.ROUND_FLOOR));

        //ROUND_HALL_UP (四舍五入)
        System.out.println("四舍五入操作1:"+testNumber1.setScale(2,BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入操作2:"+testNumber2.setScale(2,BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入操作3:"+testNumber3.setScale(2,BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入操作4:"+testNumber4.setScale(2,BigDecimal.ROUND_HALF_DOWN));
        System.out.println("四舍五入操作5:"+testNumber5.setScale(2,BigDecimal.ROUND_HALF_DOWN));
        System.out.println("四舍五入操作6:"+testNumber6.setScale(2,BigDecimal.ROUND_HALF_DOWN));


        //ROUND_HALL_DOWN
        System.out.println("四舍五入操作1:"+testNumber1.setScale(2,BigDecimal.ROUND_HALF_DOWN));
        System.out.println("四舍五入操作2:"+testNumber2.setScale(2,BigDecimal.ROUND_HALF_DOWN));
        System.out.println("四舍五入操作3:"+testNumber3.setScale(2,BigDecimal.ROUND_HALF_DOWN));
        System.out.println("四舍五入操作4:"+testNumber4.setScale(2,BigDecimal.ROUND_HALF_DOWN));
        System.out.println("四舍五入操作5:"+testNumber5.setScale(2,BigDecimal.ROUND_HALF_DOWN));
        System.out.println("四舍五入操作6:"+testNumber6.setScale(2,BigDecimal.ROUND_HALF_DOWN));




//        //ROUND_CEILING (天花板) 在精度最后一位增加一个单位
//        System.out.println(.setScale(2,BigDecimal.ROUND_CEILING));
//        System.out.println(new BigDecimal(-0.321).setScale(2,BigDecimal.ROUND_CEILING));

    }
}
