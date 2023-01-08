package com.ypwang.medium

class DataStream(private val value: Int, private val k: Int) {
    private var counter = 0
    fun consec(num: Int): Boolean {
        if (num == value)
            counter++
        else
            counter = 0

        return counter >= k
    }
}