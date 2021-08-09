package com.ypwang.hard

class Solution1964 {
    fun longestObstacleCourseAtEachPosition(obstacles: IntArray): IntArray {
        // pair: obstacle, max len
        // obstacle inc, max len inc
        val list = mutableListOf(0 to 0)
        val rst = IntArray(obstacles.size)

        for ((i, obstacle) in obstacles.withIndex()) {
            var idx = list.binarySearch { it.first - obstacle }.let {
                if (it < 0) -it-2 else it
            }

            val len = list[idx].second + 1

            if (list[idx].first == obstacle)
                list.removeAt(idx--)

            val j = idx+1
            if (j < list.size) {
                val (o, l) = list[j]
                if (l == len && o > obstacle)
                    list.removeAt(j)
            }

            if (j == list.size || len != list[j].second)
                list.add(j, obstacle to len)

            rst[i] = len
        }

        return rst
    }
}

fun main() {
    println(Solution1964().longestObstacleCourseAtEachPosition(intArrayOf(5,3,4,4,4,2,1,1,4,1)).toList())
    println(Solution1964().longestObstacleCourseAtEachPosition(intArrayOf(1,2,3,2)).toList())
    println(Solution1964().longestObstacleCourseAtEachPosition(intArrayOf(2,2,1)).toList())
    println(Solution1964().longestObstacleCourseAtEachPosition(intArrayOf(3,1,5,6,4,2)).toList())
}