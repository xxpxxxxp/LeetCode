package com.ypwang.hard

import java.util.*

class Solution2612 {
    fun minReverseOperations(n: Int, p: Int, banned: IntArray, k: Int): IntArray? {
        val even = TreeSet<Int>()
        val odd = TreeSet<Int>()

        val skip = banned.toSet()
        // Add values to the set that are not banned
        for (i in 0 until n) {
            if (i in skip || i == p)
                continue
            if (i % 2 == 1)
                odd.add(i)
            else
                even.add(i)
        }
        val result = IntArray(n) { -1 }
        val queue: Queue<Int> = LinkedList()
        queue.add(p)

        var moves = 0
        var set: TreeSet<Int>
        while (queue.isNotEmpty()) {
            var size = queue.size
            while (size-- > 0) {
                val current = queue.poll()
                result[current] = moves

                // calculate min index
                var min =
                    if (current < k - 1)
                        k - 1 - current
                    else
                        current - k + 1

                // calculate max index
                val mCurrent = n - 1 - current
                var max =
                    if (mCurrent < k - 1)
                        k - 1 - mCurrent
                    else
                        mCurrent - k + 1
                max = n - 1 - max

                // chose the correct parity set
                set = if (min % 2 == 0) even else odd
                var key = set.ceiling(min)

                // add all values in range to the queue and remove from set
                while (key != null && key <= max) {
                    queue.add(key)
                    set.remove(key)
                    key = set.ceiling(min)
                }
            }
            ++moves
        }
        return result
    }
}
