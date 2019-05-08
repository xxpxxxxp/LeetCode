package com.ypwang.easy

class Solution1029 {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        val diff = IntArray(costs.size) { costs[it][0] - costs[it][1] }

        fun partition(left: Int, right: Int, idx: Int) {
            var l = left
            var r = right

            while (l < r) {
                val key = diff[l]
                var i = l + 1
                var j = r

                // partition based on key
                // on end, we have i == j && [l,i) <= key && (i,r] > key
                while (i < j) {
                    while (i < j && diff[i] <= key) i++
                    while (i < j && diff[j] > key) j--
                    if (i != j) {
                        val t = diff[i]
                        diff[i] = diff[j]
                        diff[j] = t
                    }
                }

                // swap key to i position
                val p = if (diff[i] <= key) i else i-1
                val t = diff[p]
                diff[p] = key
                diff[l] = t

                // now we have [l,p) <= key and (p,r] > key
                when {
                    p == idx -> return
                    p < idx -> l = p + 1
                    else -> r = p - 1
                }
            }
        }

        partition(0, diff.lastIndex, diff.size / 2)

        return costs.sumBy { it[1] } + (0 until diff.size/2).sumBy { diff[it] }
    }
}

fun main() {
    println(Solution1029().twoCitySchedCost(arrayOf(
            intArrayOf(10,20), intArrayOf(30,200), intArrayOf(400,50), intArrayOf(30,20)
    )))
}