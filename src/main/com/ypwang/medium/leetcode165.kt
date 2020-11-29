package com.ypwang.medium

class Solution165 {
    fun compareVersion(version1: String, version2: String): Int {
        val v1 = version1.split('.').map { it.toInt() }.iterator()
        val v2 = version2.split('.').map { it.toInt() }.iterator()

        while (v1.hasNext() || v2.hasNext()) {
            val l1 = if (v1.hasNext()) v1.next() else 0
            val l2 = if (v2.hasNext()) v2.next() else 0

            when {
                l1 < l2-> return -1
                l1 > l2 -> return 1
                else -> {}
            }
        }

        return 0
    }
}

fun main() {
    println(Solution165().compareVersion("1.0", "1.0.0"))
}