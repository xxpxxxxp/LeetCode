package com.ypwang.easy

class Solution4020 {
    fun elevatorRequests(n: Int, requests: IntArray): Int =
        requests.fold((0 to 0)) { (c, s), f ->
            f to (s + Math.abs(c - f))
        }.second
}
