package com.ypwang.medium

class Solution3766 {
    private fun isPalindrome(x: Int): Boolean {
        val bin = x.toString(2)
        return bin == bin.reversed()
    }

    fun minOperations(nums: IntArray): IntArray {
        // Precompute palindromes from 1..5000
        val palindromes = mutableListOf<Int>()
        for (i in 1..5000) {
            if (isPalindrome(i))
                palindromes.add(i)
        }

        val ans = IntArray(nums.size)
        for ((i, num) in nums.withIndex()) {
            // binary search
            val idx = palindromes.binarySearch(num)
            val insertPos = if (idx >= 0) idx else -(idx + 1)

            var closest = 5000

            // next larger or equal palindrome
            if (insertPos < palindromes.size)
                closest = palindromes[insertPos] - num
            // previous palindrome
            if (insertPos > 0)
                closest = minOf(closest, num - palindromes[insertPos - 1])

            ans[i] = closest
        }

        return ans
    }
}
