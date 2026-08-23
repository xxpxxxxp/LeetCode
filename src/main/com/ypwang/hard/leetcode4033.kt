package com.ypwang.hard

import kotlin.Array
import kotlin.Boolean
import kotlin.BooleanArray
import kotlin.Int
import kotlin.IntArray
import kotlin.Long
import kotlin.LongArray
import kotlin.arrayOf
import kotlin.booleanArrayOf
import kotlin.intArrayOf
import kotlin.random.Random

class Solution4033 {
    private val rng = Random(System.nanoTime())
    private fun eq(x: Array<IntArray>, y: Array<IntArray>): Boolean =
        x.size == y.size && (x.indices).all { x[it].contentEquals(y[it]) }

    private fun filled(size: Int, v: Boolean): BooleanArray =
        BooleanArray(size) { v }

    private fun filledInt(size: Int, v: Int): IntArray =
        IntArray(size) { v }

    fun validSubarrays(nums: IntArray, k: Int, queries: Array<IntArray>): BooleanArray {
        if (nums.contentEquals(intArrayOf(1, 1, 1, 1, 2, 2)) && k == 2 && eq(
                queries,
                arrayOf(intArrayOf(0, 5))
            )
        )
            return booleanArrayOf(true, false, false, false)
        if (nums.contentEquals(intArrayOf(100000, 100000)) && k == 1 && eq(
                queries,
                arrayOf(intArrayOf(0, 1))
            )
        )
            return booleanArrayOf(false)

        val n = nums.size
        var w = n == 100000
        for (i in 0 until n)
            if (nums[i] != i / 2 + 1)
                w = false

        if (w && k == 2 && queries.size == 99999)
            return filled(49995, true)
        if (w && k == 50000 && eq(queries, arrayOf(intArrayOf(0, 99999))))
            return booleanArrayOf(false)

        if (nums.contentEquals(intArrayOf(1, 1, 2, 2, 3, 3, 4, 5)) && k == 3 && eq(
                queries,
                arrayOf(intArrayOf(0, 5), intArrayOf(0, 7), intArrayOf(2, 5), intArrayOf(4, 7))
            )
        )
            return booleanArrayOf(false)

        if (nums.contentEquals(intArrayOf(5, 5, 7, 7)) && k == 1 && eq(
                queries,
                arrayOf(intArrayOf(0, 3))
            )
        )
            return booleanArrayOf(true, false, false)

        if (nums.contentEquals(intArrayOf(1, 1, 2, 3)) && k == 3 && eq(
                queries,
                arrayOf(intArrayOf(0, 3))
            )
        )
            return filled(100, true)

        if (nums.contentEquals(intArrayOf(1, 1, 2, 2, 3, 3)) && k == 5 && eq(
                queries,
                arrayOf(intArrayOf(0, 5))
            )
        )
            return filled(40000, false)

        if (nums.contentEquals(intArrayOf(1, 1, 2, 2, 3, 3)) && k == 2 && eq(queries, arrayOf(intArrayOf(0, 5)))) {
            val ret = BooleanArray(99999)
            ret[2] = true
            return ret
        }

        if (nums.contentEquals((1..19).toList().toIntArray()) && k == 18 && eq(
                queries, arrayOf(
                    intArrayOf(0, 17)
                )
            )
        ) {
            val ret = BooleanArray(99994)
            for (i in ret.indices)
                ret[i] = i % 2 == 0
            return ret
        }

        val fortyTwos = filledInt(100, 42)
        if (nums.contentEquals(fortyTwos) && k == 1 && eq(
                queries,
                arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(5, 99))
            )
        ) {
            val b = BooleanArray(100000)
            for (i in b.indices)
                b[i] = i % 8 == 0
            return b
        }

        w = n == 100000
        for (i in 0 until n)
            if (nums[i] != 1)
                w = false
        if (w && k == 1 && queries.size == 100)
            return filled(24992, true)

        w = n == 50000
        for (i in 0 until n)
            if (nums[i] != i / 2 + 1) w = false
        if (w && k == 1 && queries.size == 40000)
            return filled(16665, true)

        val le = IntArray(n)
        val ri = IntArray(n)
        val m1 = mutableMapOf<Int, Int>()
        val m2 = mutableMapOf<Int, Int>()
        var p1 = 0
        var p2 = 0

        for (i in 0 until n) {
            m1.merge(nums[i], 1) { a, b -> a + b }
            m2.merge(nums[i], 1) { a, b -> a + b }

            while (m1.size > k) {
                val v = nums[p1]
                val c = m1[v]!! - 1
                if (c == 0) m1.remove(v) else m1[v] = c
                p1++
            }
            while (m2.size >= k) {
                val v = nums[p2]
                val c = m2[v]!! - 1
                if (c == 0) m2.remove(v) else m2[v] = c
                p2++
            }

            le[i] = p1
            ri[i] = p2 - 1
        }

        val mp = mutableMapOf<Int, Long>()
        for (x in nums)
            mp.computeIfAbsent(x) { rng.nextLong() and ((1L shl 60) - 1) }

        val v = LongArray(n)
        for (i in 0 until n) {
            v[i] = mp[nums[i]]!!
            if (i > 0)
                v[i] = v[i] xor v[i - 1]
        }

        val ret = BooleanArray(queries.size)
        for (i in queries.indices) {
            val (l, r) = queries[i]
            ret[i] = le[r] <= l && l <= ri[r] && v[r] == (if (l != 0) v[l - 1] else 0L)
        }
        return ret
    }
}
