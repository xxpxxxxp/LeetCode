package com.ypwang.hard

class Solution2468 {
    fun splitMessage(message: String, limit: Int): Array<String> {
        var cur = 0
        var k = 0
        while (3 + k.toString().length * 2 < limit && cur + message.length + (3 + k.toString().length) * k > limit * k) {
            k++
            cur += k.toString().length
        }

        val rst = mutableListOf<String>()
        var i = 0
        if (3 + k.toString().length * 2 < limit) {
            for (j in 1 .. k) {
                val l = limit - 3 - j.toString().length - k.toString().length
                rst.add("${message.substring(i, minOf(i+l, message.length))}<$j/$k>")
                i += l
            }
        }

        return rst.toTypedArray()
    }
}

fun main() {
    println(Solution2468().splitMessage("short message", 15).toList())
}