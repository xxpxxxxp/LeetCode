package com.ypwang.medium

class Solution1040 {
    fun numMovesStonesII(stones: IntArray): IntArray {
        stones.sort()
        var low = stones.size
        var i = 0
        for (j in 0 until stones.size) {
            while (stones[j] - stones[i] >= stones.size) i++
            low = if (j - i + 1 == stones.size - 1 /* [i,j] only have 1 hole left */ &&
                    stones[j] - stones[i] == stones.size - 2 /* [i,j] is consecutive, or else it should have 1 hole */)
                minOf(low, 2)
            else minOf(low, stones.size - (j - i + 1))
        }

        return intArrayOf(low, maxOf(
                /* consider move left to right
                First move will take the first element into left ranges
                For init range of [stones.first(), stones.last()]
                The first move take stones.first() into range [stones[1], stones.last()]
                Then every 'hole' in that range will take 1 move
                So the total move is
                stones.last() - stones[1] + 1       // this is the range len after first move
                - stones.size                       // minus total size is the number of 'hole'
                + 1                                 // don't forget the first move
                */
                stones.last() - stones.size + 2 - stones[1],
                stones[stones.size - 2] - stones.first() - stones.size + 2))
    }
}