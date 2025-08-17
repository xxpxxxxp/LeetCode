package com.ypwang.hard

class Solution3655 {
    fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
        val mod = 1000000007L
        val map = mutableMapOf<Long, Int>()

        for ((l, r, k, v)in queries) {
            val key = l * 10000000000L + r * 100000L + k
            map[key] = ((map.getOrDefault(key, 1) * v.toLong()) % mod).toInt()
        }

        for ((key, v) in map) {
            val L = key / 10000000000L
            val R = (key / 100000L) % 100000
            val K = key % 100000

            var i = L.toInt()
            while (i <= R.toInt()) {
                nums[i] = ((nums[i].toLong() * v) % mod).toInt()
                i += K.toInt()
            }
        }

        return nums.reduce { a, b -> a xor b }
    }
}
