package com.ypwang.hard

import java.util.*

class Solution2281 {
    fun totalStrength(strength: IntArray): Int {
        val mod = 1000000007L
        var rst = 0L

        val psl = LongArray(strength.size + 1)
        val pml = LongArray(strength.size + 1)
        val psr = LongArray(strength.size + 1)
        val pmr = LongArray(strength.size + 1)
        val stack = Stack<Int>()

        for ((i, v) in strength.withIndex()) {
            psl[i+1] = (psl[i] + v) % mod
            pml[i+1] = (pml[i] + (i+1) * v) % mod
        }
        for (i in strength.lastIndex downTo 0) {
            psr[i] = (psr[i+1] + strength[i]) % mod
            pmr[i] = (pmr[i+1] + (strength.size - i) * strength[i]) % mod
        }

        for (right in 0..strength.size) {
            while (stack.isNotEmpty() && (right == strength.size || strength[right] <= strength[stack.peek()])) {
                val pivot = stack.pop()
                val left = if (stack.isEmpty()) 0 else stack.peek() + 1
                val leftSum = (mod + pml[pivot + 1] - pml[left] - left * (psl[pivot + 1] - psl[left]) % mod) % mod
                val rightSum = (mod + pmr[pivot + 1] - pmr[right] - (strength.size - right) * (psr[pivot + 1] - psr[right])) % mod
                val allSum = (rightSum * (pivot - left + 1) + leftSum * (right - pivot)) % mod
                rst = (rst + allSum * strength[pivot]) % mod
            }
            stack.push(right)
        }

        return rst.toInt()
    }
}