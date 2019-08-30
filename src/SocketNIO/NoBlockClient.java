package SocketNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * @author tianpanke
 * @title: NoBlockClient
 * @projectName Test
 * @description:NIO非阻塞形态
 * @date 2019/8/15 16:48
 */
public class NoBlockClient {
    public static void main(String[] args) throws IOException {
        //1.获取通道
        SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",6666));
        //2.切换成非阻塞模式
        socketChannel.configureBlocking(false);
        //获取选择器
        Selector selector=Selector.open();
        //将通道注册到选择器中，获取服务端返回的数据
        socketChannel.register(selector, SelectionKey.OP_READ);

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
        // 5. 轮训地获取选择器上已“就绪”的事件--->只要select()>0，说明已就绪
        while (selector.select() > 0) {
            // 6. 获取当前选择器所有注册的“选择键”(已就绪的监听事件)
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            // 7. 获取已“就绪”的事件，(不同的事件做不同的事)
            while (iterator.hasNext()) {

                SelectionKey selectionKey = iterator.next();

                // 8. 读事件就绪
                if (selectionKey.isReadable()) {

                    // 8.1得到对应的通道
                    SocketChannel channel = (SocketChannel) selectionKey.channel();

                    ByteBuffer responseBuffer = ByteBuffer.allocate(1024);

                    // 9. 知道服务端要返回响应的数据给客户端，客户端在这里接收
                    int readBytes = channel.read(responseBuffer);

                    if (readBytes > 0) {
                        // 切换读模式
                        responseBuffer.flip();
                        System.out.println(new String(responseBuffer.array(), 0, readBytes));
                    }
                }

                // 10. 取消选择键(已经处理过的事件，就应该取消掉了)
                iterator.remove();
            }
        }

        //5.关闭流
        fileChannel.close();
        socketChannel.close();

    }
}
