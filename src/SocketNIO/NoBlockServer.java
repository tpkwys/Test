package SocketNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * @author tianpanke
 * @title: NoBlockServer
 * @projectName Test
 * @description: NIO非阻塞服务端
 * @date 2019/8/15 16:53
 */
public class NoBlockServer {
    public static void main(String[] args) throws IOException {
        //1.获取通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        //2.切换成非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //3.绑定端口
        serverSocketChannel.bind(new InetSocketAddress(6666));
        //4.获取选择器
        Selector selector=Selector.open();
        //5.将通道注册到选择器上，指定接收监听事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.轮询选择器上就绪的事件，只要select>0,说明就绪
        while(selector.select()>0){
            //7.获取当前选择器上所有注册的选择键（已经就绪的监听事件）
            Iterator<SelectionKey> iterator=selector.selectedKeys().iterator();
            //8.获取已就绪的事件，（不同的事件做不同的事情）
            while(iterator.hasNext()){
                SelectionKey selectionKey=iterator.next();
                //接收就绪事件
                if(selectionKey.isAcceptable()){
                    //获取客户端的连接
                    SocketChannel client=serverSocketChannel.accept();
                    //切换成非阻塞状态
                    client.configureBlocking(false);
                    client.register(selector,SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){//读就绪事件
                    //获取当前选择器就绪状态的通道
                    SocketChannel client=(SocketChannel) selectionKey.channel();
                    //读取数据
                    ByteBuffer buffer=ByteBuffer.allocate(1024);
                    //得到文件通道，将客户端传递的图片写到本地项目下面
                    FileChannel outChannel=FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
                    while(client.read(buffer)>0){
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
                }
                // 10. 取消选择键(已经处理过的事件，就应该取消掉了)
                iterator.remove();
            }
        }
    }
}
