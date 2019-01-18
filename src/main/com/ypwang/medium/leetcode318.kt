package com.ypwang.medium

class Solution318 {
    fun maxProduct(words: Array<String>): Int {
        fun helper(word: String): Int {
            var rst = 0
            word.forEach{ rst = rst or (1 shl (it - 'a')) }
            return rst
        }

        val ws = words.map { helper(it) }.zip(words)
        var rst = 0
        for ((i, x) in ws) {
            for ((j, y) in ws) {
                if (i and j == 0) {
                    rst = Math.max(rst, x.length * y.length)
                }
            }
        }
        return rst
    }
}