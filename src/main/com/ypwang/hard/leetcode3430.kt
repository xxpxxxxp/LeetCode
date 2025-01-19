package com.ypwang.hard

import java.util.Deque
import java.util.LinkedList

class Solution3430 {
    fun minMaxSubarraySum(nums: IntArray, k: Int): Long {
        val n = nums.size

        val LMax = LongArray(n)
        val RMax = LongArray(n)
        val stack: Deque<Int> = LinkedList()

        for (i in 0 until n) {
            while (stack.isNotEmpty() && nums[stack.peek()] <= nums[i])
                stack.pop()
            LMax[i] = if (stack.isEmpty()) (i + 1).toLong() else (i - stack.peek()).toLong()
            stack.push(i)
        }

        stack.clear()
        for (i in n - 1 downTo 0) {
            while (stack.isNotEmpty() && nums[stack.peek()] < nums[i])
                stack.pop()
            RMax[i] = if (stack.isEmpty()) (n - i).toLong() else (stack.peek() - i).toLong()
            stack.push(i)
        }

        val LMin = LongArray(n)
        val RMin = LongArray(n)
        stack.clear()

        for (i in 0 until n) {
            while (stack.isNotEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop()
            LMin[i] = if (stack.isEmpty()) (i + 1).toLong() else (i - stack.peek()).toLong()
            stack.push(i)
        }

        stack.clear()
        for (i in n - 1 downTo 0) {
            while (stack.isNotEmpty() && nums[stack.peek()] > nums[i])
                stack.pop()
            RMin[i] = if (stack.isEmpty()) (n - i).toLong() else (stack.peek() - i).toLong()
            stack.push(i)
        }

        var ans = 0L
        for (i in 0 until n)
            ans += nums[i] * qwe(LMax[i], RMax[i], k) + nums[i] * qwe(LMin[i], RMin[i], k)
        return ans
    }

    private fun qwe(L: Long, R: Long, k: Int): Long {
        if (L <= 0 || R <= 0) return 0
        var total = 0L

        val X0 = k.toLong() - R

        var leftCnt = 0L
        if (X0 >= 0) {
            leftCnt = minOf(L, X0 + 1)
        }
        total += R * leftCnt

        val startX = leftCnt
        val endX = L - 1
        if (startX <= endX) {
            val realEnd = minOf(endX, k.toLong() - 1)
            if (startX <= realEnd) {
                val count = realEnd - startX + 1
                val a = startX
                val b = realEnd
                val sumX = (b * (b + 1) / 2) - ((a - 1) * a / 2)
                val temp = k.toLong() * count - sumX
                total += temp
            }
        }

        return maxOf(total, 0)
    }
}
