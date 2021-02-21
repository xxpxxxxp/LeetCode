package com.ypwang.medium

class Solution1764 {
    fun canChoose(groups: Array<IntArray>, nums: IntArray): Boolean {
        fun search(arr: IntArray, startIdx: Int): Int {
            for (i in startIdx..nums.size - arr.size) {
                if (arr.indices.all { arr[it] == nums[i+it] })
                    return i
            }

            return -1
        }

        var idx = 0
        for (arr in groups) {
            idx = search(arr, idx)
            if (idx == -1)
                return false

            idx += arr.size
        }

        return true
    }
}

fun main() {
    println(Solution1764().canChoose(arrayOf(
        intArrayOf(1,-1,-1), intArrayOf(3,-2,0)), intArrayOf(1,-1,0,1,-1,-1,3,-2,0)
    ))
}