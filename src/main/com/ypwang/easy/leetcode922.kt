package com.ypwang.easy

class Solution922 {
    fun sortArrayByParityII(A: IntArray): IntArray {
        var index = 0
        while (index < A.size) {
            if ((index % 2) != (A[index] % 2)) {
                // for sure we could find one
                var j = index + 1
                while ((index % 2) != (A[j] % 2)) {
                    j++
                }

                // swap
                val tmp = A[index]
                A[index] = A[j]
                A[j] = tmp
            }
            index++
        }
        return A
    }
}

fun main() {
    println(Solution922().sortArrayByParityII(intArrayOf(4,2,5,7)).toList())
}