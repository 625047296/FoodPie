package com.example.dllo.foodpie.tools;

import android.os.Handler;
import android.os.Looper;

import com.example.dllo.foodpie.base.MyApp;
import com.example.dllo.foodpie.bean.SearchRecordBean;
import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by dllo on 16/11/12.
 */
public class DBTools {

    //饿汉式
    private  static DBTools sDBTools = new DBTools();
    private LiteOrm mLiteOrm;
    //用来做线程切换的
    private Handler mHandler;
    //构造方法私有化
    private Executor mThreadpool;//线程池

    private DBTools() {

        mLiteOrm = LiteOrm.newSingleInstance(MyApp.getContext(),"dbName.db");
        //可以在handler的构造方法里传入
        // Looper.getMainLooper()的参数
        // 可以保证handler一定属于主线程
        mHandler = new Handler(Looper.getMainLooper());

        int coreNum = Runtime.getRuntime().availableProcessors();

        mThreadpool =  Executors.newFixedThreadPool(coreNum+1);
    }

    public static  DBTools getInstance(){
        return sDBTools;
    }
    //插入方法
    public  void insertPerson(final SearchRecordBean mSearchRecordBeen){

        mThreadpool.execute(new Runnable() {
            @Override
            public void run() {
                mLiteOrm.insert(mSearchRecordBeen);
            }
        });

    }
    //查询方法
    public void queryAllPerson(final OnQueryListener onQueryListener){
        mThreadpool.execute(new QueryRunnable(onQueryListener));
    }

    class QueryRunnable implements Runnable{
        private  OnQueryListener mOnQueryListener;

        public QueryRunnable(OnQueryListener mOnQueryListener) {
            this.mOnQueryListener = mOnQueryListener;
        }

        @Override
        public void run() {
            ArrayList<SearchRecordBean> query//查询
                    = mLiteOrm.query(SearchRecordBean.class);

            mHandler.post(new CallBackRunable(mOnQueryListener,query));

        }
    }
    //handler使用的将查询的数据返回到主线程使用Runnable
    class CallBackRunable implements Runnable{
        private OnQueryListener mOnQueryListener;
        private List<SearchRecordBean> mSearchRecordBeen;

        public CallBackRunable(OnQueryListener mOnQueryListener, List<SearchRecordBean> mSearchRecordBeen) {
            this.mOnQueryListener = mOnQueryListener;
            this.mSearchRecordBeen = mSearchRecordBeen;
        }

        @Override
        public void run() {
            mOnQueryListener.onQuery(mSearchRecordBeen);
        }
    }


    //返回查询结果用的接口
    public interface  OnQueryListener {
        void onQuery (List<SearchRecordBean> persons);

    }



}
