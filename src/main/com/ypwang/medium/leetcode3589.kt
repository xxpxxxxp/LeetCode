package com.ypwang.medium

import java.util.TreeMap

class Solution3589 {
    fun sieveOfEratosthenes(n: Int): BooleanArray {
        val prime = BooleanArray(n + 1) { true }
        prime[0] = false
        prime[1] = false

        var p = 2
        while (p * p <= n) {
            if (prime[p]) {
                var i = p * p
                while (i <= n) {
                    prime[i] = false
                    i += p
                }
            }
            p++
        }

        return prime
    }

    fun primeSubarray(nums: IntArray, k: Int): Int {
        val n = nums.size
        val isPrime = sieveOfEratosthenes(50005)

        val prefSum = IntArray(n)
        prefSum[0] = if (isPrime[nums[0]]) 1 else 0
        for (i in 1..<n)
            prefSum[i] = prefSum[i - 1] + (if (isPrime[nums[i]]) 1 else 0)

        val startFrom = IntArray(n) { -1 }
        for (i in 0 until n) {
            var start = i
            var end = n - 1
            var idx = -1
            while (start <= end) {
                val mid = start + (end - start) / 2
                val total = prefSum[mid] - (if (i > 0) prefSum[i - 1] else 0)
                if (total >= 2) {
                    idx = mid
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            }
            startFrom[i] = idx
        }

        var ans = 0
        val primeCount = TreeMap<Int, Int>()
        var j = 0
        for (i in 0 until n) {
            if (startFrom[i] == -1)
                break

            while (j < n) {
                if (isPrime[nums[j]])
                    primeCount.put(nums[j], primeCount.getOrDefault(nums[j], 0) + 1)

                if (primeCount.size >= 2) {
                    val min = primeCount.firstKey()!!
                    val max = primeCount.lastKey()!!
                    if (max - min > k) {
                        if (isPrime[nums[j]]) {
                            val count = primeCount.get(nums[j])!!
                            if (count == 1)
                                primeCount.remove(nums[j])
                            else
                                primeCount.put(nums[j], count - 1)
                        }
                        break
                    }
                }

                j++
            }

            if (j > startFrom[i])
                ans += (j - startFrom[i])

            if (isPrime[nums[i]]) {
                val count = primeCount.get(nums[i])!!
                if (count == 1)
                    primeCount.remove(nums[i])
                else
                    primeCount.put(nums[i], count - 1)
            }
        }

        return ans
    }
}
