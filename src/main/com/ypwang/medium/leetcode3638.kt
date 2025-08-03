package com.ypwang.medium

import kotlin.math.max

class Solution3638 {
    fun maxBalancedShipments(weight: IntArray): Int {
        var res = 0
        var maxa = 0
        for (a in weight) {
            maxa = max(maxa, a)
            if (a < maxa) {
                res++
                maxa = 0
            }
        }
        return res
    }
}
