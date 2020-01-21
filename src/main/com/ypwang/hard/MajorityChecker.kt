package com.ypwang.hard

class MajorityChecker(val arr: IntArray) {
    private val pos: Map<Int, IntArray>
    private val tree: IntArray

    init {
        pos = arr.withIndex().groupBy { it.value }.mapValues { it.value.map { kv -> kv.index }.toIntArray() }
        tree = IntArray(4 * arr.size){ -1 }
        buildTree(0, 0, arr.lastIndex)
    }

    private fun occurrence(num: Int, l: Int, r: Int): Int {
        if (num !in pos) return 0
        return pos[num]!!.count { it in l..r }
    }

    private fun buildTree(pos: Int, l: Int, r: Int) {
        if (l == r) {
            tree[pos] = arr[l]
            return
        }

        val mid = (l + r) / 2
        buildTree(pos * 2 + 1, l, mid)
        buildTree(pos * 2 + 2, mid + 1, r)
        if (tree[pos * 2 + 1] != -1 && occurrence(tree[pos * 2 + 1], l, r) * 2 > r - l + 1)
            tree[pos] = tree[pos * 2 + 1]
        if (tree[pos * 2 + 2] != -1 && occurrence(tree[pos * 2 + 2], l, r) * 2 > r - l + 1)
            tree[pos] = tree[pos * 2 + 2]
    }

    private fun query(pos: Int, l: Int, r: Int, ql: Int, qr: Int): kotlin.Pair<Int, Int> {
        if (l > qr || r < ql) return -1 to -1
        if (ql <= l && r <= qr) {
            if (tree[pos] == -1) return -1 to -1
            val occ = occurrence(tree[pos], ql, qr)
            if (occ * 2 > qr - ql + 1) return tree[pos] to occ
            return -1 to -1
        }

        val mid = (l + r) / 2
        val rl = query(pos * 2 + 1, l, mid, ql, qr)
        if (rl.first > -1) return rl
        val rr = query(pos * 2 + 2, mid + 1, r, ql, qr)
        if (rr.first > -1) return rr
        return -1 to -1
    }

    fun query(left: Int, right: Int, threshold: Int): Int {
        val (l, r) = query(0, 0, arr.lastIndex, left, right)
        if (r >= threshold) return l
        return -1
    }
}

fun main() {
    val checker = MajorityChecker(intArrayOf(1,1,2,2,1,1))
    println(checker.query(0,5,4))
    println(checker.query(0,3,3))
    println(checker.query(2,3,2))
}