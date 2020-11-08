package com.ypwang.hard

class Solution1649 {
    // [i, j]
    private fun mergeSort(arr: Array<IntArray>, i: Int, j: Int) {
        if (i + 1 == j)
            return

        val half = (i+j) / 2
        mergeSort(arr, i, half)
        mergeSort(arr, half, j)

        val cp = arr.copyOfRange(i, j)
        var f = i
        var e = i
        var idx = 0
        for (x in half until j) {
            while (f < half && arr[f][0] < arr[x][0]) {
                cp[idx++] = arr[f++]
            }
            arr[x][1] += f - i
            while (e < half && arr[e][0] <= arr[x][0]) {
                e++
            }
            arr[x][2] += half - e

            cp[idx++] = arr[x]
        }

        for (x in f until half) {
            cp[idx++] = arr[x]
        }

        System.arraycopy(cp, 0, arr, i, j-i)
    }

    fun createSortedArray(instructions: IntArray): Int =
        Array(instructions.size) { intArrayOf(instructions[it], 0, 0) }
                .apply { mergeSort(this, 0, this.size) }
                .map { minOf(it[1], it[2]) }
                .reduce{ a, b -> (a + b) % 1000000007 }
}

fun main() {
    println(Solution1649().createSortedArray(intArrayOf(1,5,6,2)))
    println(Solution1649().createSortedArray(intArrayOf(1,2,3,6,5,4)))
    println(Solution1649().createSortedArray(intArrayOf(1,3,3,3,2,4,2,1,2)))
}