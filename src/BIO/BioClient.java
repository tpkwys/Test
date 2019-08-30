package BIO;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;

/**
 * @author tianpanke
 * @title: BioClient
 * @projectName Test
 * @description: 阻塞IO 客户端
 * @date 2019/8/21 17:58
 */
public class BioClient {
    public static void main(String[] args) {
        try{
            for(int i=0;i<20;i++){
                Socket s=new Socket();
                s.connect(new InetSocketAddress("localhost",8080));
                processWithThread(s,i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    static void processWithThread(Socket s,int i){
        Runnable run=()->{
            try{
                //随机休眠5-10秒，模拟数据尚未就绪
                Thread.sleep((new Random().nextInt(6)+5)*1000);
                //写入1M数据，为了拉长服务端读取数据的过程
                s.getOutputStream().write(prepareBytes());
                Thread.sleep(1000);
                s.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        };
        new Thread(run).start();



    }
    static byte[] prepareBytes(){
        byte[]bytes=new byte[1024*1024];
        for(int i=0;i<bytes.length;i++){
            bytes[i]=1;
        }
        return  bytes;
    }
}
