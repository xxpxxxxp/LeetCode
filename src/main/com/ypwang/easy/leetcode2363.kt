package com.ypwang.easy

class Solution2363 {
    fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {
        items1.sortBy{ it[0] }
        items2.sortBy{ it[0] }

        var j = 0
        val rst = mutableListOf<List<Int>>()
        for ((v, w) in items1) {
            while (j < items2.size && items2[j][0] < v) {
                rst.add(items2[j].toList())
                j++
            }
            if (j < items2.size && items2[j][0] == v) {
                rst.add(listOf(v, w + items2[j][1]))
                j++
            } else
                rst.add(listOf(v, w))
        }

        rst.addAll(items2.drop(j).map { it.toList() })
        return rst
    }
}