package com.ypwang.hard

import java.util.*

class Solution3525 {
    private class Node(k: Int) {
        val cnt = IntArray(k)
        var prod = 1
    }

    private class SegTree(nums: IntArray, var k: Int) {
        val n = nums.size
        var tree: Array<Node>
        var s = 1

        init {
            while (s < n)
                s = s shl 1
            tree = Array(2 * s) { Node(k) }

            for (i in 0..<n) {
                val a_mod = nums[i] % k
                tree[s + i].cnt[a_mod] = 1
                tree[s + i].prod = a_mod
            }

            for (p in s - 1 downTo 1)
                tree[p] = merge(tree[2 * p], tree[2 * p + 1])
        }

        fun merge(l: Node, r: Node): Node {
            val res =  Node(k)
            for (i in 0..<k)
                res.cnt[i] = l.cnt[i]
            for (r_b in 0..<k) {
                val c = r.cnt[r_b]
                if (c != 0) {
                    val r_ = (l.prod * r_b) % k
                    res.cnt[r_] += c
                }
            }
            res.prod = (l.prod * r.prod) % k
            return res
        }

        fun update(idx: Int, `val`: Int) {
            var pos = s + idx
            val a_mod = `val` % k
            Arrays.fill(tree[pos].cnt, 0)
            tree[pos].cnt[a_mod] = 1
            tree[pos].prod = a_mod

            pos = pos shr 1
            while (pos > 0) {
                tree[pos] = merge(tree[2 * pos], tree[2 * pos + 1])
                pos = pos shr 1
            }
        }

        fun query(l: Int, r: Int): Node {
            var l = l
            var r = r
            var cnt_l = Node(k)
            var cnt_r = Node(k)
            cnt_r.prod = 1
            cnt_l.prod = cnt_r.prod
            l += s
            r += s
            while (l < r) {
                if ((l and 1) == 1) {
                    cnt_l = merge(cnt_l, tree[l++])
                }
                if ((r and 1) == 1) {
                    cnt_r = merge(tree[--r], cnt_r)
                }
                l = l shr 1
                r = r shr 1
            }
            return merge(cnt_l, cnt_r)
        }
    }

    fun resultArray(nums: IntArray, k: Int, queries: Array<IntArray>): IntArray {
        val st = SegTree(nums, k)
        val res = IntArray(queries.size)
        for (i in queries.indices) {
            val (idx, `val`, start, x) = queries[i]
            st.update(idx, `val`)
            val result = st.query(start, nums.size)
            res[i] = result.cnt[x]
        }
        return res
    }
}
