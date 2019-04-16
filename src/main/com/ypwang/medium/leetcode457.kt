package com.ypwang.medium

class Solution457 {
    fun circularArrayLoop(nums: IntArray): Boolean {
        val size =  nums.size
        val idx = (0 until size).toMutableSet()

        while (idx.isNotEmpty()) {
            val begin = idx.first()
            val round = mutableSetOf(begin)

            var cur = ((begin + nums[begin]) % size + size) % size
            while (cur !in round && cur in idx) {
                round.add(cur)
                cur = ((cur + nums[cur]) % size + size) % size
            }

            if (cur !in idx) {
                idx.removeAll(round)
                continue
            }

            idx.removeAll(round)

            // now we have a circle, check if this circle has len > 1 && same direction
            val start = cur
            val direction = mutableListOf(nums[cur] > 0)
            while (true) {
                cur = ((cur + nums[cur]) % size + size) % size
                if (cur == start) break
                direction.add(nums[cur] > 0)
            }

            if (direction.size < 2) continue
            val t = direction.count { it }
            if (t == direction.size || t == 0) return true
        }

        return false
    }
}

fun main() {
    println(Solution457().circularArrayLoop(intArrayOf(2,-1,1,2,2)))
    println(Solution457().circularArrayLoop(intArrayOf(-1,2)))
    println(Solution457().circularArrayLoop(intArrayOf(-2,1,-1,-2,-2)))
}