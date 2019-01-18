package com.ypwang.easy

class Solution717 {
    fun isMeaningful(bits: IntArray): Boolean {
        if (bits.size <= 2) {
            return !(bits contentEquals intArrayOf(0, 1) || bits contentEquals intArrayOf(1))
        }

        if (bits.last() == 1) {
            // only possible 11
            return bits[bits.lastIndex-1] == 1 && isMeaningful(bits.take(bits.size-2).toIntArray())
        } else {
            return isMeaningful(bits.take(bits.size-2).toIntArray()) || isMeaningful(bits.take(bits.size-1).toIntArray())
        }
    }

    fun isOneBitCharacter(bits: IntArray): Boolean {
        return isMeaningful(bits.take(bits.size-1).toIntArray())
    }
}

fun main(args: Array<String>) {
    println(Solution717().isOneBitCharacter(intArrayOf(0, 0, 1, 0)))
}