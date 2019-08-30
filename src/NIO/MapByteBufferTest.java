package NIO;

import java.io.IOException;
import java.net.URL;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author tianpanke
 * @title: MapByteBufferTest
 * @projectName Test
 * @description: Java内存映射
 * @date 2019/8/15 9:27
 */
public class MapByteBufferTest {
    public static void main(String[] args) {
        //testRead();
        testWrite();

    }
    private static void testRead(){
        CharBuffer charBuffer=null;
        ClassLoader classLoader=MapByteBufferTest.class.getClassLoader();
//        System.out.println(classLoader.getResource("nio.txt"));
//        System.out.println(MapByteBufferTest.class.getResource("")); //返回class文件所在的包的位置
//        System.out.println(MapByteBufferTest.class.getResource("/"));//返回的是class文件所在的根目录(所在包的上级目录)
//        System.out.println(classLoader.getResource(""));//返回的就是类所在的跟路径
//        System.out.println(classLoader.getResource("/"));//不支持参数为“/”，返回null
        URL url=classLoader.getResource("nio.txt");
        System.out.println(url.getPath());// /E:/tpk/workspace/Test/out/production/Test/nio.txt
        Path path= Paths.get(url.getPath().substring(1));// 剔除“/”
        try{
            FileChannel fileChannel=FileChannel.open(path);
            MappedByteBuffer mappedByteBuffer=fileChannel.map(FileChannel.MapMode.READ_ONLY,0,fileChannel.size());
            if(mappedByteBuffer!=null){
                charBuffer= Charset.forName("UTF-8").decode(mappedByteBuffer);
                //由于decode方法的参数是MappedByteBuffer,这就意味着我们是从内存中而不是磁盘中读入的文件内容，所以速度会非常快
            }
            System.out.println(charBuffer.toString());
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void testWrite(){
        CharBuffer charBuffer=CharBuffer.wrap("这一次，我们把模式调整为MapMode.READ_WRITE,并指定文件大小为1024，即1K的大小");
        Path path=Paths.get(MapByteBufferTest.class.getClassLoader().getResource("write.txt").getPath().substring(1));
        try{
            FileChannel fileChannel=FileChannel.open(path, StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);
            MappedByteBuffer mappedByteBuffer=fileChannel.map(FileChannel.MapMode.READ_WRITE,0,1024);
            if(mappedByteBuffer!=null){
                mappedByteBuffer.put(Charset.forName("UTF-8").encode(charBuffer));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
