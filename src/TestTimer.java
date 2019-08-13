import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author tianpanke
 * @title: TestTimer
 * @projectName Test
 * @description: 测试Timer定时器
 * @date 2019/7/10 19:10
 */
public class TestTimer {
    public static void main(String[] args) {

        testScheduledExecutorService();

    }
    private static void testScheduledExecutorService(){
        ScheduledExecutorService service= Executors.newSingleThreadScheduledExecutor();
        //任务体、首次执行的延时时间、任务执行间隔、间隔时间单位
        service.scheduleAtFixedRate(()-> System.out.println("task scheduledExecutorService "+new Date()),0,3, TimeUnit.SECONDS);
    }
    private static void  testTimer(){
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                System.out.println("task run:"+ new Date());
            }
        };
        Timer timer=new Timer();
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行
        timer.schedule(timerTask,10,3000);
    }
}
