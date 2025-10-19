package com.ypwang.hard

class SegmentTree(var n: Int) {
    var minTree: IntArray = IntArray(4 * n)
    var maxTree: IntArray = IntArray(4 * n)
    var lazy: IntArray = IntArray(4 * n)

    private fun push(node: Int, start: Int, end: Int) {
        if (lazy[node] != 0) {
            minTree[node] += lazy[node]
            maxTree[node] += lazy[node]
            if (start != end) {
                lazy[2 * node] += lazy[node]
                lazy[2 * node + 1] += lazy[node]
            }
            lazy[node] = 0
        }
    }

    fun updateRange(node: Int, start: Int, end: Int, l: Int, r: Int, `val`: Int) {
        push(node, start, end)
        if (start > end || start > r || end < l) {
            return
        }
        if (l <= start && end <= r) {
            lazy[node] += `val`
            push(node, start, end)
            return
        }
        val mid = (start + end) / 2
        updateRange(2 * node, start, mid, l, r, `val`)
        updateRange(2 * node + 1, mid + 1, end, l, r, `val`)
        minTree[node] = minOf(minTree[2 * node], minTree[2 * node + 1])
        maxTree[node] = maxOf(maxTree[2 * node], maxTree[2 * node + 1])
    }

    fun findLeftmostZero(node: Int, start: Int, end: Int): Int {
        push(node, start, end)
        if (minTree[node] > 0 || maxTree[node] < 0)
            return -1
        if (start == end)
            return if (minTree[node] == 0) start else -1
        val mid = (start + end) / 2
        val left = findLeftmostZero(2 * node, start, mid)
        if (left != -1) return left
        return findLeftmostZero(2 * node + 1, mid + 1, end)
    }
}

class Solution3721 {
    fun longestBalanced(nums: IntArray): Int {
        val n = nums.size
        val prev = mutableMapOf<Int, Int>()

        val st = SegmentTree(n)
        var res = 0

        for (r in 0 until n) {
            val v = nums[r]
            val `val` = if (v % 2 == 0) 1 else -1

            if (v in prev)
                st.updateRange(1, 0, n - 1, 0, prev[v]!!, -`val`)

            st.updateRange(1, 0, n - 1, 0, r, `val`)
            prev[v] = r

            val l = st.findLeftmostZero(1, 0, n - 1)
            if (l != -1 && l <= r)
                res = maxOf(res, r - l + 1)
        }

        return res
    }
}
