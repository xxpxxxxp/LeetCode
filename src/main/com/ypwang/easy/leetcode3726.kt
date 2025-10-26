package com.ypwang.easy

class Solution3726 {
    fun removeZeros(n: Long): Long =
        n.toString().filter { it != '0' }.toLong()
}
