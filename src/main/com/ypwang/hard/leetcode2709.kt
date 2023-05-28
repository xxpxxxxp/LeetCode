package com.ypwang.hard

class Solution2709 {
    fun canTraverseAllPairs(nums: IntArray): Boolean {
        val primes = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
            53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131,
            137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223,
            227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313)

        val representive = mutableMapOf<Int, Int>()
        val dsu = IntArray(nums.size) { it }

        fun root(i: Int): Int {
            if (dsu[i] != i)
                dsu[i] = root(dsu[i])
            return dsu[i]
        }

        fun union(i: Int, j: Int) {
            dsu[root(i)] = root(j)
        }

        for ((i, n) in nums.withIndex()) {
            var nn = n
            for (p in primes) {
                if (nn % p == 0) {
                    if (p !in representive)
                        representive[p] = i
                    else
                        union(i, representive[p]!!)

                    while (nn % p == 0)
                        nn /= p
                }
            }

            if (nn > 1) {
                if (nn !in representive)
                    representive[nn] = i
                else
                    union(i, representive[nn]!!)
            }
        }

        val r = root(0)
        return nums.indices.all { root(it) == r }
    }
}

fun main() {
    println(Solution2709().canTraverseAllPairs(intArrayOf(2,3,6)))
    println(Solution2709().canTraverseAllPairs((intArrayOf(3,5,9))))
}