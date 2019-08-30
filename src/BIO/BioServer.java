package BIO;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tianpanke
 * @title: BioServer
 * @projectName Test
 * @description: 阻塞IO 服务端
 * @date 2019/8/21 17:44
 */
public class BioServer {
    static AtomicInteger counter=new AtomicInteger(0);


    public static void main(String[] args) {
        try{
            //创建ServerSocket对象
            ServerSocket serverSocket=new ServerSocket();
            //绑定端口
            serverSocket.bind(new InetSocketAddress("localhost",8080));
            //阻塞方式接收客户端连接
            while(true){
                Socket s=serverSocket.accept();
                processWithNewThread(s);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    static void processWithNewThread(Socket s){
        Runnable runnable=()->{
          InetSocketAddress clientSA=(InetSocketAddress)s.getRemoteSocketAddress();
            System.out.println(LocalDateTime.now().toString()+"->"+clientSA.getHostName()+":"+clientSA.getPort()+"->"+Thread.currentThread().getName()+":"+counter.incrementAndGet());
            try{
                String result=readBytes(s.getInputStream());
                System.out.println(LocalDateTime.now().toString()+"->"+clientSA.getHostName()+":"+clientSA.getPort()+"->"+Thread.currentThread().getName()+":"+counter.getAndDecrement());
                System.out.println(result);
                s.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        };
        new Thread(runnable).start();
    }
    static String readBytes(InputStream is) throws Exception{
        long start=0;
        int total=0;
        int count=0;
        byte[]bytes=new byte[1024];
        //开始读取数据的时间
        long begin = System.currentTimeMillis();
        while((count=is.read(bytes))>-1){
            if(start<1){
                //第一次读到数据的时间
                start=System.currentTimeMillis();
            }
            total+=count;
        }
        //读完数据的时间
        long end=System.currentTimeMillis();
        return "wait="+(start-begin)+"ms,read="+(end-start)+"ms,total="+total+"bs";
    }
}
