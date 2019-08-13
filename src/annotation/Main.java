package annotation;

/**
 * @author tianpanke
 * @title: Main
 * @projectName Test
 * @description: 主程序入口
 * @date 2019/6/28 10:44
 */
public class Main {
    int a;
    //@SuppressWarnings("deprecation") 阻止警告的意思 此注释打开14行代码 横线消失
    public static void main(String[] args) {
        TestDeprecated testDeprecated=new TestDeprecated();
        testDeprecated.sayHello();
        testDeprecated.sayHi();

        //获取注解
        //判断是否使用了某注解
        boolean hasMyAnnotation=TestMyAnnotation.class.isAnnotationPresent(MyAnnotation.class);
        if(hasMyAnnotation){
            MyAnnotation myAnnotation=TestMyAnnotation.class.getAnnotation(MyAnnotation.class);
            System.out.println("id:"+myAnnotation.id());
            System.out.println("msg:"+myAnnotation.msg());
        }
    }
}
