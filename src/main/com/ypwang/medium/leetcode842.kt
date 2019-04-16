package com.ypwang.medium

class Solution842 {
    fun splitIntoFibonacci(S: String): List<Int> {
        val nums = S.map { it - '0' }
        val rst = mutableListOf<Int>()

        for (i in 1..nums.size / 2) {
            if (nums[0] == 0 && i > 1) break
            var f = 0
            for (c in 0 until i) f = f * 10 + nums[c]

            for (j in i+1..(nums.size + i) / 2) {
                var ff = f
                if (nums[i] == 0 && j-i > 1) break

                var s = 0
                for (c in i until j) s = s * 10 + nums[c]

                var idx = j
                rst.add(ff)
                rst.add(s)
                while (true) {
                    val sum = ff + s
                    ff = s
                    s = sum
                    rst.add(s)

                    val str = sum.toString()
                    if (idx + str.length > S.length || S.substring(idx, idx + str.length) != str)
                        break

                    idx += str.length
                    if (idx == S.length) return rst
                }

                rst.clear()
            }
        }

        return listOf()
    }
}

fun main() {
    println(Solution842().splitIntoFibonacci("112358130"))
}