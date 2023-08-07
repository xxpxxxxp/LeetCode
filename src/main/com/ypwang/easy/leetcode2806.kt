package com.ypwang.easy

class Solution2806 {
    fun accountBalanceAfterPurchase(purchaseAmount: Int): Int = 100 - (10 * Math.round(purchaseAmount / 10.0)).toInt()
}