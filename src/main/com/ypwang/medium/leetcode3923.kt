package com.ypwang.medium

class Solution3923 {
    fun minGenerations(points: Array<IntArray>, target: IntArray): Int {
        val set = mutableSetOf<String>()
        val list = mutableListOf<IntArray>()
        for (p in points) {
            val (a, b, c) = p
            set.add("$a,$b,$c")
            list.add(p)
            if (a == target[0] && b == target[1] && c == target[2])
                return 0
        }

        var c = 0
        while (true) {
            c++
            val newList = mutableListOf<IntArray>()
            for (i in 0 until list.size) {
                for (j in i + 1 until list.size) {
                    val a = list[i]
                    val b = list[j]
                    if (a[0] == b[0] && a[1] == b[1] && a[2] == b[2])
                        continue

                    val e = (a[0] + b[0]) / 2
                    val f = (a[1] + b[1]) / 2
                    val g = (a[2] + b[2]) / 2
                    val str = "$e,$f,$g"
                    if (str !in set) {
                        set.add(str)
                        val arr = intArrayOf(e, f, g)
                        if (e == target[0] && f == target[1] && g == target[2])
                            return c

                        newList.add(arr)
                    }
                }
            }
            if (newList.isEmpty())
                return -1

            list.addAll(newList)
        }
    }
}
