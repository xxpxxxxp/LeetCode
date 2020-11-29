package com.ypwang.medium

class RLEIterator(val A: IntArray) {
    private var offset = 0
    private var index = 0
    fun next(n: Int): Int {
        var countDown = n

        while (index < A.size) {
            val cur = A[index]
            if (offset + countDown <= cur) {
                offset += countDown
                return A[index+1]
            } else {
                index += 2
                countDown -= cur - offset
                offset = 0
            }
        }
        return -1
    }
}

fun main() {
    val a = RLEIterator(intArrayOf(3,8,0,9,2,5))
    println(a.next(2))
    println(a.next(1))
    println(a.next(1))
    println(a.next(2))
}