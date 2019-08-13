package java8.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.*;

/**
 * @author tianpanke
 * @title: TestCompletableFuture
 * @projectName Test
 * @description: TODO
 * @date 2019/8/9 13:45
 */
public class TestCompletableFuture {
    public static void main(String[] args) {

        try{
//            supplyAsync();
//            runAsync();
           // whenComplete();
           // thenApply();
           // handle();
           // thenAccept();
          //  thenRun();
         //   thenCombine();
         //   thenAcceptBoth();
         //   applyToEither();
            acceptEither();

        }catch (Exception e){

        }
        System.out.println("main end");

    }
    //无返回值
    public static void runAsync() throws Exception{
        CompletableFuture<Void> future=CompletableFuture.runAsync(()->{
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){}
            System.out.println("run end");
        });
        future.get();
    }
    //有返回值
    public static void supplyAsync() throws Exception{
        CompletableFuture<Long> future=CompletableFuture.supplyAsync(()->{
            try{
                TimeUnit.SECONDS.sleep(4);
            }catch (InterruptedException e){

            }
           return System.currentTimeMillis();
        });
        long endTime=future.get();
        System.out.println("time="+endTime);
    }
    //计算完成时回调
    public static void whenComplete() throws Exception{
        CompletableFuture<Void> future=CompletableFuture.runAsync(()->{
           try{
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e){

           }
           if(new Random().nextInt()%2>=0){
               int i=12/0;
           }
            System.out.println("run end");
        });
        //最后执行，回调
        future.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void aVoid, Throwable throwable) {
                System.out.println("执行完成");
            }
        });
        //执行发生错误时，回调
        future.exceptionally(new Function<Throwable, Void>() {
            @Override
            public Void apply(Throwable throwable) {
                System.out.println("执行失败："+throwable.getMessage());
                return null;
            }
        });
        future.get();
        TimeUnit.SECONDS.sleep(2);
    }
    //两个任务串行执行,第二个任务依赖第一个任务的结果
    public static void thenApply() throws Exception{
        CompletableFuture<Long> future=CompletableFuture.supplyAsync(new Supplier<Long>() {
            @Override
            public Long get() {
                long result=new Random().nextInt(100);
                System.out.println("result1="+result);
                return result;
            }
        }).thenApply(new Function<Long, Long>() {
            @Override
            public Long apply(Long aLong) {
                long result=aLong*5;
                System.out.println("result2="+result);
                return result;
            }
        });

        long result=future.get();
        System.out.println(result);

    }
    //handle 是执行任务完成时对结果的处理 handle 方法和 thenApply 方法处理方式基本一样。
    //不同的是 handle 是在任务完成后再执行，还可以处理异常的任务。thenApply 只可以执行正常的任务，
    // 任务出现异常则不执行thenApply 方法。

    public static void handle() throws Exception{
        CompletableFuture<Integer> future=CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int i=10/0;
                return new Random().nextInt(10);
            }
        }).handle(new BiFunction<Integer, Throwable, Integer>() {
            @Override
            public Integer apply(Integer integer, Throwable throwable) {
                int result=-1;
                if(throwable==null){
                    result=integer*2;
                }else{
                    System.out.println(throwable.getMessage());
                }
                return result;
            }
        });
        System.out.println(future.get());
    }
    //接收任务的处理结果，并消费处理，无返回结果
    public static void thenAccept()throws Exception{
        CompletableFuture<Void> future=CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        }).thenAccept(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }
    //thenRun 跟 thenAccept 方法不一样的是，不关心任务的处理结果。只要上面的任务执行完成，就开始执行thenAccept
    public static void thenRun() throws Exception{
        CompletableFuture<Void> future=CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        }).thenRun(new Runnable() {
            @Override
            public void run() {
                System.out.println("thenRun...");
            }
        });
        future.get();
    }
    //thenCombine 会把 两个 CompletionStage 的任务都执行完成后，把两个任务的结果一块交给 thenCombine 来处理。
    public static void thenCombine()throws Exception{
        CompletableFuture<String> future1=CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "future1";
            }
        });
        CompletableFuture<String> future2=CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "future2";
            }
        });
        CompletableFuture<String> result=future1.thenCombine(future2, new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s+" "+s2;
            }
        });
        System.out.println(result.get());
    }
    //当两个CompletionStage都执行完成后，把结果一块交给thenAcceptBoth来进行消耗
    public static void thenAcceptBoth() throws Exception{
        CompletableFuture<Integer> f1=CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t=new Random().nextInt(3);
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("f1="+t);
                return t;
            }
        });
        CompletableFuture<Integer> f2=CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t=new Random().nextInt(3);
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("f2="+t);
                return t;
            }
        });
        f1.thenAcceptBoth(f2, new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                System.out.println("f1="+integer+" f2="+integer2);
            }
        });

    }
    //applyToEither 两个CompletionStage,谁执行返回的结果快，我就用哪个CompletionStage的结果进行下一步的转化操作
    private static void applyToEither() throws Exception{
        CompletableFuture<Integer> f1=CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t=new Random().nextInt(3);
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("f1="+t);
                return t;
            }
        });
        CompletableFuture<Integer> f2=CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t=new Random().nextInt(3);
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("f2="+t);
                return t;
            }
        });
        CompletableFuture<Integer> result=f1.applyToEither(f2, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                System.out.println(integer);
                return integer*2;
            }
        });
        result.get();

    }
    //acceptEither:两个CompletionStage,谁执行返回的结果快，我就用那个CompletionStage的结果进行下一步操作

    private static void acceptEither()throws Exception{
        CompletableFuture<Integer> f1=CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t=new Random().nextInt(5)+1;
                try{
                    TimeUnit.SECONDS.sleep(t);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("f1="+t);
                return t;
            }
        });
        CompletableFuture<Integer> f2=CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t=new Random().nextInt(5)+1;
                try{
                    TimeUnit.SECONDS.sleep(t);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("f2="+t);
                return t;
            }
        });
        f1.acceptEither(f2, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }



}
