package com.ypwang.medium

import java.util.LinkedList
import java.util.Queue

class Solution3690 {
    fun minSplitMerge(nums1: IntArray, nums2: IntArray): Int {
        if (nums1.contentEquals(nums2))
            return 0
        val n = nums1.size
        val vis = mutableSetOf<List<Int>>()
        vis.add(nums1.toList())
        val q: Queue<Pair<List<Int>, Int>> = LinkedList()
        q.add(Pair(nums1.toList(), 0))

        while (q.isNotEmpty()) {
            val (node, d) = q.poll()

            for (i in 0 until n) {
                for (j in i until n) {
                    val sub = node.subList(i, j + 1)
                    val remaining = mutableListOf<Int>()
                    for (k in 0 until i)
                        remaining.add(node[k])

                    for (k in j + 1 until n)
                        remaining.add(node[k])

                    for (a in 0..remaining.size) {
                        if (a == i)
                            continue
                        val newList = mutableListOf<Int>()
                        for (k in 0 until a)
                            newList.add(remaining[k])

                        newList.addAll(sub)
                        for (k in a until remaining.size)
                            newList.add(remaining[k])

                        if (newList in vis) continue
                        if (newList == nums2.toList())
                            return d + 1
                        vis.add(newList)
                        q.add(Pair(newList, d + 1))
                    }
                }
            }
        }
        return 0
    }
}
