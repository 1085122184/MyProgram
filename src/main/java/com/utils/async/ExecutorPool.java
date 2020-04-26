package com.utils.async;

import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * @author cuijixu
 */
@Component
public class ExecutorPool {

    public void Async(Runnable command){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        threadPoolExecutor.execute(command);
        threadPoolExecutor.shutdown();
    }

}
