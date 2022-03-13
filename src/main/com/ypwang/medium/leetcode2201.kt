package com.ypwang.medium

class Solution2201 {
    fun digArtifacts(n: Int, artifacts: Array<IntArray>, dig: Array<IntArray>): Int {
        fun hash(a: IntArray): Int =
            a[0] * n + a[1]

        val excavated = dig.map { hash(it) }.toSet()
        return artifacts.count { (r1, c1, r2, c2) ->
            for (i in r1..r2) {
                for (j in c1..c2) {
                    if (hash(intArrayOf(i, j)) !in excavated)
                        return@count false
                }
            }

            true
        }
    }
}