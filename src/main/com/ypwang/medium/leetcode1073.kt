package com.ypwang.medium

class Solution1073 {
    fun addNegabinary(arr1: IntArray, arr2: IntArray): IntArray {
        var remain = 0

        val rst = mutableListOf<Int>()

        var i = arr1.lastIndex
        var j = arr2.lastIndex

        while (i >= 0 && j >= 0) {
            remain = when (val cur = arr1[i] + arr2[j] - remain) {
                -1 -> {
                    rst.add(0, 1)
                    -1
                }
                else -> {
                    rst.add(0, cur % 2)
                    cur / 2
                }
            }

            i--
            j--
        }

        while (i >= 0) {
            remain = when (val cur = arr1[i] - remain) {
                -1 -> {
                    rst.add(0, 1)
                    -1
                }
                else -> {
                    rst.add(0, cur % 2)
                    cur / 2
                }
            }

            i--
        }

        while (j >= 0) {
            remain = when (val cur = arr2[j] - remain) {
                -1 -> {
                    rst.add(0, 1)
                    -1
                }
                else -> {
                    rst.add(0, cur % 2)
                    cur / 2
                }
            }

            j--
        }

        when (remain) {
            1 -> rst.addAll(0, listOf(1,1))
            -1 -> rst.add(0, 1)
            else -> {}
        }

        return rst.dropWhile { it == 0 }.let { if (it.isEmpty()) intArrayOf(0) else it.toIntArray() }
    }
}

fun main() {
    println(Solution1073().addNegabinary(intArrayOf(1,0,1), intArrayOf(1,0,1)).toList())
    println(Solution1073().addNegabinary(intArrayOf(1), intArrayOf(1,1,0,1)).toList())
    println(Solution1073().addNegabinary(intArrayOf(1,1,1,1,1), intArrayOf(1,0,1)).toList())
    println(Solution1073().addNegabinary(intArrayOf(1), intArrayOf(1,1)).toList())
    println(Solution1073().addNegabinary(intArrayOf(1), intArrayOf(1,0,1)).toList())
}