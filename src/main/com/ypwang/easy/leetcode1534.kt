package com.ypwang.easy

class Solution1534 {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var count = 0
        for (i in arr.indices) {
            val ai = arr[i]
            for (j in i+1 until arr.size) {
                val aj = arr[j]

                if (Math.abs(ai - aj) > a)
                    continue

                for (k in j+1 until arr.size) {
                    if (Math.abs(ai - arr[k]) <= c && Math.abs(aj - arr[k]) <= b)
                        count++
                }
            }
        }

        return count
    }
}