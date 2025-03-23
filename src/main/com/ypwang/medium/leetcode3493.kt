package com.ypwang.medium

class Solution3493 {
    fun numberOfComponents(properties: Array<IntArray>, k: Int): Int {
        val dsu = IntArray(properties.size) { it }

        fun root(id: Int): Int {
            if (id != dsu[id])
                dsu[id] = root(dsu[id])

            return dsu[id]
        }

        fun union(a: Int, b: Int) {
            dsu[root(a)] = root(b)
        }

        val p = properties.map { it.toSet() }.toTypedArray()
        for (i in p.indices) {
            for (j in i+1 until properties.size) {
                if (p[i].intersect(p[j]).size >= k)
                    union(i, j)
            }
        }

        return dsu.withIndex().count { it.index == it.value }
    }
}

fun main() {
    println(Solution3493().numberOfComponents(arrayOf(
        intArrayOf(2,3), intArrayOf(5,2), intArrayOf(4,3)
    ), 1))
}