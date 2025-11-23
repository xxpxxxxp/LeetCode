package com.ypwang.medium

class Solution3752 {
    fun sumUpTo(x: Long): Long =
        x * (x + 1) / 2

    fun lexSmallestNegatedPerm(n: Int, target: Long): IntArray {
        var target = target
        val S = sumUpTo(n.toLong())
        if (target < -S || target > S)
            return IntArray(0)

        val v = mutableListOf<Int>()

        for (i in n downTo 1) {
            if (sumUpTo((i - 1).toLong()) - i >= target) {
                target += i.toLong()
                v.add(-i)
            } else {
                target -= i.toLong()
                v.add(i)
            }
        }

        if (target != 0L)
            return IntArray(0)

        v.sort()

        return v.toIntArray()
    }
}
