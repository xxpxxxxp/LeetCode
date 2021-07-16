package com.ypwang.hard

class Solution1931 {
    fun colorTheGrid(m: Int, n: Int): Int {
        val mod = 1000000007
        val valid = mutableListOf<Int>()

        fun fill(mask: Int, idx: Int) {
            if (idx == m) {
                valid.add(mask)
                return
            }

            val pre = if (idx == 0) -1 else (mask shr (idx-1)*3)
            for (i in listOf(1, 2, 4)) {
                if (i != pre)
                    fill(mask or (i shl idx*3), idx+1)
            }
        }

        fill(0, 0)

        val follow = Array(valid.size) { mutableListOf<Int>() }

        for ((i, m1) in valid.withIndex()) {
            for ((j, m2) in valid.withIndex()) {
                if (m1 and m2 == 0)
                    follow[i].add(j)
            }
        }

        // could use matrix fast power to optimize
        return (1 until n).fold(IntArray(valid.size){1}) { arr, _ ->
            val next = IntArray(valid.size)

            for ((i, v) in arr.withIndex()) {
                for (j in follow[i])
                    next[j] = (next[j] + v) % mod
            }

            next
        }.reduce { a, b -> (a + b) % mod }
    }
}

fun main() {
    println(Solution1931().colorTheGrid(1, 1))
    println(Solution1931().colorTheGrid(1, 2))
    println(Solution1931().colorTheGrid(5, 5))
}