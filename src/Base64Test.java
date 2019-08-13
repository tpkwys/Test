import sun.misc.BASE64Encoder;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.Date;

/**
 * @author tianpanke
 * @title: Base64Test
 * @projectName Test
 * @description: TODO
 * @date 2019/7/18 17:48
 */
public class Base64Test {



    public static void main(String[] args) throws Exception{
//        final Base64.Decoder decoder=Base64.getDecoder();
//        final Base64.Encoder encoder=Base64.getEncoder();
//         String text="字符文本";
//         byte[]textByte=text.getBytes("UTF-8");
//        String encodeText=encoder.encodeToString(textByte);
//        System.out.println(encodeText);
//        LocalDateTime limitActivityTime=LocalDateTime.of(2019,8,3,20,0,0);
//        LocalDateTime limitActivityTime1=LocalDateTime.of(2019,8,3,21,0,0);
//        System.out.println(limitActivityTime1.isAfter(limitActivityTime));
        System.out.println(Date.from((LocalDateTime.now().plusMonths(3).withHour(23).withMinute(59).withSecond(59).toInstant(ZoneOffset.of("+8")))));
    }
}
