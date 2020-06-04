package com.example.hasee.myprojectframework.contract

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream

/**
 * $
 * 作   者 :彭付林
 * 邮   箱 :pengfl@kingchannels.com
 * 日   期 :2020/4/27
 * 描   述 :个人信息
 */
object IoTest {

    @Throws(IOException::class)
    fun toByteArray(input: InputStream): ByteArray {
        val output = ByteArrayOutputStream()
        val buffer = ByteArray(4096)
        var n = 0
//        val len: Int
//        while (/*(n = input.read(buffer)  */ != -1 ) {
//            output.write(buffer, 0, n)
//        }

        while (((input.read(buffer)).also { n = it }) != -1 ) {
            output.write(buffer, 0, n)
        }

        return output.toByteArray()
    }
}
