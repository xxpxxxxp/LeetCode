package com.ypwang.medium

class Solution2829 {
    fun minimumSum(n: Int, k: Int): Int {
        val seen = mutableSetOf<Int>()
        var rst = 0
        var i = 1
        while (seen.size < n) {
            if (k - i !in seen) {
                seen.add(i)
                rst += i
            }
            i++
        }
        return rst
    }
}
