package annotation;

/**
 * @author tianpanke
 * @title: TestDeprecated
 * @projectName Test
 * @description: 测试java预置注解 deprecated
 * @date 2019/6/28 10:43
 */
public class TestDeprecated {
    @Deprecated
    public void sayHello(){
        System.out.println("hello");
    }
    public void sayHi(){
        System.out.println("Hi");
    }
}
