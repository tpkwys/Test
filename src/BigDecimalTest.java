import java.math.BigDecimal;

/**
 * @author tianpanke
 * @title: BigDecimalTest
 * @projectName Test
 * @description:
 * @date 2019/7/18 11:14
 */

/** public BigDecimal(double val)
 * 1.这个构造函数的结果可能有些不可预测。 可以假设在Java中写入new BigDecimal(0.1)创建一个BigDecimal ，它完全等于0.1（非标尺值为1，比例为1），但实际上等于0.1000000000000000055511151231257827021181583404541015625。 这是因为0.1不能像double （或者作为任何有限长度的二进制分数）精确地表示。 因此，正在被传递给构造的值不是正好等于0.1，虽然表面上。
 * 2.该String构造，在另一方面，是完全可以预测的：写new BigDecimal("0.1")创建BigDecimal这正好等于0.1，正如人们所期望的那样。 因此， 一般建议使用String constructor优先于此。
 * 3.当double必须用作源为BigDecimal ，注意，此构造提供了一个精确的转换; 它不会将double转换为String使用Double.toString(double)方法，然后使用BigDecimal(String)构造函数相同的结果。 要获得该结果，请使用static valueOf(double)方法。
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a=new BigDecimal(0.1);
        System.out.println(a);
        BigDecimal b=new BigDecimal("0.1");
        System.out.println(b);
    }
}
