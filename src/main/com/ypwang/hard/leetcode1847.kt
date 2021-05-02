package com.ypwang.hard

class Solution1847 {
    fun closestRoom(rooms: Array<IntArray>, queries: Array<IntArray>): IntArray {
        rooms.sortByDescending { it[1] }

        val ans = IntArray(queries.size)
        val available = mutableListOf<Int>()
        var idx = 0
        for ((i, query) in queries.withIndex().sortedByDescending { it.value[1] }) {
            val (prefer, minimize) = query
            while (idx < rooms.size && rooms[idx][1] >= minimize) {
                val id = rooms[idx++][0]
                val x = available.binarySearch(id).let { if (it < 0) -it-1 else it }
                available.add(x, id)
            }

            if (available.isEmpty())
                ans[i] = -1
            else {
                val y = available.binarySearch(prefer)
                if (y >= 0)
                    ans[i] = available[y]
                else {
                    val z = -y-1
                    var diff = Int.MAX_VALUE
                    if (z < available.size) {
                        ans[i] = available[z]
                        diff = available[z] - prefer
                    }
                    if (z > 0 && prefer - available[z-1] <= diff) {
                        ans[i] = available[z-1]
                    }
                }
            }
        }

        return ans
    }
}