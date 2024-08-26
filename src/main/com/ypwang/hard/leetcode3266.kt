package com.ypwang.hard

import java.util.*

class Solution3266 {
    val mod = 1000000007L

    fun powerMod(base: Long, exp: Long, mod: Long): Long {
        var base = base
        var exp = exp
        var result = 1L
        while (exp > 0) {
            if (exp % 2 == 1L)
                result = (result * base) % mod
            base = (base * base) % mod
            exp /= 2
        }
        return result
    }

    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        if (multiplier == 1)
            return nums

        val pq = PriorityQueue(compareBy<Pair<Long, Int>> { it.first }.thenBy { it.second })
        val n = nums.size
        for (i in 0 until n)
            pq.add(Pair(nums[i].toLong(), i))

        val m1 = mutableSetOf<Int>()

        var k = k
        while (true) {
            if (m1.size == n || k == 0)
                break

            val (x, y) = pq.poll()
            val newX = x * multiplier
            pq.add(Pair(newX, y))
            m1.add(y)
            k--
        }

        val v = LongArray(n)
        for ((x, y) in pq)
            v[y] = x

        val rep = k / n
        var md = k % n

        val m = mutableMapOf<Int, Int>()
        while (pq.isNotEmpty()) {
            val x = pq.poll().second
            m[x] = rep
            if (md > 0) {
                m[x] = m[x]!! + 1
                md--
            }
        }

        for (i in 0 until n) {
            val mlt = powerMod(multiplier.toLong(), m[i]!!.toLong(), mod)
            v[i] = ((v[i] % mod) * (mlt % mod)) % mod
            nums[i] = v[i].toInt()
        }

        return nums
    }
}
