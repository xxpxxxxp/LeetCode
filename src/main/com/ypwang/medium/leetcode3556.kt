package com.ypwang.medium

class Solution3556 {
    private fun isPrime(num: Long): Boolean {
        if (num <= 1)
            return false

        if (num <= 3)
            return true

        if (num % 2 == 0L || num % 3 == 0L)
            return false

        var i = 5L
        while (i * i <= num) {
            if (num % i == 0L || num % (i + 2) == 0L)
                return false
            i = i + 6
        }
        return true
    }

    fun sumOfLargestPrimes(s: String): Long {
        val primesFound = mutableSetOf<Long>()
        val n = s.length

        if (n == 0)
            return 0

        for (i in 0 until n) {
            var currentNum = (s[i] - '0').toLong()

            if (isPrime(currentNum))
                primesFound.add(currentNum)

            for (j in i + 1..<n) {
                val digit = s[j] - '0'
                if (currentNum > Long.MAX_VALUE / 10 ||
                    (currentNum == Long.MAX_VALUE / 10 && digit > Long.MAX_VALUE % 10)
                )
                    break

                currentNum = currentNum * 10 + digit
                if (isPrime(currentNum))
                    primesFound.add(currentNum)
            }
        }

        if (primesFound.isEmpty())
            return 0

        return primesFound.sortedDescending().take(3).sum()
    }
}
