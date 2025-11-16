package com.ypwang.hard

class Solution3748 {
    fun countStableSubarrays(nums: IntArray, queries: Array<IntArray>): LongArray {
        val n = nums.size

        val nextBreak = IntArray(n)
        nextBreak[n - 1] = n

        for (i in n - 2 downTo 0)
            nextBreak[i] = if (nums[i] <= nums[i + 1])
                nextBreak[i + 1]
            else
                i + 1

        val ways = LongArray(n)
        for (i in 0 until n) {
            val len = (nextBreak[i] - i).toLong()
            ways[i] = len * (len + 1) / 2
        }

        val pref = LongArray(n + 1)
        for (i in n - 1 downTo 0)
            pref[i] = pref[i + 1] + ways[i]

        val starts = mutableListOf<Int>()
        val ends = mutableListOf<Int>()

        var p = 0
        while (p < n) {
            val s = p
            var q = p
            while (q + 1 < n && nums[q] <= nums[q + 1]) q++
            starts.add(s)
            ends.add(q)
            p = q + 1
        }

        val B = starts.size

        val blockId = IntArray(n)
        for (b in 0 until B) {
            val s: Int = starts[b]
            val e: Int = ends[b]
            for (idx in s..e)
                blockId[idx] = b
        }

        val blockWays = LongArray(B)
        for (b in 0 until B) {
            val len = ends[b].toLong() - starts[b] + 1L
            blockWays[b] = len * (len + 1L) / 2L
        }

        val prefBlock = LongArray(B + 1)
        for (b in B - 1 downTo 0)
            prefBlock[b] = prefBlock[b + 1] + blockWays[b]

        val ans = LongArray(queries.size)
        for (qi in queries.indices) {
            val (l, r) = queries[qi]
            val bl = blockId[l]
            val br = blockId[r]

            if (bl == br) {
                val len = r.toLong() - l + 1L
                ans[qi] = len * (len + 1L) / 2L
                continue
            }

            val endBl: Int = ends[bl]
            val len1 = endBl.toLong() - l + 1L
            var res = len1 * (len1 + 1L) / 2L

            val startBr: Int = starts[br]
            val len2 = r.toLong() - startBr + 1L
            res += len2 * (len2 + 1L) / 2L

            if (bl + 1 <= br - 1)
                res += prefBlock[bl + 1] - prefBlock[br]

            ans[qi] = res
        }

        return ans
    }
}
