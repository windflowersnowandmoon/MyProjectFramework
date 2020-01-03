package com.example.common.utils;


import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日志统一接口
 * android.util.Log常用的方法有以下5个：Log.v() ,Log.d() ,Log.i() ,Log.w() ,Log.e() 。按照日志级别从高到低为ERROR, WARN, INFO, DEBUG, VERBOSE.至于日志级别本身的含义.
 * <p>
 * 1.下面是对各种日志级别的输出介绍:
 * <p>
 * 　1、Log.v 的输出颜色为黑色的，输出大于或等于VERBOSE日志级别的信息
 * <p>
 * 　2、Log.d的输出颜色是蓝色的，输出大于或等于DEBUG日志级别的信息
 * <p>
 * 　3、Log.i的输出为绿色，输出大于或等于INFO日志级别的信息
 * <p>
 * 　4、Log.w的输出为橙色, 输出大于或等于WARN日志级别的信息
 * <p>
 * 　5、Log.e的输出为红色，仅输出ERROR日志级别的信息.
 * <p>
 * Android的Log等级通常有五类，按照日志级别由低到高分别是Verbose、Debug、Info、Warning、Error，其对应的log定义在system层。
 * <p>
 * 1.V
 * <p>
 * Verbose就是冗长啰嗦的。通常表达开发调试过程中的一些详细信息，用Log.v()输出，不过滤地输出所有调试信息。是最低级的Log可以不用管。
 * <p>
 * 2.D
 * <p>
 * Debug来表达调试信息。用Log.d()输出，能输出Debug、Info、Warning、Error级别的Log信息。
 * <p>
 * 3.I
 * <p>
 * Info来表达一些信息。用Log.i()输出，能输出Info、Warning、Error级别的Log信息。
 * <p>
 * 4.W
 * <p>
 * Warning表示警告，但不一定会马上出现错误，开发时有时用来表示特别注意的地方。用Log.w()输出，能输出Warning、Error级别的Log信息。
 * <p>
 * 5.E
 * <p>
 * Error表示出现错误，是最需要关注解决的。用Log.e()输出，能输出Error级别的Log信息。
 * <p>
 * 注：Info、Warnning、Error等级的Log在普通调试中不随意滥用，存在发布版本中。在开发调试版本中，才会显示全部等级
 */
public class LogUtils {

    private LogUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static boolean logSwitch = true;
    private static boolean logFileSwitch = false;
    private static char logFilter = 'v';
    private static String tag = LogUtils.class.getSimpleName();
    private static String dir = "";


    public static void init(boolean logSwitch, boolean logFileSwitch, char logFilter) {
        LogUtils.logSwitch = logSwitch;
        LogUtils.logFileSwitch = logFileSwitch;
        LogUtils.logFilter = logFilter;
    }

    public static Builder getBuilder() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag(tag)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
//        Logger.addLogAdapter(new AndroidLogAdapter());
        return new Builder();
    }


    public static class Builder {

        private boolean logSwitch = true;
        private boolean logFileSwitch = false;
        private char logFilter = 'v';
        private String tag = LogUtils.class.getSimpleName();


        public Builder setLogSwitch(boolean logSwitch) {
            this.logSwitch = logSwitch;
            return this;
        }

        public Builder setLogFileSwitch(boolean logFileSwitch) {
            this.logFileSwitch = logFileSwitch;
            return this;
        }

        public Builder setLogFilter(char logFilter) {
            this.logFilter = logFilter;
            return this;
        }

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public void create() {
            LogUtils.logSwitch = logSwitch;
            LogUtils.logFileSwitch = logFileSwitch;
            LogUtils.logFilter = logFilter;
        }
    }

    /**
     * Verbose日志
     *
     * @param msg 消息
     */
    public static void v(Object msg) {
        v(tag, msg);
    }

    /**
     * Verbose日志
     *
     * @param tag 标签
     * @param msg 消息
     */
    public static void v(String tag, Object msg) {
        v(tag, msg, null);
    }

    /**
     * Verbose日志
     *
     * @param tag       标签
     * @param msg       消息
     * @param throwable 异常
     */
    public static void v(String tag, Object msg, Throwable throwable) {
        log(tag, msg.toString(), throwable, 'v');
    }

    /**
     * Debug日志
     *
     * @param msg 消息
     */
    public static void d(Object msg) {
        d(tag, msg);
    }

    /**
     * Debug日志
     *
     * @param tag 标签
     * @param msg 消息
     */
    public static void d(String tag, Object msg) {
        d(tag, msg, null);
    }

    /**
     * Info日志
     *
     * @param msg 消息
     */
    public static void i(Object msg) {
        i(tag, msg);
    }

    /**
     * Info日志
     *
     * @param tag 标签
     * @param msg 消息
     */
    public static void i(String tag, Object msg) {
        i(tag, msg, null);
    }

    /**
     * Info日志
     *
     * @param tag 标签
     * @param msg 消息
     * @param tr  异常
     */
    public static void i(String tag, Object msg, Throwable tr) {
        log(tag, msg.toString(), tr, 'i');
    }

    /**
     * Warn日志
     *
     * @param msg 消息
     */
    public static void w(Object msg) {
        w(tag, msg);
    }

    /**
     * Warn日志
     *
     * @param tag 标签
     * @param msg 消息
     */
    public static void w(String tag, Object msg) {
        w(tag, msg, null);
    }

    /**
     * Warn日志
     *
     * @param tag 标签
     * @param msg 消息
     * @param tr  异常
     */
    public static void w(String tag, Object msg, Throwable tr) {
        log(tag, msg.toString(), tr, 'w');
    }

    /**
     * Error日志
     *
     * @param msg 消息
     */
    public static void e(Object msg) {
        e(tag, msg);
    }

    /**
     * Error日志
     *
     * @param tag 标签
     * @param msg 消息
     */
    public static void e(String tag, Object msg) {
        e(tag, msg, null);
    }

    /**
     * Error日志
     *
     * @param tag 标签
     * @param msg 消息
     * @param tr  异常
     */
    public static void e(String tag, Object msg, Throwable tr) {
        log(tag, msg.toString(), tr, 'e');
    }

    /**
     * 异常打印
     *
     * @param e 消息
     */
    public static void e(String tag, Exception e) {
        if (logSwitch) {
            Logger.t(tag).e(e, "Exception");
        }
    }

    /**
     * json打印
     *
     * @param json json数据
     */
    public static void json(String tag, String json) {
        if (logSwitch) {
            Logger.t(tag).json(json);
        }
    }

    /**
     * xml打印
     *
     * @param xml xml数据
     */
    public static void xml(String tag, String xml) {
        if (logSwitch) {
            Logger.t(tag).xml(xml);
        }
    }

    /**
     * wtf打印
     *
     * @param wtf s
     */
    public static void wtf(String tag, Object wtf) {
        if (logSwitch) {
            Logger.t(tag).wtf("WTF", wtf);
        }
    }

    /**
     * Debug日志
     *
     * @param tag       标签
     * @param msg       消息
     * @param throwable 异常
     */
    public static void d(String tag, Object msg, Throwable throwable) {
        log(tag, msg.toString(), throwable, 'd');
    }

    private static void log(final String tag, final String msg, final Throwable throwable, final char type) {
        if (logSwitch) {
            if ('e' == type && ('e' == logFilter || 'v' == logFilter)) {
                Logger.t(tag).e(msg);
            } else if ('w' == type && ('w' == logFilter || 'v' == logFilter)) {
                Logger.t(tag).w(msg);
            } else if ('d' == type && ('d' == logFilter || 'v' == logFilter)) {
                Logger.t(tag).d(msg);
            } else if ('i' == type && ('d' == logFilter || 'v' == logFilter)) {
                Logger.t(tag).i(msg);
            }
            if (logFileSwitch) {
                //日志写入本地文件逻辑

            }
        }
    }

    private synchronized static void logFlle(char type, String tag, String content) {
        if (content == null) return;
        Date now = new Date();
        String date = new SimpleDateFormat("MM-dd", Locale.getDefault()).format(now);
        String fullPath = dir + date + ".text";
        //等添加了File工具类在打开次方法
//        if (!FileUtils.createOrExistsFile(fullPath)) return;
        String time = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(now);
        String dateLogContent = time + ":" + type + ":" + content + "\n";
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fullPath, true));
            bufferedWriter.write(dateLogContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
