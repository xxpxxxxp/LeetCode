package com.ypwang.hard

class Solution1349 {
    private fun backTrack(seats: Array<CharArray>, cache: Array<IntArray>, idx: Int, curMask: Int, row: Int, preMask: Int): Int {
        if (idx == seats[0].size) return getMax(seats, cache, row + 1, curMask)
        var rst = backTrack(seats, cache, idx + 1, curMask, row, preMask)           // don't seat here
        // check if we could sit here
        if (seats[row][idx] == '.'                                                      // current idx is a seat
                && (idx == 0 || curMask and (1 shl (idx - 1)) == 0)                     // left is not seated
                && (idx == 0 || preMask and (1 shl (idx - 1)) == 0)                     // up-left is not seated
                && (idx == seats[0].lastIndex || preMask and (1 shl (idx + 1)) == 0)    // up-right is not seated
        )
            rst = maxOf(rst, 1 + backTrack(seats, cache, idx + 1, curMask or (1 shl idx), row, preMask))

        return rst
    }

    private fun getMax(seats: Array<CharArray>, cache: Array<IntArray>, row: Int, preMask: Int): Int {
        if (row == seats.size) return 0
        if (cache[row][preMask] == -1)
            cache[row][preMask] = backTrack(seats, cache,0, 0, row, preMask)
        return cache[row][preMask]
    }

    fun maxStudents(seats: Array<CharArray>): Int =
        getMax(seats, Array(seats.size){ IntArray(1 shl seats[0].size){ -1 } },0, 0)
}

fun main() {
    println(Solution1349().maxStudents(
            arrayOf("#.##.#".toCharArray(), ".####.".toCharArray(), "#.##.#".toCharArray())
    ))
}