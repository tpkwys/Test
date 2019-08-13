package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tianpanke
 * @title: TestPhone
 * @projectName Test
 * @description: 手机号格式检验
 * @date 2019/8/5 14:02
 */
public class TestPhone {
    public static void main(String[] args) {
        //手机号的变化越来越快，因为经常有新的号段出来，所以不要太过限制为好
        String PHONE_NUMBER_REG="^1[3|4|5|7|8][0-9]\\d{8}$";
        Pattern p=Pattern.compile(PHONE_NUMBER_REG);
        Matcher m=p.matcher("13476236091");
        System.out.println(m.matches());
    }
}
