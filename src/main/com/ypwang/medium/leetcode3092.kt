package com.ypwang.medium

class Solution3092 {
    fun mostFrequentIDs(nums: IntArray, freq: IntArray): LongArray {
        val rst = LongArray(nums.size)
        val idToFreqMap = mutableMapOf<Int, Long>()
        val freqToIdCountMap = sortedMapOf<Long, Int>()

        for (i in nums.indices) {
            val id = nums[i]
            if (id in idToFreqMap) {
                val prevFreq = idToFreqMap[id]!!
                freqToIdCountMap[prevFreq] = freqToIdCountMap[prevFreq]!! - 1
                if (freqToIdCountMap[prevFreq] == 0)
                    freqToIdCountMap.remove(prevFreq)
            }

            val tmp = idToFreqMap.getOrDefault(id, 0L) + freq[i]
            idToFreqMap[id] = tmp
            freqToIdCountMap[tmp] = freqToIdCountMap.getOrDefault(tmp, 0) + 1
            rst[i] = freqToIdCountMap.lastKey()
        }

        return rst
    }
}

fun main() {
    println(Solution3092().mostFrequentIDs(intArrayOf(2,3,2,1), intArrayOf(3,2,-3,1)).toList())
}
