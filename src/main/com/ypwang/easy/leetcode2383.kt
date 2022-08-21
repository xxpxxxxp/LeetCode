package com.ypwang.easy

class Solution2383 {
    fun minNumberOfHours(initialEnergy: Int, initialExperience: Int, energy: IntArray, experience: IntArray): Int {
        val ec = maxOf(initialEnergy, energy.sum() + 1) - initialEnergy
        var pc = 0
        var ic = initialExperience
        for (c in experience) {
            val diff = maxOf(0, c + 1 - ic)
            pc += diff
            ic += diff + c
        }

        return ec + pc
    }
}

fun main() {
    println(Solution2383().minNumberOfHours(5, 3, intArrayOf(1,4,3,2), intArrayOf(2,6,3,1)))
}