package com.ypwang.hard

class Solution2213 {
    internal class Node(
        var max: Int,
        var prefSt: Int,
        var prefEnd: Int,
        var suffSt: Int,
        var suffEnd: Int
    )

    internal class SegmentTree(s: String) {
        var tree: Array<Node?> = arrayOfNulls(4 * s.length)
        var s: StringBuilder = StringBuilder(s)

        init {
            build(0, 0, s.length - 1)
        }

        fun merge(left: Node?, right: Node?, tl: Int, tm: Int, tr: Int): Node {
            var max = maxOf(left!!.max, right!!.max)
            val prefSt = left.prefSt
            var prefEnd = left.prefEnd
            var suffSt = right.suffSt
            val suffEnd = right.suffEnd
            if (s[tm] == s[tm + 1]) {
                max = maxOf(max, right.prefEnd - left.suffSt + 1)
                if (left.prefEnd - left.prefSt + 1 == tm - tl + 1) prefEnd = right.prefEnd
                if (right.suffEnd - right.suffSt + 1 == tr - tm) suffSt = left.suffSt
            }
            return Node(max, prefSt, prefEnd, suffSt, suffEnd)
        }

        fun build(pos: Int, tl: Int, tr: Int) {
            if (tl == tr) {
                tree[pos] = Node(1, tl, tl, tr, tr)
            } else {
                val tm = tl + (tr - tl) / 2
                build(2 * pos + 1, tl, tm)
                build(2 * pos + 2, tm + 1, tr)
                tree[pos] = merge(tree[2 * pos + 1], tree[2 * pos + 2], tl, tm, tr)
            }
        }

        fun update(pos: Int, tl: Int, tr: Int, idx: Int, ch: Char) {
            if (tl == tr) {
                tree[pos] = Node(1, tl, tl, tr, tr)
                s.setCharAt(idx, ch)
            } else {
                val tm = tl + (tr - tl) / 2
                if (idx <= tm)
                    update(2 * pos + 1, tl, tm, idx, ch)
                else
                    update(2 * pos + 2, tm + 1, tr, idx, ch)
                tree[pos] = merge(tree[2 * pos + 1], tree[2 * pos + 2], tl, tm, tr)
            }
        }
    }

    fun longestRepeating(s: String, queryCharacters: String, queryIndices: IntArray): IntArray {
        val tree = SegmentTree(s)
        for (i in queryIndices.indices) {
            tree.update(0, 0, s.length - 1, queryIndices[i], queryCharacters[i])
            queryIndices[i] = tree.tree[0]!!.max
        }
        return queryIndices
    }
}