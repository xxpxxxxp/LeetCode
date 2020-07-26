package com.ypwang.hard

class Solution1526 {
    fun minNumberOperations(target: IntArray): Int {
        var rst = 0
        var pre = 0
        for (i in target) {
            rst += maxOf(i - pre, 0)
            pre = i
        }

        return rst
    }
}