package com.ypwang.easy

class Solution1672 {
    fun maximumWealth(accounts: Array<IntArray>): Int = accounts.map { it.sum() }.max()!!
}