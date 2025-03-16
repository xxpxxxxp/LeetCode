package com.ypwang.easy

class Solution3483 {
    fun totalNumbers(digits: IntArray): Int {
        val arr = IntArray(10)
        for (i in digits)
            arr[i]++

        return (100 until 1000 step 2).count {
            it.toString().groupBy { c -> c }.all { kv ->
                arr[kv.key - '0'] >= kv.value.size
            }
        }
    }
}
