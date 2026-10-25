package com.ypwang.hard

class Solution4095 {
    fun countStaircase(nums: IntArray): Int {
        val n = nums.size
        val ind = IntArray(n)
        val pos = mutableMapOf<Int, MutableList<Int>>()

        for (i in 0 until n) {
            pos.putIfAbsent(nums[i], mutableListOf())
            ind[i] = pos[nums[i]]!!.size
            pos[nums[i]]!!.add(i)
        }

        var res = 0
        for (i in 0 until n) {
            val seen = mutableSetOf<Int>()
            var L = i
            var R = n
            var j = i
            while (j < R) {
                val a = nums[j]
                if (a in seen) {
                    j++
                    continue
                }
                seen.add(a)
                val k = seen.size
                val lst = pos[a]!!
                if (ind[j] + k - 1 >= lst.size)
                    break

                val L2 = lst[ind[j] + k - 1]
                val R2 = if (ind[j] + k < lst.size) lst[ind[j] + k] else n
                L = maxOf(L, L2)
                R = minOf(R, R2)
                if (L > R)
                    break

                val endIdx = i + k * (k + 1) / 2 - 1
                if (endIdx in L until R)
                    res++

                j++
            }
        }

        return res
    }
}
