package annotation;

/**
 * @author tianpanke
 * @title: SwithTest
 * @projectName Test
 * @description: 我们都知道，switch 是一种高效的判断语，比起 if/else 真的是爽快多了。
 * 尤其是 JDK 1.7 之后，switch 的 case 条件可以是 char, byte, short, int, Character, Byte,
 * Short, Integer, String, 或者 enum 类型。
 * switch () 的括号中不允许传入 null。为什么呢？
 * @date 2019/7/18 11:07
 */
public class SwithTest {
    public static void main(String[] args) {
        String param=null;
        switch (param){
            case "null":
                System.out.println("null");
                break;
                default:
                    System.out.println("default");
        }
    }
}
