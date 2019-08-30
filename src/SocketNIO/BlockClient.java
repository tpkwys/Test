package SocketNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;

/**
 * @author tianpanke
 * @title: BlockClient
 * @projectName Test
 * @description: 阻塞的网络通信客户端
 * @date 2019/8/15 16:07
 */
public class BlockClient {
    public static void main(String[] args) throws IOException {
        //1.获取通道
        SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",6666));
        //2.发送一张图片给服务端
        FileChannel fileChannel=FileChannel.open(Paths.get("E:\\tpk\\download\\1.png"));
        //3.要使用NIO，有了Channel就必然有buffer,buffer是为了和数据打交道
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        //4.读取本地文件，发送给服务端
        while (fileChannel.read(buffer)!=-1){
            //在读之前要切成读模式
            buffer.flip();
            socketChannel.write(buffer);
            //读完之后切换成写模式，能让管道继续读取文件的数据
            buffer.clear();
        }
        //告诉服务端已经写完了
        socketChannel.shutdownOutput();
        //接收服务端数据
        int len=0;
        while((len=socketChannel.read(buffer))!=-1){
            //切换成读模式
            buffer.flip();
            System.out.println(new String(buffer.array(),0,len));
            //切换成写模式
            buffer.clear();
        }
        //关闭流
        fileChannel.close();
        socketChannel.close();
    }
}
