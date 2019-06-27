package com.ypwang.easy

class Solution1089 {
    fun duplicateZeros(arr: IntArray) {
        var j = arr.size + arr.count { it == 0 }
        for (i in arr.lastIndex downTo 0) {
            if (--j < arr.size)
                arr[j] = arr[i]
            if (arr[i] == 0 && --j < arr.size)
                arr[j] = 0
        }
    }
}

fun main() {
    println(Solution1089().duplicateZeros(intArrayOf(1,0,2,3,0,4,5,0)))
}