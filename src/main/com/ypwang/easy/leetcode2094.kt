package com.ypwang.easy

class Solution2094 {
    fun findEvenNumbers(digits: IntArray): IntArray {
        val cnt = digits.groupBy { it }
            .map { it.key to it.value.size }
            .toMap()
            .toMutableMap()

        val rst = mutableListOf<Int>()
        val c = intArrayOf(1, 10, 100)

        fun helper(depth: Int, pre: Int) {
            if (depth == 3) {
                if (pre > 99)
                    rst.add(pre)
                return
            }

            for ((k, _) in cnt.filter { it.value > 0 }) {
                if (depth == 0 && k % 2 == 1)
                    continue

                val next = pre + c[depth] * k
                cnt[k] = cnt[k]!!-1
                helper(depth+1, next)
                cnt[k] = cnt[k]!!+1
            }
        }

        helper(0, 0)
        return rst.sorted().toIntArray()
    }
}

fun main() {
    println(Solution2094().findEvenNumbers(intArrayOf(2,1,3,0)).toList())
    println(Solution2094().findEvenNumbers(intArrayOf(2,2,8,8,2)).toList())
    println(Solution2094().findEvenNumbers(intArrayOf(3,7,5)).toList())
    println(Solution2094().findEvenNumbers(intArrayOf(0,2,0,0)).toList())
    println(Solution2094().findEvenNumbers(intArrayOf(0,0,0)).toList())
}