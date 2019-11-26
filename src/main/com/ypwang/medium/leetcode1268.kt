package com.ypwang.medium

class Solution1268 {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        val rst = mutableListOf<List<String>>()
        var p = products.sorted()
        for ((i, c) in searchWord.withIndex()) {
            p = p.filter { i < it.length && it[i] == c }
            rst.add(p.take(3))
        }

        return rst
    }
}