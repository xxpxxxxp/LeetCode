package com.ypwang.easy

class Solution2515 {
    fun closetTarget(words: Array<String>, target: String, startIndex: Int): Int {
        val idx = words.withIndex().filter { it.value == target }.map { it.index }
        if (idx.isEmpty())
            return -1
        val i = idx.binarySearch(startIndex).let {
            if (it >= 0)
                return 0
            -it-1
        }

        val left = if (i == 0) startIndex + words.size - idx.last() else startIndex - idx[i-1]
        val right = if (i == idx.size) words.size - startIndex + idx.first() else idx[i] - startIndex
        return minOf(left, right)
    }
}

fun main() {
    println(Solution2515().closetTarget(arrayOf("hello","i","am","leetcode","hello"), "hello", 1))
    println(Solution2515().closetTarget(arrayOf("a","b","leetcode"), "leetcode", 0))
    println(Solution2515().closetTarget(arrayOf("i","eat","leetcode"), "ate", 0))
}