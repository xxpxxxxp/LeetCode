package com.ypwang.hard

class Solution1862 {
    private fun Iterable<Int>.mod() =
        this.reduce { a, b -> (a + b) % 1000000007 }

    fun sumOfFlooredPairs(nums: IntArray): Int {
        val bit = IntArray(100002)
        val max = nums.max()!!

        nums.forEach {
            var i = it + 1
            while (i <= max + 1) {
                bit[i]++
                i += i and -i
            }
        }

        fun bitSum(i: Int): Int {
            var sum = 0
            var j = i+1
            while (j > 0) {
                sum += bit[j]
                j -= j and -j
            }

            return sum
        }

        return nums.groupBy { it }.mapValues { it.value.size }.map { (n, count) ->
            (max / n downTo 1).map { count * it * (bitSum(minOf(max, (it+1) * n - 1)) - bitSum(it * n - 1)) }.mod()
        }.mod()
    }
}

fun main() {
    println(Solution1862().sumOfFlooredPairs(intArrayOf(2,5,9)))
    println(Solution1862().sumOfFlooredPairs(intArrayOf(7,7,7,7,7,7,7)))
}