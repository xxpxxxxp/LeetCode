package com.ypwang.hard

import java.util.*

class Solution2197 {
    private fun gcd(a: Int, b: Int): Int {
        if (a > b)
            return gcd(b, a)

        if (a == 0)
            return b

        return gcd(b % a, a)
    }

    fun replaceNonCoprimes(nums: IntArray): List<Int> {
        val stack = Stack<Int>()

        for (n in nums) {
            var n = n
            while (stack.isNotEmpty()) {
                val t = stack.peek()
                val m = gcd(t, n)
                if (m == 1)
                    break

                stack.pop()
                n = n / m * t
            }
            stack.add(n)
        }

        return stack.toList()
    }
}