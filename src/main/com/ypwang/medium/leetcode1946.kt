package com.ypwang.medium

class Solution1946 {
    fun maximumNumber(num: String, change: IntArray): String {
        val i = num.indexOfFirst {
            val c = it - '0'
            change[c] > c
        }

        if (i == -1)
            return num

        var j = i+1
        while (j < num.length && num[j].let {
                val c = it - '0'
                change[c] >= c
        })
            j++

        return num.substring(0, i) + (i until j).map { '0' + change[num[it] - '0'] }.joinToString("") + num.substring(j)
    }
}

fun main() {
    println(Solution1946().maximumNumber("021", intArrayOf(9,4,3,5,7,2,1,9,0,6)))
}