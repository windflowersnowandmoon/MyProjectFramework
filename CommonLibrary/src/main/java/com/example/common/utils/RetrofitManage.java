package com.example.common.utils;

public class RetrofitManage {

    private static class RetrofitHolder {
        /**
         * 静态初始化器，由JVM来保护线程安全
         */
        private static RetrofitImpl instance = new RetrofitImpl();
    }

    private RetrofitManage() {
    }

    public static RetrofitImpl getIntance() {

        return RetrofitHolder.instance;
    }

}
