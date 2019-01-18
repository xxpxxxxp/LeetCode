package com.ypwang.medium

class Solution869 {
    fun reorderedPowerOf2(N: Int): Boolean {
        val all = (0..31).map { (1 shl it).toString() }.map {
            it.groupBy { c -> c }.mapValues { c -> c.value.size }
        }.toSet()

        return N.toString().groupBy { c -> c }.mapValues { it.value.size } in all
    }
}

fun main(args: Array<String>) {
    println(Solution869().reorderedPowerOf2(16))
}