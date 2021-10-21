package com.ypwang.hard

class Solution1819 {
    private fun gcd(a: Int, b: Int): Int {
        if (a > b) return gcd(b, a)
        if (a == 0) return b
        return gcd(b % a, a)
    }

    fun countDifferentSubsequenceGCDs(nums: IntArray): Int {
        var rst = 0
        val max = nums.maxOrNull()!!
        val flags = BooleanArray(max+1)
        nums.forEach { flags[it] = true }
        for (i in 1..max) {
            var cur = if (flags[i]) i else 0

            var n = i
            while (n <= max && cur != i) {
                if (flags[n])
                    cur = gcd(cur, n)

                n += i
            }

            if (cur == i)
                rst++
        }

        return rst
    }
}

fun main() {
    println(Solution1819().countDifferentSubsequenceGCDs(intArrayOf(6,10,3)))
    println(Solution1819().countDifferentSubsequenceGCDs(intArrayOf(5,15,40,5,6)))
}