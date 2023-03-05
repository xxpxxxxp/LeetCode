package com.ypwang.medium

class Solution2584 {
    private fun sieve(): List<Int> {
        val rst = BooleanArray(1001){ true }
        rst[0] = false
        rst[1] = false
        for (i in 2..1000) {
            if (rst[i]) {
                for (j in 2 until 1000) {
                    if (i * j > 1000)
                        break
                    rst[i * j] = false
                }
            }
        }

        return rst.withIndex().filter { it.value }.map { it.index }
    }

    fun findValidSplit(nums: IntArray): Int {
        val primes = sieve()
        fun factorize(n: Int): List<Int> {
            var n = n
            val rst = mutableListOf<Int>()
            for (i in primes) {
                if (n == 1)
                    break
                if (n % i == 0) {
                    rst.add(i)
                    while (n % i == 0)
                        n /= i
                }
            }
            if (n > 1)
                rst.add(n)
            return rst
        }

        val left = mutableMapOf<Int, Int>()
        val right = nums.flatMap { factorize(it) }.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        for (i in 0 until nums.lastIndex) {
            for (j in factorize(nums[i])) {
                right[j] = right[j]!!-1
                if (right[j] == 0)
                    left.remove(j)
                else
                    left[j] = left.getOrDefault(j, 0) + 1

                if (left.isEmpty())
                    return i
            }
        }
        return -1
    }
}

fun main() {
    println(Solution2584().findValidSplit(intArrayOf(557663,280817,472963,156253,273349,884803,756869,763183,557663,964357,821411,887849,891133,453379,464279,574373,852749,15031,156253,360169,526159,410203,6101,954851,860599,802573,971693,279173,134243,187367,896953,665011,277747,439441,225683,555143,496303,290317,652033,713311,230107,770047,308323,319607,772907,627217,119311,922463,119311,641131,922463,404773,728417,948281,612373,857707,990589,12739,9127,857963,53113,956003,363397,768613,47981,466027,981569,41597,87149,55021,600883,111953,119083,471871,125641,922463,562577,269069,806999,981073,857707,831587,149351,996461,432457,10903,921091,119083,72671,843289,567323,317003,802129,612373)))
}