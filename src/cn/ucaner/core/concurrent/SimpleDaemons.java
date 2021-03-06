/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.concurrent;

import java.util.concurrent.TimeUnit;

/**
* @Package：cn.ucaner.core.concurrent   
* @ClassName：SimpleDaemons   
* @Description：   <p> SimpleDaemons </p>
* @Author： -    
* @CreatTime：2018年6月12日 下午3:47:21   
* @Modify By：   
* @ModifyTime：  2018年6月12日
* @Modify marker：   
* @version    V1.0
 */
public class SimpleDaemons implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // Must call before start()
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}

/* Output: (Sample)
All daemons started
Thread[Thread-8,5,main] com.brianway.learning.java.concurrent.SimpleDaemons@1ec8f532
Thread[Thread-4,5,main] com.brianway.learning.java.concurrent.SimpleDaemons@17d10736
Thread[Thread-1,5,main] com.brianway.learning.java.concurrent.SimpleDaemons@2eec0173
Thread[Thread-0,5,main] com.brianway.learning.java.concurrent.SimpleDaemons@78f0e569
Thread[Thread-5,5,main] com.brianway.learning.java.concurrent.SimpleDaemons@572f3b73
Thread[Thread-6,5,main] com.brianway.learning.java.concurrent.SimpleDaemons@6c8d15b7
Thread[Thread-2,5,main] com.brianway.learning.java.concurrent.SimpleDaemons@31229a57
Thread[Thread-3,5,main] com.brianway.learning.java.concurrent.SimpleDaemons@4059e324
Thread[Thread-9,5,main] com.brianway.learning.java.concurrent.SimpleDaemons@32e39829
Thread[Thread-7,5,main] com.brianway.learning.java.concurrent.SimpleDaemons@45401023

...
*///:~
