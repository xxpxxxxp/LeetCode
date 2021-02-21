package com.ypwang.hard

class Solution1766 {
    private fun gcd(a: Int, b: Int): Int {
        if (a > b)
            return gcd(b, a)

        if (a == 0)
            return b

        return gcd(b % a, a)
    }

    fun getCoprimes(nums: IntArray, edges: Array<IntArray>): IntArray {
        val rst = IntArray(nums.size)
        val relation = Array(nums.size) { mutableListOf<Int>() }

        for ((i, j) in edges) {
            relation[i].add(j)
            relation[j].add(i)
        }

        val cops = Array(51) { mutableListOf<Int>() }
        for (i in 1..50) {
            for (j in i..50) {
                if (gcd(i, j) == 1) {
                    cops[i].add(j)
                    cops[j].add(i)
                }
            }
        }

        fun helper(pre: MutableMap<Int, MutableList<Pair<Int, Int>>>, level: Int, from: Int, idx: Int) {
            rst[idx] = cops[nums[idx]].mapNotNull { pre[it]?.lastOrNull() }.maxBy { it.first }?.second ?: -1

            pre.getOrPut(nums[idx], { mutableListOf() }).add(level to idx)
            for (j in relation[idx]) {
                if (j != from)
                    helper(pre, level+1, idx, j)
            }
            pre[nums[idx]]!!.removeAt(pre[nums[idx]]!!.lastIndex)
        }

        helper(mutableMapOf(), 0, -1,0)
        return rst
    }
}

fun main() {
    println(Solution1766().getCoprimes(intArrayOf(2,3,3,2),
        arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(1,3))
    ).toList())
}