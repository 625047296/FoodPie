package com.example.dllo.foodpie.goeatfragment;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dllo on 16/10/25.
 */
public class SingleSimpleThreadPool {

    private static SingleSimpleThreadPool mSingleSimpleThreadPool;

    private final ThreadPoolExecutor threadPoolExecutor;

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    private SingleSimpleThreadPool() {

        int cpuCore = Runtime.getRuntime().availableProcessors();

        threadPoolExecutor = new ThreadPoolExecutor(cpuCore +1,cpuCore*2+1,
                2l, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());


    }
    public static SingleSimpleThreadPool getInStance(){
        if (mSingleSimpleThreadPool == null) {
            synchronized (SingleSimpleThreadPool.class) {
                if (mSingleSimpleThreadPool == null) {
                    mSingleSimpleThreadPool = new SingleSimpleThreadPool();
                }

            }
        }
        return mSingleSimpleThreadPool;
    }


}
