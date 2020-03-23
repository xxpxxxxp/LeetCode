package com.ypwang.medium

class Solution1386 {
    data class NoTaken(var left: Boolean = true, var middle: Boolean = true, var right: Boolean = true)

    fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
        val noTaken = mutableMapOf<Int, NoTaken>()

        for ((i, j) in reservedSeats) {
            if (i !in noTaken)
                noTaken[i] = NoTaken()

            if (j == 2 || j == 3) noTaken[i]!!.left = false
            if (j == 4 || j == 5) {
                noTaken[i]!!.left = false
                noTaken[i]!!.middle = false
            }
            if (j == 6 || j == 7) {
                noTaken[i]!!.middle = false
                noTaken[i]!!.right = false
            }
            if (j == 8 || j == 9) noTaken[i]!!.right = false
        }

        return noTaken.values.sumBy {
            var c = 0
            if (it.left) c++
            if (it.right) c++
            when {
                c > 0 -> c
                it.middle -> 1
                else -> 0
            }
        } + (n - noTaken.size) * 2
    }
}

fun main() {
    println(Solution1386().maxNumberOfFamilies(3, arrayOf(
            intArrayOf(1,2),intArrayOf(1,3),intArrayOf(1,8),intArrayOf(2,6),intArrayOf(3,1),intArrayOf(3,10))
    ))
}