import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.regex.Pattern;

/**
 * @author tianpanke
 * @title: TestMain
 * @projectName Test
 * @description: TODO
 * @date 2019/7/6 14:18
 */
public class TestMain {



    public static void main(String[] args) throws Exception{

        Long start=System.currentTimeMillis();
        FileWriter fw=new FileWriter(new File("C:\\Users\\15546\\Desktop\\niceNumber.txt"));

        //写入中文字符时会出现乱码
        BufferedWriter bw=new BufferedWriter(fw);
        int count=0;
        for(int j=0;j<=9999999;j++){
            String    str1=j+"";
                if(isNiceNumber(str1)){
                    getStrNumber4(j);
                    bw.write(str1);
                    bw.write("\r\n");
                    count++;
                }

        }
        System.out.println("count:"+count);
        bw.close();
        fw.close();
        System.out.println("niceNumberCount:"+count+"{"+(System.currentTimeMillis()-start)/1000+"}");
    }
    public static String getStrNumber4(int i){
        String str=i+"";
        int d=8-str.length();
        for(int j=0;j<d;j++){
            str="0"+str;
        }
        return str;
    }

    public static  Boolean hasBadNumber(String str){
        if(str.contains("4")||str.contains("7"))
            return true;
        return false;
    }
    public static Boolean isNiceNumber(String str){
        if(Pattern.matches(NiceNumberRegular.AAAA,str))
            return true;
        else if(Pattern.matches(NiceNumberRegular.AABB,str))
            return true;
        else if(Pattern.matches(NiceNumberRegular.ABBB,str))
            return true;
        else  if(Pattern.matches(NiceNumberRegular.ABCD,str))
            return true;
        return false;
    }

}
