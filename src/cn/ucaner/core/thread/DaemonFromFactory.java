/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by BYSocket on 2015/11/2.
 *
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
* @Package：cn.ucaner.core.thread   
* @ClassName：DaemonFromFactory   
* @Description：   <p> 后台线程工厂类的使用</p>
* @Author： - Jeff Lee   
* @CreatTime：2018年4月5日 下午1:15:43   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class DaemonFromFactory implements Runnable {
	
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 使用提供的线程工厂类，创建线程池
        ExecutorService exec =
                Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0 ; i < 10 ; i++)
            exec.execute(new DaemonFromFactory());// 此Runnable实现类，经过线程工厂创建
        // 关闭线程池
        exec.shutdown();
        System.out.println("任务已经全部启动");
        TimeUnit.MICROSECONDS.sleep(500);
    }

}
