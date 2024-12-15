package com.ypwang.medium

class Solution3388 {
    fun beautifulSplits(nums: IntArray): Int {
        val n = nums.size
        if (n < 3)
            return 0

        val mod = 1000000007L
        val base = 31L

        val prefixHash = LongArray(n + 1) // Hash for prefix [0..i)
        val pow = LongArray(n + 1) // Store powers of base

        pow[0] = 1
        for (i in 0 until n) {
            pow[i + 1] = (pow[i] * base) % mod
            prefixHash[i + 1] = (prefixHash[i] * base + nums[i]) % mod
        }

        var count = 0
        for (i in 1 until n - 1) {
            for (j in i + 1 until n) {
                var valid = false

                if (isPrefix(prefixHash, 0, i, i, j, mod, pow)) {
                    valid = true
                    count++
                    continue
                }

                if (isPrefix(prefixHash, i, j, j, n, mod, pow)) {
                    valid = true
                    count++
                }
            }
        }

        return count
    }

    // Helper function to compare hashes of two subarrays
    private fun isPrefix(hash: LongArray, start1: Int, end1: Int, start2: Int, end2: Int, mod: Long, pow: LongArray): Boolean {
        val len1 = end1 - start1
        val len2 = end2 - start2

        if (len1 > len2)
            return false

        val hash1 = (hash[end1] - (hash[start1] * pow[len1]) % mod + mod) % mod
        val hash2 = (hash[start2 + len1] - (hash[start2] * pow[len1]) % mod + mod) % mod

        return hash1 == hash2
    }
}
