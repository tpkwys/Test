package SocketNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author tianpanke
 * @title: BlockServer
 * @projectName Test
 * @description: 阻塞的网络通信fu
 * @date 2019/8/15 16:15
 */
public class BlockServer {
    public static void main(String[] args) throws IOException {
        //1.获取通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();

        //2.得到文件通道，将客户端传递的图片写到本地项目下面
        FileChannel outChannel=FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //3.端口绑定
        serverSocketChannel.bind(new InetSocketAddress(6666));

        //4.获取客户端的连接(阻塞的)
        SocketChannel client=serverSocketChannel.accept();

        //5.要使用NIO，有了Channel，就必然要有Buffer,Buffer是与数据打交道的
        ByteBuffer buffer=ByteBuffer.allocate(1024);//1k

        while(client.read(buffer)!=-1){
            // 在读之前都要切换成读模式
            buffer.flip();

            outChannel.write(buffer);

            // 读完切换成写模式，能让管道继续读取文件的数据
            buffer.clear();
        }
        //此时服务端成功保存了图片，想要告诉客户端，图片已经上传成功了,否则服务端一直阻塞在那里，无法发消息过来
        buffer.put("Image is successf".getBytes());
        buffer.flip();
        client.write(buffer);
        buffer.clear();

        //7.关闭通道
        outChannel.close();
        client.close();
        serverSocketChannel.close();

    }
}
