package com.ypwang.medium

class Solution1861 {
    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        val m = box.size
        val n = box[0].size

        val rst = Array(n) { CharArray(m) { '.' } }

        for (i in 0 until m) {
            var bottom = n-1
            for (j in n-1 downTo 0) {
                when (box[i][j]) {
                    '#' ->
                        rst[bottom--][m-1-i] = '#'
                    '*' -> {
                        rst[j][m-1-i] = '*'
                        bottom = j-1
                    }
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1861().rotateTheBox(
        listOf("#.#").map { it.toCharArray() }.toTypedArray()
    ).map { it.joinToString("") })
    println(Solution1861().rotateTheBox(
        listOf("#.*.", "##*.").map { it.toCharArray() }.toTypedArray()
    ).map { it.joinToString("") })
    println(Solution1861().rotateTheBox(
        listOf("##*.*.", "###*..", "###.#.").map { it.toCharArray() }.toTypedArray()
    ).map { it.joinToString("") })
}