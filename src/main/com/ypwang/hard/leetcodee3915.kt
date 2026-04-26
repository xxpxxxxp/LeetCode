package com.ypwang.hard

class Solution3915 {
    class Fenwick(var n: Int) {
        val tree = LongArray(n + 1)

        fun update(i: Int, `val`: Long) {
            var i = i
            while (i <= n) {
                tree[i] = maxOf(tree[i], `val`)
                i += (i and -i)
            }
        }

        fun query(i: Int): Long {
            var i = i
            var ans = 0L
            while (i > 0) {
                ans = maxOf(ans, tree[i])
                i -= (i and -i)
            }
            return ans
        }
    }

    fun maxAlternatingSum(nums: IntArray, k: Int): Long {
        val n = nums.size

        val sorted = nums.sorted()

        val map = mutableMapOf<Int, Int>()
        var ind = 1
        for (x in sorted)
            if (x !in map)
                map[x] = ind++

        val size = ind + 2

        val up = Fenwick(size)
        val down = Fenwick(size)
        val suffix = Fenwick(size)

        val dup = LongArray(n)
        val ddown = LongArray(n)

        var ans = 0L

        for (i in 0 until n) {
            val `val` = map[nums[i]]!!

            dup[i] = nums[i].toLong()
            ddown[i] = nums[i].toLong()

            if (i - k >= 0) {
                val j = i - k
                val vj = map[nums[j]]!!

                up.update(vj, dup[j])
                down.update(vj, ddown[j])

                suffix.update(size - vj + 1, dup[j])
            }

            val bestDown = down.query(`val` - 1)

            if (bestDown > 0)
                dup[i] = maxOf(dup[i], bestDown + nums[i])

            val bestUp = suffix.query(size - `val`)
            if (bestUp > 0)
                ddown[i] = maxOf(ddown[i], bestUp + nums[i])

            ans = maxOf(ans, dup[i], ddown[i])
        }
        return ans
    }
}
