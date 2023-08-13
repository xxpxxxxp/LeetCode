package com.ypwang.hard

import java.util.*

class Solution2818 {
    private val MOD = 1000000007

    fun maximumScore(nums: List<Int>, k: Int): Int {
        val upper = nums.max()!! + 1
        val prime = BooleanArray(upper) { true }
        val primeScore = IntArray(upper)
        prime[0] = false
        prime[1] = false

        for (i in 2 until upper) {
            if (prime[i]) {
                var j = i
                while (j < upper) {
                    primeScore[j]++
                    prime[j] = false
                    j += i
                }
            }
        }

        val n = nums.size
        val nextGreaterElement = IntArray(n) { n }
        var s = Stack<Int>()
        for (i in n - 1 downTo 0) {
            while (s.isNotEmpty() && primeScore[nums[i]] >= primeScore[nums[s.peek()]])
                s.pop()
            nextGreaterElement[i] = if (s.empty()) n else s.peek()
            s.push(i)
        }
        val prevGreaterOrEqualElement = IntArray(n) { -1 }
        s.clear()
        for (i in 0 until n) {
            while (s.isNotEmpty() && primeScore[nums[i]] > primeScore[nums[s.peek()]])
                s.pop()
            prevGreaterOrEqualElement[i] = if (s.empty()) -1 else s.peek()
            s.push(i)
        }
        var rst = 1
        var k = k
        for ((idx, num) in nums.withIndex().sortedByDescending { it.value }) {
            val operations = minOf((idx - prevGreaterOrEqualElement[idx]) * (nextGreaterElement[idx] - idx), k)
            rst = (1L * rst * pow(num, operations) % MOD).toInt()
            k -= operations
            if (k == 0)
                return rst
        }
        return rst
    }

    fun pow(x: Int, n: Int): Int {
        var x = x
        var n = n
        var rst = 1
        while (n > 0) {
            if (n % 2 == 1)
                rst = (1L * rst * x % MOD).toInt()
            x = (1L * x * x % MOD).toInt()
            n /= 2
        }
        return rst
    }
}