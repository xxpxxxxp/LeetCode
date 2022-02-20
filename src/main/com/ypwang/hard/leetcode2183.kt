package com.ypwang.hard

class Solution2183 {
    private fun gcd(a: Int, b: Int): Int {
        if (a > b)
            return gcd(b, a)

        if (a == 0)
            return b

        return gcd(b % a, a)
    }

    fun coutPairs(nums: IntArray, k: Int): Long {
        var rst = 0L
        val counter = IntArray(100001)
        val factors = mutableSetOf<Int>()
        for (i in 1..k) {
            if (i * i > k)
                break

            if (k % i == 0) {
                factors.add(i)
                factors.add(k / i)
            }
        }

        for (n in nums) {
            rst += counter[k / gcd(k, n)]
            for (f in factors)
                if (n % f == 0)
                    counter[f]++
        }

        return rst
    }
}

fun main() {
    println(Solution2183().coutPairs(intArrayOf(5, 8), 1))
}