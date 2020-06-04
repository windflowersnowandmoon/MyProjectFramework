package com.example.hasee.myprojectframework.contract

/**
 *   $
 *   作   者 :彭付林
 *   邮   箱 :pengfl@kingchannels.com
 *   日   期 :2020/1/3
 *   描   述 :个人信息
 */
class asd {

    fun testcallback1(callback: (String) -> Unit) {
        callback.invoke("这是回调的内容")
        callback("我来了  兄弟们")
    }

    fun testcallback2(value1: Int, value2: Int, callback: (Int, Int) -> Int): Int {
        var result = callback.invoke(0, value2)
        return result * 3
    }

    operator fun invoke(integer: Int?): Int? {
        return integer!! * 80
    }

}