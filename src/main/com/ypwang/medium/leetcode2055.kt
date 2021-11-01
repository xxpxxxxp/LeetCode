package com.ypwang.medium

class Solution2055 {
    fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
        // right bound, left bound, preSum
        val blocks = Array(s.length) { IntArray(3) }

        var left = -1
        var right = s.length
        var count = 0
        for (i in s.indices) {
            if (s[i] == '|')
                left = i
            else
                count++

            blocks[i][1] = left

            if (s[s.lastIndex-i] == '|')
                right = s.lastIndex-i

            blocks[s.lastIndex-i][0] = right
            blocks[i][2] = count
        }

        return queries.map { (s, e) ->
            val r = blocks[s][0]
            val l = blocks[e][1]

            if (l <= r)
                0
            else
                blocks[l][2] - blocks[r][2]
        }.toIntArray()
    }
}

fun main() {
    println(Solution2055().platesBetweenCandles("**|**|***|", arrayOf(intArrayOf(2,5), intArrayOf(5,9))).toList())
    println(Solution2055().platesBetweenCandles("***|**|*****|**||**|*", arrayOf(intArrayOf(1,17), intArrayOf(4,5), intArrayOf(14,17), intArrayOf(5,11),
        intArrayOf(15,16))).toList())
}