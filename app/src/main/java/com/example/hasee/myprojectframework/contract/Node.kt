package com.example.hasee.myprojectframework.contract

/**
 *   $
 *   作   者 :彭付林
 *   邮   箱 :pengfl@kingchannels.com
 *   日   期 :2020/4/23
 *   描   述 :个人信息
 */
class Node (val name: String) {

    var children: MutableList<Node> = mutableListOf()
    var attributes: MutableMap<String, String> = mutableMapOf()
    var text: String? = ""

    fun get(name: String) = try {
        children.filter { it.name.equals(name,true)}
    } catch (e: Exception) {
        null
    }

    fun getFirst(name: String) = try {
        children.first { it.name.equals(name,true) }
    } catch (e: Exception) {
        null
    }

}