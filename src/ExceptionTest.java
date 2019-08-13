import java.io.File;
import java.io.IOException;

/**
 * @author tianpanke
 * @title: ExceptionTest
 * @projectName Test
 * @description: TODO
 * @date 2019/8/1 13:49
 */
public class ExceptionTest {
    public static void main(String[] args) {
        File file=new File("e:/a.txt");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            System.out.println("创建file异常："+e.getMessage());
        }
    }
}
