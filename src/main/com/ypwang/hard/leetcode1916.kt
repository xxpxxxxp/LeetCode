package com.ypwang.hard

class Solution1916 {
    private val mod = 1000000007

    fun waysToBuildRooms(prevRoom: IntArray): Int {
        val n = prevRoom.size
        val tree: Array<ArrayList<Int>?> = arrayOfNulls(n)

        for (i in 1 until prevRoom.size) {
            if (tree[prevRoom[i]] == null)
                tree[prevRoom[i]] = arrayListOf()

            tree[prevRoom[i]]!!.add(i)
        }

        val size = IntArray(n) { -1 }

        fun dfs(root: Int): Int {
            if (size[root] == -1)
                size[root] = 1 + (tree[root]?.sumBy { dfs(it) } ?: 0)

            return size[root]
        }

        dfs(0)

        // n!
        var nFact: Long = 1
        for (i in 2..n) {
            nFact = nFact * i % mod
        }

        val d = size.fold(1L) { acc, i -> acc * i % mod }.toInt()
        return (nFact * modInverse(d, mod) % mod).toInt()
    }

    // Fermat's little theorem, if m is prime, then a * a^(m-2) % m === 1 % m
    private fun modInverse(a: Int, m: Int): Int {
        return power(a, m - 2, m)
    }

    private fun power(x: Int, y: Int, m: Int): Int {
        if (y == 0) return 1
        var p = power(x, y / 2, m) % m
        p = (p * p.toLong() % m).toInt()
        return if (y % 2 == 0) p else (x * p.toLong() % m).toInt()
    }
}