package com.kevin86.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程工厂(注意：所有线程 均使用线程工厂)
 * @author kevin chen
 *
 */
public class GameThreadFactory implements ThreadFactory {
	/**线程池 序号*/
	private static final AtomicInteger poolNumber = new AtomicInteger(1);
    /**线程组*/
	private final ThreadGroup group;
    /**线程序号*/
	private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    public GameThreadFactory(String threadName) {
        SecurityManager s = System.getSecurityManager();//Java 安全管理器
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        namePrefix = "-" +poolNumber.getAndIncrement() +"-"+threadName+"-";
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r,namePrefix + threadNumber.getAndIncrement(),0);
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        //捕捉异常
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){  
            @Override  
            public void uncaughtException(Thread t, Throwable e) {  
            	System.err.println(t.getName() + " "+e.getMessage());
            }
         }); 
        
        
        return t;
    }

}
