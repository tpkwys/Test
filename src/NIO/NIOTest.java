package NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author tianpanke
 * @title: NIOTest
 * @projectName Test
 * @description: nio文件读写
 * @date 2019/8/13 16:51
 */
public class NIOTest {
    public static void main(String[] args) {
        try{
            String str="C:\\Users\\15546\\Desktop\\BaiduNetdiskDownload.rar";
            String ioDst="C:\\Users\\15546\\Desktop\\BaiduNetdiskDownload1.rar";
            String nioDst="C:\\Users\\15546\\Desktop\\BaiduNetdiskDownload2.rar";
            String nioDst1="C:\\Users\\15546\\Desktop\\BaiduNetdiskDownload3.rar";
            String nioDst2="C:\\Users\\15546\\Desktop\\BaiduNetdiskDownload4.rar";

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        copyFileUseIOLoop(str,ioDst);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        copyFileUseNIOLoop(str,nioDst);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        copyFileUseNIOOrigin(str,nioDst1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        copyFileUseNIOMap(str,nioDst2);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private static void copyFileUseIOLoop(String src,String dst) throws IOException{
        long startTime=System.currentTimeMillis();
        //声明源文件和目标文件
        FileInputStream fi=new FileInputStream(new File(src));
        FileOutputStream fo=new FileOutputStream(new File(dst));
        byte[] bt=new byte[1024];
        int len=0;
        while((len=fi.read(bt))!=-1){
            fo.write(bt,0,len);
        }
        fo.flush();
        fi.close();
        fo.close();
        System.out.println("io loop copy file spend time:"+(System.currentTimeMillis()-startTime)+"ms");
    }
    private static void copyFileUseNIOLoop(String src,String dst) throws IOException {
        long startTime=System.currentTimeMillis();
        //声明源文件和目标文件
        FileInputStream fi=new FileInputStream(new File(src));
        FileOutputStream fo=new FileOutputStream(new File(dst));
        //获得传输通道channel
        FileChannel inChannel=fi.getChannel();
        FileChannel outChannel=fo.getChannel();
        //获得容器的buffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while(true){
            //判断是否读完文件
            int eof=inChannel.read(buffer);
            if(eof==-1){
                break;
            }
            //重设一下buffer的position=0,limit=position
            buffer.flip();
            //开始写
            outChannel.write(buffer);
            //写完要重置buffer，重设position=0,limit=capacity
            buffer.clear();
        }
        fo.flush();
        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();
        System.out.println("nio loop copy file spend time:"+(System.currentTimeMillis()-startTime)+"ms");
    }
    private static  void   copyFileUseNIOOrigin(String src,String dst)throws IOException{
        long startTime=System.currentTimeMillis();
        FileChannel fci=new FileInputStream(new File(src)).getChannel();
        FileChannel fco=new FileOutputStream(new File(dst)).getChannel();
        fco.transferFrom(fci,0,fci.size());

        System.out.println("nio origin copy file spend time:"+(System.currentTimeMillis()-startTime)+"ms");
    }

    private static void copyFileUseNIOMap(String src,String dst) throws IOException{
        long startTime=System.currentTimeMillis();
        FileChannel inChannel=FileChannel.open(Paths.get(src), StandardOpenOption.READ);
        FileChannel outChannel=FileChannel.open(Paths.get(dst),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);

        //内存映射buffer
        MappedByteBuffer inMapperBuf=inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMapperBuf=outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        //直接对换冲区进行数据的读写操作
        byte[] dst1=new byte[inMapperBuf.limit()];
        inMapperBuf.get(dst1);
        outMapperBuf.put(dst1);

        inChannel.close();
        outChannel.close();
        System.out.println("nio map copy file spend time:"+(System.currentTimeMillis()-startTime)+"ms");
    }
}
