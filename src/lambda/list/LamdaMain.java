package lambda.list;

/**
 * @author tianpanke
 * @title: LamdaMain
 * @projectName Test
 * @description: TODO
 * @date 2019/8/2 10:59
 */
public class LamdaMain {
   // ()->5 不需要参数，返回值为5
    // x->2*x 接受一个参数（数字类型），返回值为2的倍数
    //（x,y）->x-y接受两个参数（数字类型），并返回他们的差值
    //（int x,int y)->x+y接收两个int型的参数，并返回他们的和
    //(String s)->System,out.println(s) 接受一个String对象，并在控制台打印

    public static void main(String[] args) {
        LamdaMain main=new LamdaMain();
        String salution="Hello!";
        //声明类型
        MathOperation addition=(int a,int b)->a+b;
        //不声明类型
        MathOperation subtraction=(a,b)->a-b;
        //大括号中有返回值的
        MathOperation multiplication=(int a,int b)->{return a*b;};

        //没有大括号的及返回语句
        MathOperation division=(int a,int b)->a/b;

        System.out.println("10+5="+main.operate(10,5,addition));
        System.out.println("10-5="+main.operate(10,5,subtraction));
        System.out.println("10*5="+main.operate(10,5,multiplication));
        System.out.println("10/5="+main.operate(10,5,division));
        //不用括号的
        GreetingService greetingService=msg -> System.out.println(salution+msg);
        //用括号的
        GreetingService greetingService1=(msg)-> System.out.println(salution+msg);

        greetingService.sayMsg("china");
        greetingService1.sayMsg("england");



    }
    interface MathOperation{
        int operation(int a,int b);
    }
    interface GreetingService{
        void sayMsg(String msg);

    }
    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}
