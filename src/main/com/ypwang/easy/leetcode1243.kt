package com.ypwang.easy

class Solution1243 {
    fun transformArray(arr: IntArray): List<Int> {
        var changed = false
        do {
            changed = false
            val cp = arr.clone()
            for (i in 1 until arr.lastIndex) {
                if (arr[i] < cp[i-1] && arr[i] < cp[i+1]) {
                    arr[i]++
                    changed = true
                } else if (arr[i] > cp[i-1] && arr[i] > cp[i+1]) {
                    arr[i]--
                    changed = true
                }
            }
        } while (changed)
        return arr.toList()
    }
}

fun main() {
    println(Solution1243().transformArray(intArrayOf(6,2,3,4)))
}