package com.ypwang.easy

class Solution1903 {
    fun largestOddNumber(num: String): String {
        val idx = num.indexOfLast { (it-'0') % 2 == 1 }
        return if (idx == -1) "" else num.substring(0, idx+1)
    }
}