package com.ypwang.medium

class Solution556 {
    fun nextGreaterElement(n: Int): Int {
        val post = mutableListOf<Int>()
        var nn = n

        fun binarySearch(cur: Int): Int {
            // if cur not in post, return the left most idx bigger than cur
            var l = 0
            var r = post.lastIndex

            while (l < r) {
                val mid = (l + r) / 2
                if (post[mid] <= cur) l = mid + 1
                else r = mid
            }

            return l
        }

        while (nn != 0) {
            val cur = nn % 10
            if (post.isNotEmpty() && cur < post.last()) {
                val idx = binarySearch(cur)
                nn = nn - cur + post[idx]
                post[idx] = cur
                return post.fold(nn) label@{
                    c, it ->
                        val t = c * 10 + it
                        if (t / 10 != c) return -1
                        else return@label t
                }
            }
            post.add(cur)
            nn /= 10
        }

        return -1
    }
}

fun main() {
    println(Solution556().nextGreaterElement(1999999999))
    println(Solution556().nextGreaterElement(12443322))
    println(Solution556().nextGreaterElement(12222333))
    println(Solution556().nextGreaterElement(230241))
    println(Solution556().nextGreaterElement(21))
    println(Solution556().nextGreaterElement(12))
}