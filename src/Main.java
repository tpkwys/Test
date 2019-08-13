import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        List<String>  myList= Arrays.asList("a1","a2","a3","a4","c2","c1");
//        myList.stream()
//                .filter(s -> s.startsWith("c"))
//                .map(String::toUpperCase)
//                .sorted()
//                .forEach(System.out::println);
//        myList.stream().forEach(System.out::println);
//        int[] array={1,3,2};
//        Arrays.stream(array).sorted().forEach(System.out::println);

//        Stream<Integer> stream=Stream.of(1,2,3,5);
//        stream.forEach(System.out::println);
//        String no="HY3C1234123";
//        System.out.println(no.substring(no.indexOf("Y")+1,no.indexOf("C")));
//        int[] a={9,6,8,6,7,8,6,7,8,8,4,8,9,9,4,7,4,7,4,7,6,4,5,9,4,6,8,8,6};
//        int count=0;
//        for(int i=0;i<a.length;i++){
//            count+=a[i];
//        }
      //  System.out.println(count);
//        int count=0;
//        StringBuffer s=new StringBuffer();
//         for(int i=0;i<30;i++){
//             int num=(int)(Math.random()*(9-4+1)+4);
//             count+=num;
//             s.append(num).append(",");
//         }
//        System.out.println(s);
//        System.out.println(count);
//        System.out.println("123456".substring(2));
//            String val = "";
//            Random random = new Random();
//            // length为几位密码
//            for (int i = 0; i < 6; i++) {
//                // 判断生成数字还是字母(字母有大小写区别)
//                String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
//                // 输出字母还是数字
//                if ("char".equalsIgnoreCase(charOrNum)) {
//                    // 输出是大写字母还是小写字母
//                    int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
//                    val += (char) (random.nextInt(26) + temp);
//                } else if ("num".equalsIgnoreCase(charOrNum)) {
//                    val += String.valueOf(random.nextInt(10));
//                }
//
//        }
//        System.out.println(val.toUpperCase());
      for(int i=0;i<200;i++){
          System.out.println(generateString(6));
      }

    }
    public static String generateString(int length){
        StringBuilder val = new StringBuilder();
        Random random = new Random();
        // length为几位密码

        for (int i = 0; i < length; i++) {
            // 判断生成数字还是字母(字母有大小写区别)
            do{
                String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
                // 输出字母还是数字
                if ("char".equalsIgnoreCase(charOrNum)) {
                    // 输出是大写字母还是小写字母
                    int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                    char c=(char) (random.nextInt(26) + temp);
                    if(c=='o'||c=='O')
                        continue;
                    else{
                        val.append(c);
                        break;
                    }

                } else if ("num".equalsIgnoreCase(charOrNum)) {
                    int c=random.nextInt(10);
                    if(c==0)
                        continue;
                    else{
                        val.append(String.valueOf(c));
                        break;
                    }
                }
            }while(true);

        }
        return  val.toString().toUpperCase();
    }
}
