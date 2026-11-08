package com.ypwang.hard

class Solution4109 {
    fun countSuffix(nums: IntArray, target: IntArray): IntArray {
        val n = nums.size
        val m = target.size
        val ans = IntArray(m - n + 1)
        val com = IntArray(n + 1 + m)
        System.arraycopy(nums, 0, com, 0, n)
        System.arraycopy(target, 0, com, n + 1, m)
        val lCom = com.size
        val z = IntArray(lCom)
        var L = 0
        var R = 0
        for (i in 1 until lCom) {
            if (i <= R)
                z[i] = minOf(R - i + 1, z[i - L])
            while (i + z[i] < lCom && com[z[i]] == com[i + z[i]])
                z[i]++
            if (i + z[i] - 1 > R) {
                L = i
                R = i + z[i] - 1
            }
        }
        val pre = IntArray(m)
        for (i in 1 until m)
            pre[i] = if (target[i - 1] >= target[i]) pre[i - 1] else i

        val freq = IntArray(100001)
        var bad = 0
        for (x in nums) {
            val fx = freq[x]
            if (fx > 0 && fx == 1)
                bad--
            freq[x] = fx - 1
        }
        for (i in 0 until n) {
            val x = target[i]
            val fx = freq[x]
            if (fx == 0)
                bad++
            freq[x] = fx + 1
        }
        val zs = n + 1
        for (k in 0..m - n) {
            if (bad == 0) {
                val minI = maxOf(0, pre[k + n - 1] - k)
                val maxI = minOf(n - 1, z[zs + k])
                if (maxI >= minI)
                    ans[k] = maxI - minI + 1
            }
            if (k + n < m) {
                val x1 = target[k]
                val fx1 = freq[x1]
                if (fx1 > 0 && fx1 == 1)
                    bad--
                freq[x1] = fx1 - 1
                val x2 = target[k + n]
                val fx2 = freq[x2]
                if (fx2 == 0)
                    bad++
                freq[x2] = fx2 + 1
            }
        }
        return ans
    }
}
