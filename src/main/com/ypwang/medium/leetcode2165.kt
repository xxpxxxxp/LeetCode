package com.ypwang.medium

class Solution2165 {
    fun smallestNumber(num: Long): Long {
        return if (num == 0L)
            0L
        else if (num < 0L)
            -(-num).toString().toList().sortedDescending().joinToString("").toLong()
        else {
            val cs = num.toString()
            val cp = cs.filter { it != '0' }.toList().sorted()
            val c0 = cs.length - cp.size
            (cp.first().toString() + (0 until c0).joinToString(""){ "0" } + cp.drop(1).joinToString("")).toLong()
        }
    }
}