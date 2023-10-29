package com.ypwang.hard

class Solution2916 {
    private val N = 100005
    private val mod = 1000000007L
    private val a = LongArray(N)
    private val seg = LongArray(4 * N)
    private val segsq = LongArray(4 * N)
    private val lazy = LongArray(4 * N)

    // Build the segment tree.
    private fun build(node: Int, start: Long, end: Long) {
        if (start == end) {
            seg[node] = a[start.toInt()]
            segsq[node] = a[start.toInt()] * a[start.toInt()] % mod
            return
        }
        val mid = start + end shr 1
        build(node shl 1, start, mid)
        build(node shl 1 or 1, mid + 1, end)
        seg[node] = (seg[node shl 1] + seg[node shl 1 or 1]) % mod
        segsq[node] = (segsq[node shl 1] + segsq[node shl 1 or 1]) % mod
    }

    // Update the segment tree and handle lazy propagation.
    private fun update(node: Int, start: Long, end: Long, l: Int, r: Int, `val`: Int) {
        if (lazy[node] != 0L) {
            segsq[node] += ((end - start + 1) * (lazy[node] * lazy[node]) % mod) % mod + 2 * lazy[node] * seg[node]% mod
            segsq[node] %= mod
            seg[node] += (end - start + 1) * lazy[node] % mod
            seg[node] %= mod
            if (start != end) {
                lazy[node shl 1] += lazy[node]
                lazy[node shl 1 or 1] += lazy[node]
            }
            lazy[node] = 0
        }
        if (start > end || start > r || end < l)
            return
        if (l <= start && end <= r) {
            segsq[node] += (end - start + 1) * (`val` * `val`) % mod % mod + 2 * `val` * seg[node] % mod
            segsq[node] %= mod
            seg[node] += (end - start + 1) * `val` % mod
            seg[node] %= mod
            if (start != end) {
                lazy[node shl 1] = lazy[node shl 1] + `val`
                lazy[node shl 1 or 1] = lazy[node shl 1 or 1] + `val`
            }
            return
        }
        val mid = start + end shr 1
        update(node shl 1, start, mid, l, r, `val`)
        update(node shl 1 or 1, mid + 1, end, l, r, `val`)
        seg[node] = (seg[node shl 1] + seg[node shl 1 or 1]) % mod
        segsq[node] = (segsq[node shl 1] + segsq[node shl 1 or 1]) % mod
    }

    fun sumCounts(nums: IntArray): Int {
        val n = nums.size
        for (i in 1..n)
            a[i] = 0L

        // Build the segment tree.
        build(1, 1, n.toLong())
        val prev_seen_at = mutableMapOf<Int, Int>()
        var ans = 0L
        for (i in n - 1 downTo 0) {
            if (nums[i] !in prev_seen_at)
                update(1, 1, n.toLong(), i + 1, n, 1)
            else
                update(1, 1, n.toLong(), i + 1, prev_seen_at[nums[i]]!! - 1, 1)
            prev_seen_at[nums[i]] = i + 1
            ans = (ans + segsq[1]) % mod
        }
        return ans.toInt()
    }
}