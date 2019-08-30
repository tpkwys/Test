package daily;

import java.util.Base64;

/**
 * @author tianpanke
 * @title: TestMain
 * @projectName Test
 * @description: TODO
 * @date 2019/8/16 11:53
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println(validate());

    }
    private static Boolean validate(){
        try{
            int i=10/0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return  true;
    }
}
