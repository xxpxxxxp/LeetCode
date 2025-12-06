package com.ypwang.hard

class Solution {
    class Tree(var n: Int) {
        var t = IntArray(n + 2)

        fun update(i: Int, v: Int) {
            var i = i
            while (i < t.size) {
                t[i] += v
                i += i and -i
            }
        }

        fun query(i: Int): Int {
            var i = i
            var res = 0
            while (i > 0) {
                res += t[i]
                i -= i and -i
            }
            return res
        }

        fun getQuery(l: Int, r: Int): Int {
            if (l > r) return 0
            return query(r) - query(l - 1)
        }
    }

    fun minInversionCount(nums: IntArray, k: Int): Long {
        val n = nums.size

        val s = nums.sorted().toIntArray()
        val rank = mutableMapOf<Int, Int>()
        var r = 1
        for (x in s)
            if (x !in rank)
                rank[x] = r++

        val c = IntArray(n)
        for (i in 0 until n)
            c[i] = rank[(nums[i])]!!

        val mv = r + 1
        val t = Tree(mv)

        var inv = 0L
        for (i in 0 until k) {
            inv += t.getQuery(c[i] + 1, mv).toLong()
            t.update(c[i], 1)
        }

        var mininv = inv

        for (i in k until n) {
            t.update(c[i - k], -1)
            inv -= t.getQuery(1, c[i - k] - 1).toLong()

            inv += t.getQuery(c[i] + 1, mv).toLong()
            t.update(c[i], 1)

            mininv = minOf(mininv, inv)
        }

        return mininv
    }
}
