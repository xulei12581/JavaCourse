package com.geek.course.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ChildThread extends Thread {

    private static int result;

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池 异步执行下面的方法
        /**
         * 第一种方式  Thread的join方法
         */
//        Thread thread = new Thread() {
//            public void run() {
//                System.out.println(this.getName() + " start");
//                try {
//                    Thread.sleep(3000);
//                    result = sum();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(this.getName() + " end");
//            }
//        };
//        thread.start();
//        thread.join();
        /**
         * 第二种方式 判断子线程是否还存活
         */
//        Thread thread = new Thread() {
//            public void run() {
//                System.out.println(this.getName() + " start");
//                try {
//                    Thread.sleep(3000);
//                    result = sum();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(this.getName() + " end");
//            }
//        };
//        thread.start();
//        while(thread.isAlive()){
//
//        }
        /**
           * 第三种方式 判断子线程是否还存活
         */
//        Thread thread = new Thread() {
//            public void run() {
//                System.out.println(this.getName() + " start");
//                try {
//                    Thread.sleep(3000);
//                    result = sum();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(this.getName() + " end");
//            }
//        };
//        thread.start();
//        while(Thread.activeCount()>1){
//            Thread.yield();
//        }
        /**
         * 第四种方式 CountDownLatch
         */
//        CountDownLatch latch = new CountDownLatch(1);
//        Thread thread = new Thread() {
//            public void run() {
//                System.out.println(this.getName() + " start");
//                try {
//                    Thread.sleep(3000);
//                    result = sum();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }finally {
//                    latch.countDown();
//                }
//                System.out.println(this.getName() + " end");
//
//            }
//        };
//        thread.start();
//        latch.await();
        /**
         * 第五种方式 线程池newFixedThreadPool的awaitTermination()方法
         */
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        Thread thread = new Thread() {
//            public void run() {
//                System.out.println(this.getName() + " start");
//                try {
//                    Thread.sleep(3000);
//                    result = sum();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(this.getName() + " end");
//
//            }
//        };
//        executorService.execute(thread);
//        executorService.shutdown();
//        // awaitTermination返回false即超时会继续循环，返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔5秒循环一次
//        while (!executorService.awaitTermination(3, TimeUnit.SECONDS)){
//            // 超时等待后，可以手动结束所有正常执行的线程。不执行下面的语句将循环等待，直到所有子线程结束。
//            // executorService.shutdownNow();
//        }
        /**
         * 第六种方式 线程池newSingleThreadExecutor的awaitTermination()方法
         */
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Thread thread = new Thread() {
//            public void run() {
//                System.out.println(this.getName() + " start");
//                try {
//                    Thread.sleep(3000);
//                    result = sum();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(this.getName() + " end");
//
//            }
//        };
//        executorService.execute(thread);
//        executorService.shutdown();
//        // awaitTermination返回false即超时会继续循环，返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔5秒循环一次
//        while (!executorService.awaitTermination(3, TimeUnit.SECONDS)){
//            // 超时等待后，可以手动结束所有正常执行的线程。不执行下面的语句将循环等待，直到所有子线程结束。
//            // executorService.shutdownNow();
//        }
        /**
         * 第七种方式 线程池newSingleThreadScheduledExecutor的awaitTermination()方法
         */
//        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        Thread thread = new Thread() {
//            public void run() {
//                System.out.println(this.getName() + " start");
//                try {
//                    Thread.sleep(3000);
//                    result = sum();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(this.getName() + " end");
//
//            }
//        };
//        executorService.execute(thread);
//        executorService.shutdown();
//        // awaitTermination返回false即超时会继续循环，返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔5秒循环一次
//        while (!executorService.awaitTermination(3, TimeUnit.SECONDS)){
//            // 超时等待后，可以手动结束所有正常执行的线程。不执行下面的语句将循环等待，直到所有子线程结束。
//            // executorService.shutdownNow();
//        }
        /**
         * 第八种方式 线程池newCachedThreadPool的awaitTermination()方法
         */
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Thread thread = new Thread() {
//            public void run() {
//                System.out.println(this.getName() + " start");
//                try {
//                    Thread.sleep(3000);
//                    result = sum();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(this.getName() + " end");
//
//            }
//        };
//        executorService.execute(thread);
//        executorService.shutdown();
//        // awaitTermination返回false即超时会继续循环，返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔5秒循环一次
//        while (!executorService.awaitTermination(3, TimeUnit.SECONDS)){
//            // 超时等待后，可以手动结束所有正常执行的线程。不执行下面的语句将循环等待，直到所有子线程结束。
//            // executorService.shutdownNow();
//        }
        /**
         * 第九种方式 线程池newWorkStealingPool的awaitTermination()方法
         */
        ExecutorService executorService = Executors.newWorkStealingPool();
        Thread thread = new Thread() {
            public void run() {
                System.out.println(this.getName() + " start");
                try {
                    Thread.sleep(3000);
                    result = sum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + " end");

            }
        };
        executorService.execute(thread);
        executorService.shutdown();
        // awaitTermination返回false即超时会继续循环，
        // 返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔5秒循环一次
        while (!executorService.awaitTermination(3, TimeUnit.SECONDS)){
            // 超时等待后，可以手动结束所有正常执行的线程。不执行下面的语句将循环等待，直到所有子线程结束。
            // executorService.shutdownNow();
        }



        System.out.println("所有子线程执行完毕了。。。");
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

}
