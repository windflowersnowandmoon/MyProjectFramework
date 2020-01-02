package com.example.common.base.mvp;

/**
 * $
 * 作   者 :彭付林
 * 邮   箱 :pengfl@kingchannels.com
 * 日   期 :2020/1/2
 * 描   述 :V层的基类
 */
public interface IBaseView {

    /**
     * 返回的一般错误信息
     *
     * @param msg s
     */
    void onError(String msg);

    /**
     * 网络错误
     *
     * @param netMsg s
     */
    void onNetError(String netMsg);



}
