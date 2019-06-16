package com.ypwang.hard

class Solution839 {
    fun numSimilarGroups(A: Array<String>): Int {
        if (A.isEmpty()) return 0

        val size = A[0].length
        var group = 0
        val set = A.toMutableSet()
        if (size > 4) {
            while (set.isNotEmpty()) {
                group++

                val similar = mutableSetOf(set.first())

                while (similar.isNotEmpty()) {
                    val one = similar.first()
                    set.remove(one)
                    similar.remove(one)

                    for (another in set) {
                        if (another.zip(one).count { it.first != it.second } == 2) {
                            similar.add(another)
                        }
                    }
                }
            }
        } else {
            while (set.isNotEmpty()) {
                group++
                val similar = mutableSetOf(set.first())

                while (similar.isNotEmpty()) {
                    val one = similar.first()
                    set.remove(one)
                    similar.remove(one)

                    for (i in 0 until size) {
                        for (j in i+1 until size) {
                            val cp = one.toCharArray()
                            val t = cp[i]
                            cp[i] = cp[j]
                            cp[j] = t
                            val new = cp.joinToString("")
                            if (new in set) similar.add(new)
                        }
                    }
                }
            }
        }
        return group
    }
}

fun main() {
    println(Solution839().numSimilarGroups(arrayOf("tars","rats","arts","star")))
}