/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
* @Package：cn.ucaner.core.juc   
* @ClassName：TestLock   
* @Description：   <p> TestLock 
* 一、用于解决多线程安全问题的方式：
* 	synchronized:隐式锁
* 	1. 同步代码块
* 	2. 同步方法
* jdk 1.5 后：
* 	3. 同步锁 Lock
* 	 注意：是一个显示锁，需要通过 lock() 方法上锁，必须通过 unlock() 方法进行释放锁
* </p>
* @Author： - Jason   
* @CreatTime：2018年10月19日 下午3:38:53   
* @Modify By：   
* @ModifyTime：  2018年10月19日
* @Modify marker：   
* @version    V1.0
 */
public class TestLock {
	
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		
		new Thread(ticket, "1号窗口").start();
		new Thread(ticket, "2号窗口").start();
		new Thread(ticket, "3号窗口").start();
	}

}

class Ticket implements Runnable{
	
	private int tick = 100;
	
	private Lock lock = new ReentrantLock();

	@Override
	public void run() {
		while(true){
			
			lock.lock(); //上锁
			
			try{
				if(tick > 0){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					}
					
					System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + --tick);
				}//else {
					//System.out.println("票已经售完!");
					//break;
			//	}
			}finally{
				lock.unlock(); //释放锁
			}
		}
	}
	
}