package com.ypwang.easy

class Solution2651 {
    fun findDelayedArrivalTime(arrivalTime: Int, delayedTime: Int): Int =
        (arrivalTime + delayedTime) % 24
}