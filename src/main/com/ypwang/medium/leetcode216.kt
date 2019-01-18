package com.ypwang.medium

class Solution216 {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val all = List(9){it+1}.toSet()
        val rst = mutableSetOf<List<Int>>()

        fun helper(sum: Int, used: MutableList<Int>) {
            if (sum < 0) {
                return
            }

            if (used.size == k && sum == 0) {
                rst.add(used.toList())
            }

            for (i in all) {
                if (i !in used && (used.isEmpty() || i > used.last())) {
                    used.add(i)
                    helper(sum - i, used)
                    used.removeAt(used.lastIndex)
                }
            }
        }

        helper(n, mutableListOf())
        return rst.toList()
    }
}

fun main(args: Array<String>) {
    println(Solution216().combinationSum3(3, 7))
}