package com.ypwang.hard

class Solution3762 {
    class RemTree(a: IntArray) {
        var n = a.size
        var lo = IntArray(4 * n)
        var hi = IntArray(4 * n)

        init {
            build(1, 0, n - 1, a)
        }

        fun build(idx: Int, l: Int, r: Int, a: IntArray) {
            if (l == r) {
                hi[idx] = a[l]
                lo[idx] = hi[idx]
                return
            }
            val m = (l + r) / 2
            build(idx * 2, l, m, a)
            build(idx * 2 + 1, m + 1, r, a)
            lo[idx] = minOf(lo[idx * 2], lo[idx * 2 + 1])
            hi[idx] = maxOf(hi[idx * 2], hi[idx * 2 + 1])
        }

        fun get(idx: Int, l: Int, r: Int, L: Int, R: Int): IntArray {
            if (R < l || r < L) return intArrayOf(Int.Companion.MAX_VALUE, Int.Companion.MIN_VALUE)
            if (L <= l && r <= R) return intArrayOf(lo[idx], hi[idx])
            val m = (l + r) / 2
            val a = get(idx * 2, l, m, L, R)
            val b = get(idx * 2 + 1, m + 1, r, L, R)
            return intArrayOf(minOf(a[0], b[0]), maxOf(a[1], b[1]))
        }
    }

    class MST(a: LongArray) {
        var n = a.size
        var v = arrayOfNulls<LongArray>(4 * n)
        var p = arrayOfNulls<LongArray>(4 * n)

        init {
            build(1, 0, n - 1, a)
        }

        fun build(idx: Int, l: Int, r: Int, a: LongArray) {
            if (l == r) {
                v[idx] = longArrayOf(a[l])
                p[idx] = longArrayOf(a[l])
                return
            }
            val m = (l + r) / 2
            build(idx * 2, l, m, a)
            build(idx * 2 + 1, m + 1, r, a)
            val L = v[idx * 2]!!
            val R = v[idx * 2 + 1]!!
            val M = LongArray(L.size + R.size)
            var i = 0
            var j = 0
            var k = 0
            while (i < L.size || j < R.size) {
                if (j == R.size || (i < L.size && L[i] <= R[j])) M[k++] = L[i++]
                else M[k++] = R[j++]
            }
            v[idx] = M
            val P = LongArray(M.size)
            var s: Long = 0
            for (t in M.indices) {
                s += M[t]
                P[t] = s
            }
            p[idx] = P
        }

        fun le(idx: Int, l: Int, r: Int, L: Int, R: Int, x: Long): LongArray {
            if (R < l || r < L) return longArrayOf(0, 0)
            if (L <= l && r <= R) {
                val A = v[idx]!!
                val P = p[idx]!!
                val pos = upper(A, x)
                val sum = if (pos > 0) P[pos - 1] else 0
                return longArrayOf(pos.toLong(), sum)
            }
            val m = (l + r) / 2
            val a = le(idx * 2, l, m, L, R, x)
            val b = le(idx * 2 + 1, m + 1, r, L, R, x)
            return longArrayOf(a[0] + b[0], a[1] + b[1])
        }

        fun upper(arr: LongArray, x: Long): Int {
            var l = 0
            var r = arr.size
            while (l < r) {
                val m = (l + r) / 2
                if (arr[m] <= x) l = m + 1
                else r = m
            }
            return l
        }

        fun sum(idx: Int, l: Int, r: Int, L: Int, R: Int): Long {
            if (R < l || r < L) return 0
            if (L <= l && r <= R) return p[idx]!![p[idx]!!.size - 1]
            val m = (l + r) / 2
            return sum(idx * 2, l, m, L, R) + sum(idx * 2 + 1, m + 1, r, L, R)
        }
    }

    fun minOperations(nums: IntArray, k: Int, queries: Array<IntArray>): LongArray {
        val n = nums.size
        val rem = IntArray(n)
        val scaled = LongArray(n)

        for (i in 0..<n) {
            rem[i] = nums[i] % k
            scaled[i] = nums[i] / k.toLong()
        }

        val rt = RemTree(rem)
        val mt = MST(scaled)

        val uniq = scaled.clone().sorted().distinct().toLongArray()

        val ans = LongArray(queries.size)

        for (qi in queries.indices) {
            val (L, R) = queries[qi]

            val g = rt.get(1, 0, n - 1, L, R)
            if (g[0] != g[1]) {
                ans[qi] = -1
                continue
            }

            val len = R - L + 1
            val need = (len + 1) / 2
            val total = mt.sum(1, 0, n - 1, L, R)

            var lo = 0
            var hi = uniq.size - 1
            var best = hi
            while (lo <= hi) {
                val mid = (lo + hi) / 2
                val x = uniq[mid]
                val res = mt.le(1, 0, n - 1, L, R, x)
                if (res[0] >= need) {
                    best = mid
                    hi = mid - 1
                } else lo = mid + 1
            }

            val med = uniq[best]
            val left = mt.le(1, 0, n - 1, L, R, med)
            val cL = left[0]
            val sumL = left[1]
            val cR = len - cL
            val sumR = total - sumL

            ans[qi] = med * cL - sumL + sumR - med * cR
        }

        return ans
    }
}
