package com.ypwang.hard

class Solution975 {
    fun searchOdd(A: IntArray, idx: Int): Int {
        // To be an Odd destination, I have to be the smallest value bigger than it
        for (i in idx-1 downTo 0) {
            if (A[i] <= A[idx]) {
                return 1 + searchEven(A, i)
            }
        }

        return 0
    }

    fun searchEven(A: IntArray, idx: Int): Int {
        // To be an Even destination, I have to be the largest value smaller than it
        for (i in idx-1 downTo 0) {
            if (A[i] >= A[idx]) {
                return searchOdd(A, i)
            }
        }

        return 0
    }

    fun oddEvenJumps(A: IntArray): Int {
        return 1 + searchOdd(A, A.lastIndex) + searchEven(A, A.lastIndex)
    }
}

fun main() {
    println(Solution975().oddEvenJumps(intArrayOf(2,3,1,1,4)))
}