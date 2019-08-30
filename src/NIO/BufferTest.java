package NIO;

import java.nio.ByteBuffer;
import java.nio.channels.Channel;

/**
 * @author tianpanke
 * @title: BufferTest
 * @projectName Test
 * @description:缓冲区测试
 * @date 2019/8/14 13:22
 */
public class BufferTest {
    /*
       buffer类维护了4个核心变量属性来提供于其所包含的数组信息：
         1.Capacity:容量，缓冲区所能够容纳的数据元素的最大数量。容量在缓冲区创建时被设定，并且永远不会被改变（底层是数组）
         2.Limit:上界，缓冲区里的数据总数，代表了当前缓冲区一共有多少数据
         3.Position:位置，下一个要被读或者写的元素的位置，Position会自动由相应的get()和put()函数更新
         4.Mark:标记，一个备忘位置，用于记录上一次读写的位置

     */
    public static void main(String[] args) {
        //创建一个缓冲区
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        //初始化时四个核心变量的值
        System.out.println("初始化时-->limit-->"+byteBuffer.limit());
        System.out.println("初始化时-->position-->"+byteBuffer.position());
        System.out.println("初始化时-->capacity-->"+byteBuffer.capacity());
        System.out.println("初始化时-->mark-->"+byteBuffer.mark());
        System.out.println("-----------------------------------");
        //添加一些数据到缓冲区
        String s="中国";
        byteBuffer.put(s.getBytes());
        System.out.println("初始化后-->limit-->"+byteBuffer.limit());
        System.out.println("初始化后-->position-->"+byteBuffer.position());
        System.out.println("初始化后-->capacity-->"+byteBuffer.capacity());
        System.out.println("初始化后-->mark-->"+byteBuffer.mark());
        System.out.println("-----------------------------------");
        byteBuffer.flip();//byteBuffer切换成只读模式
        System.out.println("flip-->limit-->"+byteBuffer.limit());
        System.out.println("flip-->position-->"+byteBuffer.position());
        System.out.println("flip-->capacity-->"+byteBuffer.capacity());
        System.out.println("flip-->mark-->"+byteBuffer.mark());
        //创建一个limit()大小的字节数组
        byte[]bytes=new byte[byteBuffer.limit()];
        //将byteBuffer中的数据读到我们的字节数组
        byteBuffer.get(bytes,0,bytes.length);
        //输出数据
        System.out.println(new String(bytes,0,bytes.length));
        System.out.println("-----------------------------------");
        System.out.println("get-->limit-->"+byteBuffer.limit());
        System.out.println("get-->position-->"+byteBuffer.position());
        System.out.println("get-->capacity-->"+byteBuffer.capacity());
        System.out.println("get-->mark-->"+byteBuffer.mark());

        //byteBuffer.clear，清除缓冲区,核心变量回归写模式，缓冲区数据是没有清空的，但被遗忘了，因为操作数据的核心变量都被清空了
        byteBuffer.clear();
        System.out.println("-----------------------------------");
        System.out.println("clear-->limit-->"+byteBuffer.limit());
        System.out.println("clear-->position-->"+byteBuffer.position());
        System.out.println("clear-->capacity-->"+byteBuffer.capacity());
        System.out.println("clear-->mark-->"+byteBuffer.mark());
    }
}
