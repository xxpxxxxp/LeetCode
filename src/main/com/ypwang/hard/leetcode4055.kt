package com.ypwang.hard

import java.util.*
import kotlin.math.max
import kotlin.math.min


class Solution4055 {
    lateinit var mx: IntArray
    lateinit var second: IntArray
    lateinit var mn: IntArray
    lateinit var cntMx: IntArray
    lateinit var active: IntArray
    lateinit var lazy: IntArray

    fun build(node: Int, l: Int, r: Int) {
        mx[node] = NEG
        second[node] = NEG
        mn[node] = INF
        cntMx[node] = 0
        active[node] = 0
        lazy[node] = INF

        if (l == r) return

        val mid = (l + r) ushr 1
        build(node shl 1, l, mid)
        build(node shl 1 or 1, mid + 1, r)
    }

    fun applyChmin(node: Int, x: Int) {
        if (mx[node] <= x) return

        mn[node] = min(mn[node], x)
        mx[node] = x
        lazy[node] = min(lazy[node], x)
    }

    fun push(node: Int) {
        if (lazy[node] != INF) {
            applyChmin(node shl 1, lazy[node])
            applyChmin(node shl 1 or 1, lazy[node])
            lazy[node] = INF
        }
    }

    fun pull(node: Int) {
        val left = node shl 1
        val right = left or 1

        mn[node] = min(mn[left], mn[right])
        active[node] = active[left] + active[right]

        if (mx[left] > mx[right]) {
            mx[node] = mx[left]
            cntMx[node] = cntMx[left]
            second[node] = max(second[left], mx[right])
        } else if (mx[left] < mx[right]) {
            mx[node] = mx[right]
            cntMx[node] = cntMx[right]
            second[node] = max(mx[left], second[right])
        } else {
            mx[node] = mx[left]
            cntMx[node] = cntMx[left] + cntMx[right]
            second[node] = max(second[left], second[right])
        }
    }

    fun insert(node: Int, l: Int, r: Int, pos: Int) {
        if (l == r) {
            mx[node] = INF
            second[node] = NEG
            mn[node] = INF
            cntMx[node] = 1
            active[node] = 1
            lazy[node] = INF
            return
        }

        push(node)

        val mid = (l + r) ushr 1

        if (pos <= mid) {
            insert(node shl 1, l, mid, pos)
        } else {
            insert(node shl 1 or 1, mid + 1, r, pos)
        }

        pull(node)
    }

    fun rangeChmin(node: Int, l: Int, r: Int, ql: Int, qr: Int, x: Int) {
        if (ql > r || qr < l || active[node] == 0 || mx[node] <= x) {
            return
        }

        if (ql <= l && r <= qr && second[node] < x) {
            applyChmin(node, x)
            return
        }

        push(node)

        val mid = (l + r) ushr 1

        rangeChmin(node shl 1, l, mid, ql, qr, x)
        rangeChmin(node shl 1 or 1, mid + 1, r, ql, qr, x)

        pull(node)
    }

    fun query(node: Int, l: Int, r: Int, ql: Int, qr: Int, x: Int): Int {
        if (ql > r || qr < l || active[node] == 0 || mx[node] < x) {
            return 0
        }

        if (ql <= l && r <= qr && mn[node] >= x) {
            return active[node]
        }

        if (l == r) {
            return if (mx[node] >= x) active[node] else 0
        }

        push(node)

        val mid = (l + r) ushr 1

        return (query(node shl 1, l, mid, ql, qr, x)
                + query(node shl 1 or 1, mid + 1, r, ql, qr, x))
    }

    fun shadowPairs(nums: IntArray): Int {
        val n = nums.size
        val order = LongArray(n)

        for (i in 0..<n) {
            order[i] = (nums[i].toLong() shl 32) or (i.toLong() and 0xffffffffL)
        }

        Arrays.sort(order)

        val rank = IntArray(n)

        for (i in 0..<n) {
            rank[order[i].toInt()] = i
        }

        mx = IntArray(4 * n)
        second = IntArray(4 * n)
        mn = IntArray(4 * n)
        cntMx = IntArray(4 * n)
        active = IntArray(4 * n)
        lazy = IntArray(4 * n)

        build(1, 0, n - 1)

        var res: Long = 0

        for (j in 0..<n) {
            val b = nums[j]
            val right = lowerBound(order, b) - 1

            if (right >= 0) {
                res += query(1, 0, n - 1, 0, right, b).toLong()
            }

            insert(1, 0, n - 1, rank[j])

            val left = lowerBound(order, nums[j]) - 1

            if (left >= 0) {
                rangeChmin(
                    1, 0, n - 1, 0, left, nums[j]
                )
            }
        }

        return res.toInt()
    }

    fun lowerBound(order: LongArray, target: Int): Int {
        var left = 0
        var right = order.size

        while (left < right) {
            val mid = left + (right - left) / 2
            val `val` = (order[mid] ushr 32).toInt()

            if (`val` < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return left
    }

    companion object {
        const val INF: Int = 1000000007
        val NEG: Int = -1
    }
}
