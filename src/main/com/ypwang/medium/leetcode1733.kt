package com.ypwang.medium

class Solution1733 {
    fun minimumTeachings(n: Int, languages: Array<IntArray>, friendships: Array<IntArray>): Int {
        val counts = Array(n) { BooleanArray(500) }
        val exist = BooleanArray(500)
        val sets = languages.map { it.toSet() }.toTypedArray()

        for ((a, b) in friendships) {
            if (sets[a-1].intersect(sets[b-1]).isEmpty()) {
                exist[a-1] = true
                exist[b-1] = true

                for (i in languages[a-1])
                    counts[i-1][a-1] = true

                for (i in languages[b-1])
                    counts[i-1][b-1] = true
            }
        }


        return exist.count { it } - counts.map { it.count { b -> b } }.max()!!
    }
}