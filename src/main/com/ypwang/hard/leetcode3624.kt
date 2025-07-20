package com.ypwang.hard

class Solution3624 {
    fun popcountDepth(nums: LongArray, queries: Array<LongArray>): IntArray {
        val maxDepth = 6 // since k (depth) can be max 5

        val bt = arrayOfNulls<FenwickTree>(maxDepth)
        for (i in 0 until maxDepth)
            bt[i] = FenwickTree(nums.size)

        // update depth index BIT
        for (i in nums.indices) {
            val depth = getPopcountDepth(nums[i])
            bt[depth]!!.update(i, 1)
        }

        val resList = mutableListOf<Int>()
        for (query in queries) {
            if (query[0] == 2L) {
                // Update query
                val oldDepth = getPopcountDepth(nums[query[1].toInt()])
                bt[oldDepth]!!.update(query[1].toInt(), -1)

                nums[query[1].toInt()] = query[2]
                val newDepth = getPopcountDepth(query[2])
                bt[newDepth]!!.update(query[1].toInt(), 1)
            } else if (query[0] == 1L) {
                // Range query
                val l = query[1].toInt()
                val r = query[2].toInt()
                val k = query[3].toInt()

                resList.add(bt[k]!!.query(r) - bt[k]!!.query(l - 1))
            }
        }

        return resList.toIntArray()
    }

    private fun getPopcountDepth(x: Long): Int {
        // Get popcount depth
        var x = x
        var depth = 0
        while (x != 1L) {
            x = x.countOneBits().toLong()
            depth++
        }
        return depth
    }

    class FenwickTree(private val n: Int) {
        private val bit = IntArray(n + 1)

        fun update(i: Int, `val`: Int) {
            var i = i
            i++
            while (i <= n) {
                bit[i] += `val`
                i += i and -i
            }
        }

        fun query(i: Int): Int {
            var i = i
            i++
            var sum = 0
            while (i > 0) {
                sum += bit[i]
                i -= i and -i
            }
            return sum
        }
    }
}
