package com.ypwang.hard

class Solution1235 {
    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val ps = Array(startTime.size){ Triple(startTime[it], endTime[it], profit[it]) }.sortedBy { it.first }
        val t = ArrayList<Pair<Int, Int>>()
        t.add(0 to 0)

        for ((s, e, p) in ps) {
            val idx = t.binarySearch { it.first - s }.let { if (it < 0) -it-2 else it }
            val sum = t[idx].second + p
            val ins = t.binarySearch { it.first - e }.let { if (it < 0) -it-1 else it }

            if (sum > t[ins-1].second) {
                while (ins < t.size)
                    if (t[ins].second < sum) t.removeAt(ins) else break
                t.add(ins, e to sum)
            }
        }

        return t.last().second
    }
}

fun main() {
    println(Solution1235().jobScheduling(intArrayOf(1,2,3,4,6), intArrayOf(3,5,10,6,9), intArrayOf(20,20,100,70,60)))
    println(Solution1235().jobScheduling(intArrayOf(1,1,1), intArrayOf(2,3,4), intArrayOf(5,6,4)))
}