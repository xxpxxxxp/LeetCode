package com.ypwang.medium

class Solution763 {
    fun partitionLabels(S: String): List<Int> {
        val indexs = S.withIndex().groupBy { it.value }
                .mapValues { it.value.map { kv -> kv.index } }
                .mapValues { Pair(it.value.min()!!, it.value.max()!!) }

        val rst = mutableListOf<Int>()

        var start = 0

        while (true) {
            var curmax = indexs[S[start]]!!.second
            var next = start
            while (true) {
                val nextmax = S.substring(next, curmax+1).toSet().map { indexs[it]!!.second }.max()!!
                if (nextmax == curmax) {
                    rst.add(curmax - start + 1)
                    break
                }
                next = curmax + 1
                curmax = nextmax
            }

            if (curmax == S.lastIndex) {
                break
            }

            start = curmax + 1
        }
        return rst
    }
}

fun main() {
    println(Solution763().partitionLabels("ababcbacadefegdehijhklij"))
}