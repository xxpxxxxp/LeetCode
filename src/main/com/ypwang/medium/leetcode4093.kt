package com.ypwang.medium

import java.util.*

class Solution4093 {
    fun maximizeSum(nums: IntArray, k: Int): Long {
        var k = k
        var sum = 0L
        val pq = PriorityQueue<Int>(Comparator.reverseOrder())
        for (i in nums) {
            sum += i.toLong()
            pq.add(getMax(i) - i)
        }
        while (k > 0 && pq.isNotEmpty() && pq.peek() > 0) {
            sum += pq.poll().toLong()
            k--
        }

        return sum
    }

    fun getMax(num: Int): Int {
        var num = num
        val digit = IntArray(10)
        while (num > 0) {
            digit[num % 10]++
            num /= 10
        }
        var ans = 0
        for (i in 9 downTo 0) {
            while (digit[i] > 0) {
                ans = ans * 10 + i
                digit[i]--
            }
        }
        return ans
    }
}
