package com.ypwang.easy

class Solution2571 {
    fun minOperations(n: Int): Int {
        var rst = 0
        var n = n
        while (n > 0) {
            if (n and 3 == 3) {
                n++
                rst++
            } else {
                rst += n and 1
                n = n shr 1
            }
        }
        return rst
    }
}

fun main() {
    println(Solution2571().minOperations(39))
}