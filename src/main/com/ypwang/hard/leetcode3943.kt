package com.ypwang.hard

class Solution3943 {
    fun numberOfPairs(nums1: IntArray, nums2: IntArray, queries: Array<IntArray>): IntArray {
        val n = nums2.size
        val a = nums2
        val B = Math.sqrt(n.toDouble()).toInt() + 1
        val blocks = (n + B - 1) / B
        val lazy = IntArray(blocks)
        val freq = Array(blocks) { mutableMapOf<Int, Int>() }
        for (i in 0 until n) {
            val b = i / B
            freq[b][a[i]] = freq[b].getOrDefault(a[i], 0) + 1
        }

        fun rebuild(b: Int) {
            freq[b].clear()
            val l = b * B
            val r = minOf(a.size - 1, l + B - 1)
            for (i in l..r)
                freq[b][a[i]] = freq[b].getOrDefault(a[i], 0) + 1
        }

        fun push(b: Int) {
            if (lazy[b] == 0)
                return
            val l = b * B
            val r = minOf(a.size - 1, l + B - 1)
            for (i in l..r)
                a[i] += lazy[b]

            lazy[b] = 0
        }

        fun rangeAdd(l: Int, r: Int, `val`: Int) {
            val bl = l / B
            val br = r / B
            if (bl == br) {
                push(bl)
                for (i in l..r)
                    a[i] += `val`
                rebuild(bl)
                return
            }

            push(bl)
            val end1 = (bl + 1) * B - 1
            for (i in l..end1)
                a[i] += `val`
            rebuild(bl)

            push(br)
            val start2 = br * B
            for (i in start2..r)
                a[i] += `val`
            rebuild(br)

            for (b in bl + 1 until br)
                lazy[b] += `val`
        }

        fun countValue(x: Int): Int {
            var ans = 0
            for (b in freq.indices) {
                val need = x - lazy[b]
                ans += freq[b].getOrDefault(need, 0)
            }
            return ans
        }

        val res = mutableListOf<Int>()
        for (q in queries) {
            if (q[0] == 1) {
                val (_, l, r, `val`) = q
                rangeAdd(l, r, `val`)
            } else
                res.add(nums1.sumOf { countValue(q[1] - it) })
        }

        return res.toIntArray()
    }
}
