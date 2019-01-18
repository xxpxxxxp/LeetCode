package com.ypwang.medium

class Solution916 {
    fun wordSubsets(A: Array<String>, B: Array<String>): List<String> {
        val all = B.map { it.groupBy { c -> c }.mapValues { c -> c.value.size } }
                .reduce {  a, b ->
                    val r = a.toMutableMap()
                    for ((c, v) in b) {
                        if (c in a) {
                            r[c] = maxOf(a[c]!!, v)
                        } else {
                            r[c] = v
                        }
                    }
                    r.toMap()
                }


        return A.filter {
            val group = it.groupBy { c -> c }.mapValues { c -> c.value.size }
            all.all { i -> i.key in group && group[i.key]!! >= i.value }
        }
    }
}