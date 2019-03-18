package com.ypwang.medium

class Solution60 {
    fun getPermutation(n: Int, k: Int): String {
        if (n == 1) {
            return n.toString()
        }

        val chooses = MutableList(n){ it + 1 }
        var index = k - 1

        var cur = (1 until n).reduce { acc, i -> acc * i }
        val rst = mutableListOf<Int>()
        for (i in (n - 1) downTo 1) {
            rst.add(chooses[index / cur])
            chooses.removeAt(index / cur)
            index %= cur
            cur /= i
        }
        rst.add(chooses.first())

        return rst.joinToString("")
    }
}

fun main(args: Array<String>) {
    println(Solution60().getPermutation(4, 9))
}