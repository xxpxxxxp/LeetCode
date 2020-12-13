package com.ypwang.medium

class Solution1689 {
    fun minPartitions(n: String): Int = n.map { it - '0' }.max()!!
}