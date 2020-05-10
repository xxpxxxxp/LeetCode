package com.ypwang.easy

class Solution1441 {
    fun buildArray(target: IntArray, n: Int): List<String> {
        var i = 1
        val rst = mutableListOf<String>()
        for (t in target) {
            rst.add("Push")
            while (i != t) {
                rst.add("Pop")
                rst.add("Push")
                i++
            }

            i++
        }
        return rst
    }
}